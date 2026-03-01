package org.alin

import kotlinx.coroutines.*
import kotlin.random.Random

class CEOHandler(val name: String = "CEO") : Handler {
    var next: Handler? = null
    var prev: Handler? = null

    override fun handleRequest(messageToBeProcessed: String): Handler {
        if (messageToBeProcessed.startsWith("Response -")) {
            println("[$name] received response: $messageToBeProcessed")
            prev?.handleRequest(messageToBeProcessed)
            return this
        }
        if (messageToBeProcessed.contains(name, ignoreCase = true)) {
            GlobalScope.launch {
                val workTime = Random.nextLong(100, 700)
                println("[$name] started processing: '$messageToBeProcessed' (will take ${workTime}ms)")
                delay(workTime)
                val response = "Response - processed by $name"
                println("[$name] finished processing; sending: '$response'")
                prev?.handleRequest(response)
            }
        } else {
            next?.let { nxt ->
                GlobalScope.launch {
                    val forwardDelay = Random.nextLong(20, 150)
                    delay(forwardDelay)
                    println("[$name] forwarding to next after ${forwardDelay}ms: '$messageToBeProcessed'")
                    nxt.handleRequest(messageToBeProcessed)
                }
            } ?: run {
                println("[$name] cannot forward, request unhandled: '$messageToBeProcessed'")
            }
        }
        return this
    }
}

class ExecutiveHandler(val name: String = "Executive") : Handler {
    var next: Handler? = null
    var prev: Handler? = null

    override fun handleRequest(messageToBeProcessed: String): Handler {
        if (messageToBeProcessed.startsWith("Response -")) {
            println("[$name] received response: $messageToBeProcessed")
            prev?.handleRequest(messageToBeProcessed)
            return this
        }
        if (messageToBeProcessed.contains(name, ignoreCase = true)) {
            GlobalScope.launch {
                val workTime = Random.nextLong(100, 700)
                println("[$name] started processing: '$messageToBeProcessed' (will take ${workTime}ms)")
                delay(workTime)
                val response = "Response - processed by $name"
                println("[$name] finished processing; sending: '$response'")
                prev?.handleRequest(response)
            }
        } else {
            next?.let { nxt ->
                GlobalScope.launch {
                    val forwardDelay = Random.nextLong(20, 150)
                    delay(forwardDelay)
                    println("[$name] forwarding to next after ${forwardDelay}ms: '$messageToBeProcessed'")
                    nxt.handleRequest(messageToBeProcessed)
                }
            } ?: run {
                println("[$name] cannot forward, request unhandled: '$messageToBeProcessed'")
            }
        }
        return this
    }
}

class ManagerHandler(val name: String = "Manager") : Handler {
    var next: Handler? = null
    var prev: Handler? = null

    override fun handleRequest(messageToBeProcessed: String): Handler {
        if (messageToBeProcessed.startsWith("Response -")) {
            println("[$name] received response: $messageToBeProcessed")
            prev?.handleRequest(messageToBeProcessed)
            return this
        }
        if (messageToBeProcessed.contains(name, ignoreCase = true)) {
            GlobalScope.launch {
                val workTime = Random.nextLong(100, 700)
                println("[$name] started processing: '$messageToBeProcessed' (will take ${workTime}ms)")
                delay(workTime)
                val response = "Response - processed by $name"
                println("[$name] finished processing; sending: '$response'")
                prev?.handleRequest(response)
            }
        } else {
            next?.let { nxt ->
                GlobalScope.launch {
                    val forwardDelay = Random.nextLong(20, 150)
                    delay(forwardDelay)
                    println("[$name] forwarding to next after ${forwardDelay}ms: '$messageToBeProcessed'")
                    nxt.handleRequest(messageToBeProcessed)
                }
            } ?: run {
                println("[$name] cannot forward, request unhandled: '$messageToBeProcessed'")
            }
        }
        return this
    }
}

class HappyWorkerHandler(val name: String = "HappyWorker") : Handler {
    var next: Handler? = null
    var prev: Handler? = null

    override fun handleRequest(messageToBeProcessed: String): Handler {
        if (messageToBeProcessed.startsWith("Response -")) {
            println("[$name] received response: $messageToBeProcessed")
            prev?.handleRequest(messageToBeProcessed)
            return this
        }
        if (messageToBeProcessed.contains(name, ignoreCase = true)) {
            GlobalScope.launch {
                val workTime = Random.nextLong(100, 700)
                println("[$name] started processing: '$messageToBeProcessed' (will take ${workTime}ms)")
                delay(workTime)
                val response = "Response - processed by $name"
                println("[$name] finished processing; sending: '$response'")
                prev?.handleRequest(response)
            }
        } else {
            next?.let { nxt ->
                GlobalScope.launch {
                    val forwardDelay = Random.nextLong(20, 150)
                    delay(forwardDelay)
                    println("[$name] forwarding to next after ${forwardDelay}ms: '$messageToBeProcessed'")
                    nxt.handleRequest(messageToBeProcessed)
                }
            } ?: run {
                println("[$name] cannot forward, request unhandled: '$messageToBeProcessed'")
            }
        }
        return this
    }
}

fun main() = runBlocking {
    val ceo = CEOHandler()
    val executive = ExecutiveHandler()
    val manager = ManagerHandler()
    val happy = HappyWorkerHandler()

    ceo.next = executive
    executive.next = manager
    manager.next = happy

    manager.prev = executive
    executive.prev = ceo
    happy.prev = manager

    val req1 = "Request - task for Executive"
    println("=== Sending: $req1 ===")
    ceo.handleRequest(req1)
    delay(1500)

    val req2 = "Request - task for Manager"
    println("\n=== Sending: $req2 ===")
    ceo.handleRequest(req2)
    delay(1500)

    val req3 = "Request - task for HappyWorker"
    println("\n=== Sending: $req3 ===")
    ceo.handleRequest(req3)
    delay(1500)

    val req4 = "Request - task for Unknown"
    println("\n=== Sending: $req4 ===")
    ceo.handleRequest(req4)
    delay(800)
}

