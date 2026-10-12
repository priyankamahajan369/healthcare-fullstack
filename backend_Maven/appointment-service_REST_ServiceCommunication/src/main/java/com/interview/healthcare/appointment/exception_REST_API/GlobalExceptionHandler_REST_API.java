// This declares the appointment exception package.
package com.interview.healthcare.appointment.exception_REST_API;
// This imports HTTP status codes.
import org.springframework.http.HttpStatus;
// This imports REST exception annotations.
import org.springframework.web.bind.annotation.*;
// This imports map responses.
import java.util.Map;
// This applies to every appointment controller.
@RestControllerAdvice
// This class maps business errors to useful API responses.
public class GlobalExceptionHandler_REST_API {
// This catches validation and not-found business errors.
    @ExceptionHandler(IllegalArgumentException.class)
// This returns a 400 Bad Request status.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
// This returns a small JSON body with the error message.
    public Map<String, String> handle(IllegalArgumentException ex) { return Map.of("error", ex.getMessage()); }
// This closes the handler.
}
