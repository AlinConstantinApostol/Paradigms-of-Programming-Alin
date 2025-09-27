package org.alex

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun sum(n: Int) : Int {
    var summ = 0
    for(i in 1..n) {
        summ += i
    }
    return summ
}

fun main() = runBlocking<Unit> {
    launch {
        print("CORUTINA 1: Suma 15: " + sum(15) + "\n")
    }
    launch{
        print("CORUTINA 2: Suma 22: " + sum(22)+ "\n")
    }
    launch(newSingleThreadContext("Thread-ul Meu2")) {
        print("CORUTINA 3: Suma 4: " + sum(4)+ "\n")
    }
    launch(newSingleThreadContext("Thread-ul Meu")) {
        print("CORUTINA 4: Suma 10: " + sum(10)+ "\n")

    }
}

