package com.dxk.kite.utils.result;

import com.dxk.kite.utils.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hzdengxuekai
 * @date 2018/7/12 16:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Result<T> extends BaseDTO {

    public static final int SUCCESS = 0;

    private int code;
    private String message;
    private T data;

    public Result() {
        super();
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(T data) {
        this.code = SUCCESS;
        this.message = "";
        this.data = data;
    }
}
