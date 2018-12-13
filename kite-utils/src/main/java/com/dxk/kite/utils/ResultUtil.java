package com.dxk.kite.utils;

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
     * @param message
     * @param data
     * @return
     */
    public static Result<Object> genResult(int code, String message, Object data) {
        return new Result<>(code, message, data);
    }

    /**
     * 生成成功结果
     *
     * @param data
     * @return
     */
    public static Result<Object> genResultWhitSuccess(Object data) {
        return new Result<>(data);
    }

    /**
     * 生成异常结果
     *
     * @param code
     * @param message
     * @return
     */
    public static Result genResultWhitError(int code, String message) {
        return new Result<>(code, message);
    }

    /**
     * 判断是否成功
     *
     * @param result
     * @return
     */
    public static Boolean isSuccess(Result result) {
        return !(result == null || result.getCode() != Result.SUCCESS);
    }

    /**
     * 判断是否失败
     *
     * @param result
     * @return
     */
    public static Boolean isFailed(Result result) {
        return result == null || result.getCode() != Result.SUCCESS;
    }
}
