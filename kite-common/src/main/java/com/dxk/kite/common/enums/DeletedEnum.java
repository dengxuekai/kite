package com.dxk.kite.common.enums;

import lombok.Getter;

/**
 * @Author dengxuekai
 * @Date 2019-12-11 17:24
 */
@Getter
public enum DeletedEnum {

    NOT_DELETED(0, "未删除"),
    DELETED(1, "已删除"),
    ;

    private int code;
    private String msg;

    DeletedEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
