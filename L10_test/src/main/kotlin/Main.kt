package org.alin

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.toList

suspend fun constantMultiplier(vector: List<Int>, alfa: Int, outputChannel: SendChannel<Int>) {
    // Primeste un vector de intregi si o constanta alfa, apoi trimite
    // fiecare element inmultit cu un alfa printr un canal
    vector.forEach() {
        outputChannel.send(it * alfa) // trimite valoarea in urmatoarea etapa din pipeline
    }
    outputChannel.close()
}

suspend fun sortingFunction(inputChannel: ReceiveChannel<Int>, outputChannel: SendChannel<Int>) {
    // primeste date intr-un canala, le colecteaza toate cu toList()
    val sorted = inputChannel.toList().sorted() // le sorteaza
    sorted.forEach() { // le trimite in outputChannel
        outputChannel.send(it)
    }
    outputChannel.close()
}

suspend fun printADT(inputChannel: ReceiveChannel<Int>) { // citeste toate datele din canal
                                                    // le afiseaza in consola
    inputChannel.toList().forEach() {
        println("$it ")
    }
}

suspend fun main() { // suspend pentru a putea folosi corutine direct in ea
    val vector = listOf(21, 34, 12, 14, 7, 9, 81, 22) // ADT-ul intreg

    val pipe1 = Channel<Int>()
    val pipe2 = Channel<Int>()

    val part1 = CoroutineScope(Dispatchers.Default).launch { // lanseaza prima corutina
                                                             // care inmulteste fiecare element cu 5 si
                                                            // le trimite in pipe1
        constantMultiplier(vector, 5, pipe1) // le trimitem in pipe1
    }

    val part2 = CoroutineScope(Dispatchers.Default).launch {
        sortingFunction(pipe1, pipe2)
    } // lanseaza corutina care sorteaza datele venite prin pipe1 si le trimite in pipe2

    val part3 = CoroutineScope(Dispatchers.Default).launch {
        printADT(pipe2)
    } // lanseaza corutina care citeste datele finale si le afiseaza

    listOf(part1, part2, part3).joinAll() // pipe1 asteapta tot ce vine din constantMultiplier dupa care este inchis si
                                         // output ul este dus in pipe2


//    pipe1.close()
//    pipe2.close()

}


