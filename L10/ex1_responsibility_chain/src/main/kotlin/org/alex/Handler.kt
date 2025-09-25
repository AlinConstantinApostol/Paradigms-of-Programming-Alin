package org.alex

interface Handler {
    fun handleRequest(messageToBeProcessed: String) : Handler
}