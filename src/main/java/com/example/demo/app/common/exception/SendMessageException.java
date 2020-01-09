package com.example.demo.app.common.exception;

import lombok.NoArgsConstructor;

/**
 * 메세지처리 익셉션
 *
 * @author : jkkim
 */
@NoArgsConstructor
public class SendMessageException extends RuntimeException {

    public SendMessageException(String message) {
        super(message);
    }

    public SendMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public SendMessageException(Throwable cause) {
        super(cause);
    }

}
