package org.alin

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import sun.misc.Queue

fun GaussSummation(n: Int): Int {
    var sum = 0;
    for (i in 0..n)
        sum += i;
    return sum;
}

suspend fun main() {

    val numbers = Queue<Int>();
    numbers.enqueue(4)
    numbers.enqueue(10)
    numbers.enqueue(25)
    numbers.enqueue(14)

    val firstCoroutine = CoroutineScope(Dispatchers.Default).launch { println("1st Coroutine: " + GaussSummation(numbers.dequeue())) }
    val secondCoroutine = CoroutineScope(Dispatchers.Default).launch { println("2nd Coroutine: " + GaussSummation(numbers.dequeue())) }
    val thirdCoroutine = CoroutineScope(Dispatchers.Default).launch { println("3rd Coroutine: " + GaussSummation(numbers.dequeue())) }
    val fourthCoroutine = CoroutineScope(Dispatchers.Default).launch { println("4th Coroutine: " + GaussSummation(numbers.dequeue())) }

    listOf(firstCoroutine,secondCoroutine,thirdCoroutine,fourthCoroutine).joinAll()

}



