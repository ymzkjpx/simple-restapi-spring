package com.simplerestapispring.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> handleException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        System.out.println("in CustomExceptionHandler");
        return new ResponseEntity<>(ex.getMessage(), status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer code = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus status = HttpStatus.resolve(code);
        return (status != null) ? status : HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

/**
 * import javax.servlet.RequestDispatcher;
 * import javax.servlet.http.HttpServletRequest;
 * <p>
 * import org.springframework.http.HttpStatus;
 * import org.springframework.http.ResponseEntity;
 * import org.springframework.web.bind.annotation.ControllerAdvice;
 * import org.springframework.web.bind.annotation.ExceptionHandler;
 * import org.springframework.web.bind.annotation.ResponseBody;
 * import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 *
 * @ControllerAdvice(basePackageClasses = SomeController.class)
 * public class MyControllerAdvice extends ResponseEntityExceptionHandler {
 * @ResponseBody
 * @ExceptionHandler(MyException.class) public ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
 * HttpStatus status = getStatus(request);
 * return new ResponseEntity<>(new MyErrorBody(status.value(), ex.getMessage()), status);
 * }
 * <p>
 * private HttpStatus getStatus(HttpServletRequest request) {
 * Integer code = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
 * HttpStatus status = HttpStatus.resolve(code);
 * return (status != null) ? status : HttpStatus.INTERNAL_SERVER_ERROR;
 * }
 * <p>
 * }
 */
