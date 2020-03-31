package com.dxk.kite.web.controller;

import com.dxk.kite.common.exception.BaseException;
import com.dxk.kite.common.exception.BaseExceptionCode;
import com.dxk.kite.web.constant.AuthConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuekai.deng
 * @description
 * @date 2020/1/17 14:30
 */
@Slf4j
public class BaseController {

    public String getUserCode(HttpServletRequest request) {
        String token = request.getHeader(AuthConstant.USER_TOKEN);
        if (StringUtils.isBlank(token)) {
            throw new BaseException(BaseExceptionCode.NONE_LOGIN_INFO);
        }
        return null;
    }
}
