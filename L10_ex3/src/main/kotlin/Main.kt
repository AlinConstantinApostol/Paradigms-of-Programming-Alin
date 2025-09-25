package org.alin

import kotlinx.coroutines.*
import java.util.Queue
import java.util.LinkedList

fun GaussSummation(n: Int): Int {
    var sum = 0
    for (i in 0..n)
        sum += i
    return sum
}

suspend fun main() {
    val numbers: Queue<Int> = LinkedList()
    numbers.add(4)
    numbers.add(10)
    numbers.add(25)
    numbers.add(14)

    val firstCoroutine = CoroutineScope(Dispatchers.Default).launch {
        println("1st Coroutine: " + GaussSummation(numbers.remove()))
    }
    val secondCoroutine = CoroutineScope(Dispatchers.Default).launch {
        println("2nd Coroutine: " + GaussSummation(numbers.remove()))
    }
    val thirdCoroutine = CoroutineScope(Dispatchers.Default).launch {
        println("3rd Coroutine: " + GaussSummation(numbers.remove()))
    }
    val fourthCoroutine = CoroutineScope(Dispatchers.Default).launch {
        println("4th Coroutine: " + GaussSummation(numbers.remove()))
    }

    listOf(firstCoroutine, secondCoroutine, thirdCoroutine, fourthCoroutine).joinAll()
}
