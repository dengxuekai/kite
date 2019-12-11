package com.dxk.test.controller;

import com.dxk.kite.rpc.annotation.MethodInOutLog;
import com.dxk.kite.common.model.Result;
import com.dxk.test.controller.param.BaseParam;
import com.dxk.test.model.Student;
import com.dxk.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @Author dengxuekai
 * @Date 2019-04-28 11:53
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test")
    public String test(@Valid BaseParam param) {
        return param.toString();
    }

    @GetMapping("info")
    public String info(@Valid @NotBlank(message = "名不能为空") String param) {
        return param;
    }

    @GetMapping("exception")
    public Result<Boolean> exception() {
        return testService.exception();
    }

    @MethodInOutLog
    @GetMapping("limit")
    public Result<Boolean> limit(@RequestParam("name") String name,
                                 @RequestParam("status") Integer status) {
        Student student = new Student();
        student.setAge(status);
        student.setId(status);
        student.setName(name);
        return testService.limit(student, status);
    }
}
