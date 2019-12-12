package com.dxk.kite.common.exception;

/**
 * @Author dengxuekai
 * @Date 2019-12-11 10:39
 */
public enum BaseExceptionCode implements Code {

    SYSTEM_ERROR(100000, "系统错误"),
    PARAM_ERROR(100001, "请求参数错误"),
    OVER_CURRENT_LIMIT(100002, "超过接口限流数"),
    NOT_LOCKED(100003, "未获取到分布式锁"),
    JOB_MUST_RETURN_BOOLEAN(100004, "定时任务必须返回布尔类型"),

    ;
    private final int code;
    private final String msg;

    BaseExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
