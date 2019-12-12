package com.dxk.test.controller;

import com.dxk.kite.common.model.Result;
import com.dxk.test.model.Student;
import com.dxk.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dengxuekai
 * @Date 2019-12-12 10:50
 */
@RestController
public class RedisController {

    @Autowired
    private TestService testService;

    @GetMapping("lock")
    public Result<Boolean> lock() {
        return testService.submitOrder(new Student());
    }
}
