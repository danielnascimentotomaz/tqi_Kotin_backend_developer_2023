package juMarket.com.sistema.autoatendimento.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDate

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(BunissException::class)
    fun  handlerValidException(ex:BunissException):ResponseEntity<ExeceptionDetails>{

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ExeceptionDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDate.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)
                )



        )


    }


}