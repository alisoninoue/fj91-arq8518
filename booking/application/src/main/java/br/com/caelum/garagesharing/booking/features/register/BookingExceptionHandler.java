package br.com.caelum.garagesharing.booking.features.register;

import br.com.caelum.garagesharing.booking.shared.exceptions.BookingNotAvailableException;
import br.com.caelum.garagesharing.booking.shared.exceptions.BookingNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class BookingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookingNotAvailableException.class)
    protected ResponseEntity<String> bookingExceptionHandler() {
        return new ResponseEntity<String>("Booking not available! :(", HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(BookingNotFoundException.class)
    protected ResponseEntity<String> bookingNotFoundHandler() {
        return new ResponseEntity<String>("Booking not found! :(", HttpStatus.NOT_FOUND);
    }

    /**@ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<String> bookingInvalidArgumentsHandler(MethodArgumentNotValidException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }**/
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(ex.getCause(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
