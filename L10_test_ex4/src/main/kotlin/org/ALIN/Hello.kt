package org.ALIN

import sun.misc.Queue // arrayblocking, ... deque

fun GaussSummation(n: Int): Int {
    var sum = 0;
    for (i in 0..n)
        sum += i;
    return sum;
}

fun main() {
    val numbers = Queue<Int>();
    numbers.enqueue(4) // adaugam 4 numere in coada care vor fi procesate
    numbers.enqueue(10) // de firele de executie
    numbers.enqueue(25)
    numbers.enqueue(14)

    val thread1 = Thread { println("1st Thread: " + GaussSummation(numbers.dequeue())) }
    val thread2 = Thread { println("2nd Thread: " + GaussSummation(numbers.dequeue())) }
    val thread3 = Thread { println("3rd Thread: " + GaussSummation(numbers.dequeue())) }
    val thread4 = Thread { println("4th Thread: " + GaussSummation(numbers.dequeue())) }

    val threadsList = listOf(thread1, thread2, thread3, thread4)

    threadsList.forEach() {thread -> // porneste executia fiecarui numar in paralel
        thread.start()
    }
    threadsList.forEach() {thread ->
        thread.join()
    }
}

