package org.alin

import khttp.post
import khttp.responses.Response

class PostRequest(url: String, params: Map<String, String>) {
    private  var genericReq: GenericRequest = GenericRequest(url,params)

    fun postData() : Response {
        return post(genericReq.url, genericReq.params)
    }
}