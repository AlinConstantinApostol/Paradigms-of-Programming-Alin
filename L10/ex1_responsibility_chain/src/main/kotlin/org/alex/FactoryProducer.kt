package org.alex

import java.util.Scanner

class FactoryProducer {
    fun getFactory(choice: String): AbstractFactory {
        val abstractFactory: AbstractFactory = if(choice == "Elite") {
            EliteFactory()
        } else {
            HappyWorkerFactory()
        }
        return abstractFactory
    }
}