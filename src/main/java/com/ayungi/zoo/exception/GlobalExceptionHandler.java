package com.ayungi.zoo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public record ErrorResponse(String error, String message, int status, LocalDateTime timestamp) {}

    private ResponseEntity<ErrorResponse> build(HttpStatus status, String error, Exception ex) {
        return ResponseEntity.status(status)
                .body(new ErrorResponse(error, ex.getMessage(), status.value(), LocalDateTime.now()));
    }

    @ExceptionHandler(AnimalNotFoundException.class)
    public ResponseEntity<?> animalNotFound(AnimalNotFoundException ex) {
        log.warn("AnimalNotFound: {}", ex.getMessage());
        return build(HttpStatus.NOT_FOUND, "AnimalNotFound", ex);
    }

    @ExceptionHandler(EnclosureNotFoundException.class)
    public ResponseEntity<?> enclosureNotFound(EnclosureNotFoundException ex) {
        log.warn("EnclosureNotFound: {}", ex.getMessage());
        return build(HttpStatus.NOT_FOUND, "EnclosureNotFound", ex);
    }

    @ExceptionHandler(FeedingScheduleNotFoundException.class)
    public ResponseEntity<?> feedingNotFound(FeedingScheduleNotFoundException ex) {
        log.warn("FeedingScheduleNotFound: {}", ex.getMessage());
        return build(HttpStatus.NOT_FOUND, "FeedingScheduleNotFound", ex);
    }

    @ExceptionHandler(EnclosureCapacityExceededException.class)
    public ResponseEntity<?> capacityExceeded(EnclosureCapacityExceededException ex) {
        log.warn("CapacityExceeded: {}", ex.getMessage());
        return build(HttpStatus.CONFLICT, "EnclosureCapacityExceeded", ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArg(IllegalArgumentException ex) {
        return build(HttpStatus.BAD_REQUEST, "IllegalArgument", ex);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtime(RuntimeException ex) {
        log.error("RuntimeException", ex);
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "RuntimeError", ex);
    }
}
