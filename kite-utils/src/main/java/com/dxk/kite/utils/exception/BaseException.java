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

    private int status;
    private Object[] args;

    public BaseException() {
        this(-1);
    }

    public BaseException(int status) {
        this(status, null);
    }

    public BaseException(int status, String message) {
        super(message);
        this.status = status;
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }
}
