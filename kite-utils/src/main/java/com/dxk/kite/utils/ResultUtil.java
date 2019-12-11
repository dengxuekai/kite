package com.dxk.kite.utils;

import com.dxk.kite.utils.exception.Code;
import com.dxk.kite.utils.result.Result;

/**
 * @author hzdengxuekai
 * @date 2018/7/12 17:24
 */
public class ResultUtil {

    /**
     * 生成结果
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static <T> Result<T> genResult(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    /**
     * 生成成功结果
     *
     * @param data
     * @return
     */
    public static <T> Result<T> genResultWhitSuccess(T data) {
        return new Result<>(data);
    }

    /**
     * 生成异常结果
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result genResultWhitError(int code, String msg) {
        return new Result<>(code, msg);
    }

    /**
     * 生成异常结果
     *
     * @param code
     * @return
     */
    public static Result genResultWhitError(Code code) {
        return new Result<>(code.getCode(), code.getMsg());
    }

    /**
     * 生成异常结果
     *
     * @param code
     * @param data
     * @return
     */
    public static <T> Result<T> genResultWhitError(int code, T data) {
        return new Result<>(code, data);
    }

    /**
     * 判断是否成功
     *
     * @param result
     * @return
     */
    public static Boolean isSuccess(Result result) {
        return result != null && result.getCode() == Result.SUCCESS;
    }

    /**
     * 判断是否失败
     *
     * @param result
     * @return
     */
    public static Boolean isFailed(Result result) {
        return !isSuccess(result);
    }
}
