package com.example.demo.app.common.response;

import com.example.demo.app.common.constant.ResponseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * description
 *
 * @author : jkkim
 */
@Getter
@Setter
public class ResponseData {

    private ResponseStatus status;
    private String message;
    private Object data;

    @Builder
    public ResponseData(Object data, String message, ResponseStatus status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

}
