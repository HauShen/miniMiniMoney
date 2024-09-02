package com.ding.miniminimoney.clients

import feign.Response
import feign.codec.ErrorDecoder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

class LdsCustomErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            return NotFoundException("Resource not found")
        }
        // Handle other HTTP status codes if needed
        return Exception("Generic error occurred")
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class NotFoundException(message: String) : RuntimeException(message)
}
