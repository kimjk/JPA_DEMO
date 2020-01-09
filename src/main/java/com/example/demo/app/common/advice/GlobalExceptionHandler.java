package com.example.demo.app.common.advice;

import com.example.demo.app.common.constant.ResponseStatus;
import com.example.demo.app.common.exception.BindingException;
import com.example.demo.app.common.exception.SendMessageException;
import com.example.demo.app.common.response.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * description
 *
 * @author : jkkim
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 화면에 메세지 전송
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(SendMessageException.class)
    public Object sendMessageExceptionHandler(SendMessageException ex) {
        log.debug("SendMessageException : {}", ex.getMessage());

        ResponseData responseData = ResponseData.builder()
                .status(ResponseStatus.ERROR)
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<Object>(responseData, HttpStatus.OK);
    }

    /**
     * valid error
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BindingException.class)
    public Object bindExceptionHandler(BindingException ex) {

        FieldError fieldError = ex.getBindingResult().getFieldError();
        String field = fieldError.getField();

        log.debug("BindingException !!!");
        log.debug("field: {}", field);
        //log.debug("field: {}", );

        ResponseData responseData = ResponseData.builder()
                .status(ResponseStatus.VALID_ERROR)
                .message("valid error")
                .build();
        return new ResponseEntity<Object>(responseData, HttpStatus.OK);
    }

}
