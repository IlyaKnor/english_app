package study.englishApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import study.englishApp.models.entity.Response;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseEntity<Response> handleNotFound(NotFoundExceptions exceptions) {
        Response response = new Response(exceptions.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Response> handleBadRequest(BadRequestException exception) {
        Response response = new Response(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Response> handleConflict(ConflictException exception) {
        Response response = new Response(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
