package org.alin

interface Handler {
    fun handleRequest(messageToBeProcessed: String) : Handler
}
