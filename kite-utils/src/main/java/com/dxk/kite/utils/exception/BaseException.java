package com.dxk.kite.utils.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hzdengxuekai
 * @date 2018/7/12 17:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    private int code;
    private String message;

    public BaseException() {
        super();
    }

    public BaseException(int code, String message) {
        super();
        this.setCode(code);
        this.setMessage(message);
    }

}
