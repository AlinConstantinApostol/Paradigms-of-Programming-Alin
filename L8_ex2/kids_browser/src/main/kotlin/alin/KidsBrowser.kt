package org.alin

import khttp.responses.Response
import java.util.Scanner

class KidsBrowser(private val cleanGetRequest: CleanGetRequest, private val postRequest: PostRequest) {

    fun start() {
        val sc = Scanner(System.`in`)
        println("GET or POST")
        val input = sc.nextLine()
        val response : Response
        when (input) {
            "GET" -> {response = this.cleanGetRequest.getResponse()
                println("GET REQUEST DONE SUCCESSFULLY")
            }
            "POST" -> {response = this.postRequest.postData()
                println("POST REQUEST DONE SUCCESSFULLY")
            }
        }


    }
}