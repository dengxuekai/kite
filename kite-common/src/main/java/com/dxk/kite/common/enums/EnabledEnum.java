package com.dxk.kite.common.enums;

import lombok.Getter;

/**
 * @Author dengxuekai
 * @Date 2019-12-11 17:24
 */
@Getter
public enum EnabledEnum {

    NOT_ENABLED(0, "未开启"),
    ENABLED(1, "已开启"),
    ;

    private int code;
    private String msg;

    EnabledEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
