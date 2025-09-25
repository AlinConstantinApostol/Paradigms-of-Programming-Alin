package org.alin

import khttp.get
import khttp.responses.Response

class GetRequest(private var url: String, var params: Map<String,String>, private var timeout: Int) : HTTPGet {

    var genericRequest = GenericRequest(url,params)

    override fun getResponse(): Response {
        val headers : MutableMap<String,String> = mutableMapOf()
        return get(this.genericRequest.url, headers,genericRequest.params, null, null, null, null, this.timeout.toDouble())
    }

}