package com.ding.miniminimoney.exceptions

import com.ding.miniminimoney.userprofile.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(ex: UserNotFoundException, request: WebRequest): ResponseEntity<Any> =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.localizedMessage)


    data class ResponseBody(val messages: List<String>) {
        constructor(message: String) : this(listOf(message))
    }
}