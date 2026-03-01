package org.alin

import khttp.responses.Response
import java.io.File

// in aceasta clasa se va realiza curatarea requestului in functie de controlul parental

class CleanGetRequest(private val getRequest: GetRequest) {

    private var parentalControlDisallow: List<String> = File("ParentalControl/blockedKeywords.txt").readLines()

    fun getResponse(): Response {
        parentalControlDisallow.forEach() {
            if (this.getRequest.genericRequest.url.contains(it)) {
                println("CANNOT ACCESS THIS WEBSITE! VALEA PE NORIEL COPILAS, N-AI CE CAUTA AICI!")
                return khttp.get("https://noriel.ro")
            }
        }
            return this.getRequest.getResponse()
        }
}

