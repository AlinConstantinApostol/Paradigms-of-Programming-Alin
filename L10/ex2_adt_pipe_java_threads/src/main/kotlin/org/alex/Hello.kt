package org.alex

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue


fun constantMultiplier(vector: List<Int>, alfa: Int, outVector: MutableList<Int>) {

    vector.forEach() {
        outVector.add(it * alfa)
    }
}

fun sortingFunction(inputChannel: MutableList<Int>, outputChannel: MutableList<Int>) {
    val sorted = inputChannel.toList().sorted()
    sorted.forEach() {
        outputChannel.add(it)
    }
}

fun printADT(inputChannel: MutableList<Int>) {
    inputChannel.toList().forEach() {
        println("$it ")
    }
}

fun main() {
    val vector = listOf(21, 34, 12, 14, 7, 9, 81, 22)

    var pipe1 = mutableListOf<Int>()
    var pipe2 = mutableListOf<Int>()

    val part1 = Thread { constantMultiplier(vector, 5, pipe1) }

    val part2 = Thread { sortingFunction(pipe1, pipe2) }

    val part3 = Thread { printADT(pipe2) }

    val threadsList = listOf(part1, part2, part3)

    threadsList.forEach() {
        it.start()
    }

    threadsList.forEach() {
        it.join()
    }



}


