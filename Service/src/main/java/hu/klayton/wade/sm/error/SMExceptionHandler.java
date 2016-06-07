package hu.klayton.wade.sm.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@ControllerAdvice
@RestController
public class SMExceptionHandler {

    @ExceptionHandler(SMNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public SMError notFound(SMNotFoundException e) {
        if (e.getId() == null) {
            return new SMErrorForCollection(e);
        } else {
            return new SMErrorForEntry(e);
        }

    }
}
