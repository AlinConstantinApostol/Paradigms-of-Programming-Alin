package org.alin

import alin.Clonable

class GenericRequest(var url: String, var params: Map<String, String>) : Clonable {

    private fun GenericRequest(url:String, params:Map<String,String>) {
        this.url = url
        this.params = params
    }

    fun clone() {
        return GenericRequest(this.url, this.params)
    } // Prototype

}