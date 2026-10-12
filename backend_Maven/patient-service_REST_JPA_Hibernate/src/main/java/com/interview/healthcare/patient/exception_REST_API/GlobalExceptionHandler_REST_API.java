// This declares the exception package.
package com.interview.healthcare.patient.exception_REST_API;
// This imports HTTP status codes.
import org.springframework.http.HttpStatus;
// This imports Spring REST exception annotations.
import org.springframework.web.bind.annotation.*;
// This imports a simple response map.
import java.util.Map;
// This applies error handling across all patient controllers.
@RestControllerAdvice
// This class converts business exceptions into useful HTTP JSON errors.
public class GlobalExceptionHandler_REST_API {
// This catches our simple business validation errors.
    @ExceptionHandler(IllegalArgumentException.class)
// This returns HTTP 400 instead of an unclear server error.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
// This method builds a small JSON error body.
    public Map<String, String> handle(IllegalArgumentException ex) { return Map.of("error", ex.getMessage()); }
// This closes the error handler.
}
