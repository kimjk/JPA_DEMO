package com.example.demo.app.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

/**
 * description
 *
 * @author : jkkim
 */
@NoArgsConstructor
@Getter
public class BindingException extends RuntimeException {

    private BindingResult bindingResult;

    public BindingException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

}
