package org.alex

import sun.misc.Queue

fun GaussSummation(n: Int): Int {
    var sum = 0;
    for (i in 0..n)
        sum += i;
    return sum;
}

fun main() {
    val numbers = Queue<Int>();
    numbers.enqueue(4)
    numbers.enqueue(10)
    numbers.enqueue(25)
    numbers.enqueue(14)

    val thread1 = Thread { println("1st Thread: " + GaussSummation(numbers.dequeue())) }
    val thread2 = Thread { println("2nd Thread: " + GaussSummation(numbers.dequeue())) }
    val thread3 = Thread { println("3rd Thread: " + GaussSummation(numbers.dequeue())) }
    val thread4 = Thread { println("4th Thread: " + GaussSummation(numbers.dequeue())) }

    val threadsList = listOf(thread1, thread2, thread3, thread4)

    threadsList.forEach() {thread ->
        thread.start()
    }
    threadsList.forEach() {thread ->
        thread.join()
    }
}

