package org.alin

fun main() {
    val url = "https://shop.com/toys"
    val getRequest = GetRequest(url, params = mapOf<String,String>(), 10)
    val cleanGetRequest = CleanGetRequest(getRequest)
    val postRequest = PostRequest(url,params = mapOf<String,String>())
    val kidsBrowser = KidsBrowser(cleanGetRequest,postRequest)
    kidsBrowser.start()
}


