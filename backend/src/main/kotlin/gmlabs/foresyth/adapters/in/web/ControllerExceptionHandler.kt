package gmlabs.foresyth.adapters.`in`.web

import gmlabs.foresyth.application.ChatterNotFoundException
import gmlabs.foresyth.domain.BaseChatterException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BaseChatterException::class)
    fun handleYourCustomException(
        ex: ChatterNotFoundException,
        request: WebRequest,
    ): ResponseEntity<Any> {
        val responseBody = mapOf("message" to ex.message)

        return ResponseEntity(responseBody, HttpStatus.BAD_REQUEST)
    }
}
