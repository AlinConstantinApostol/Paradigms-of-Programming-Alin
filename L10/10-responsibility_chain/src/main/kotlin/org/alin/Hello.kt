package org.alin

import kotlinx.coroutines.*
import kotlin.random.Random

interface SimpleHandler {
    fun handleRequest(messageToBeProcessed: String) : SimpleHandler
}

open class BaseHandler(val name: String) : SimpleHandler {
    var next: SimpleHandler? = null
    var prev: SimpleHandler? = null

    override fun handleRequest(messageToBeProcessed: String): SimpleHandler {
        if (messageToBeProcessed.startsWith("Response -")) {
            println("[$name] received response: $messageToBeProcessed")
            prev?.handleRequest(messageToBeProcessed)
            return this
        }
        if (messageToBeProcessed.contains(name, ignoreCase = true)) {
            GlobalScope.launch {
                val workTime = Random.nextLong(200, 800)
                println("[$name] -> started processing request: '$messageToBeProcessed' (will take ${workTime}ms)")
                delay(workTime)
                val response = "Response - processed by $name"
                println("[$name] -> finished processing; sending response: '$response' via prev chain")
                prev?.handleRequest(response)
            }
        } else {
            next?.let { nxt ->
                GlobalScope.launch {
                    val forwardDelay = Random.nextLong(50, 150)
                    delay(forwardDelay)
                    println("[$name] -> forwarding request to next after ${forwardDelay}ms: '$messageToBeProcessed'")
                    nxt.handleRequest(messageToBeProcessed)
                }
            } ?: run {
                println("[$name] -> no next to forward, request unhandled: '$messageToBeProcessed'")
            }
        }
        return this
    }
}

class CEOHandler : BaseHandler("CEO")
class ExecutiveHandler : BaseHandler("Executive")
class ManagerHandler : BaseHandler("Manager")
class HappyWorkerHandler : BaseHandler("HappyWorker")

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

    val request = "Request - task for Executive"
    println("=== Sending request: '$request' ===")
    ceo.handleRequest(request)
    delay(2000)

    println("\n=== Demo 2: cerere adresată Manager (pleacă de la CEO) ===")
    ceo.handleRequest("Request - task for Manager")
    delay(2000)

    println("\n=== Demo 3: cerere adresată HappyWorker (pleacă de la CEO) ===")
    ceo.handleRequest("Request - task for HappyWorker")
    delay(2000)

    println("\n=== Demo complet: trimitem o cerere necunoscută (neprocesată) ===")
    ceo.handleRequest("Request - task for Unknown")
    delay(800)

    println("\n=== End of demo ===")
}

