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
    private String msg;

    public BaseException() {
        super();
    }

    public BaseException(int code, String msg) {
        super();
        this.setCode(code);
        this.setMsg(msg);
    }

    public BaseException(Code code) {
        super();
        this.setCode(code.getCode());
        this.setMsg(code.getMsg());
    }

}
