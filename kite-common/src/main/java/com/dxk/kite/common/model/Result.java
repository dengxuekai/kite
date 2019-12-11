package com.dxk.kite.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hzdengxuekai
 * @date 2018/7/12 16:47
 */
@Data
public class Result<T> implements Serializable {

    public static final int SUCCESS = 0;

    private int code;
    private String msg;
    private T data;

    public Result() {
        super();
    }

    public Result(T data) {
        this.code = SUCCESS;
        this.msg = "";
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public Result(Integer code, T data) {
        this.code = code;
        this.msg = null;
        this.data = data;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
