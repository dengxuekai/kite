package com.dxk.test.controller;

import com.dxk.test.controller.param.BaseParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @Author dengxuekai
 * @Date 2019-04-28 11:53
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test(@Valid BaseParam param) {
        return param.toString();
    }

    @GetMapping("info")
    public String info(@Valid @NotBlank(message = "名不能为空") String param) {
        return param;
    }
}
