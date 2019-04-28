package com.dxk.test.controller;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author dengxuekai
 * @Date 2019-04-28 13:52
 */
@ControllerAdvice
public class AdviceController {

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Map<String, Object> catchParamException(BindException exception) {

        BindingResult bindResult = exception.getBindingResult();
        Map<String, Object> map = new HashMap<>(2);
        if (bindResult.hasErrors()) {
            List<ObjectError> errorList = bindResult.getAllErrors();
            String error = errorList.get(0).getDefaultMessage();
            map.put("code", 400);
            map.put("msg", error);
            return map;
        }
        map.put("code", 500);
        map.put("msg", exception.getMessage());
        return map;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, Object> catchParamException(Exception exception) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 500);
        map.put("msg", exception.getMessage());
        return map;
    }
}
