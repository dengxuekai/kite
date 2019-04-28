package com.dxk.test.controller.param;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @Author dengxuekai
 * @Date 2019-04-28 11:54
 */
@Data
@ToString
public class BaseParam {

    @NotBlank(message = "姓名不能为空")
    private String name;
    @Range(min = 0, max = 100, message = "年龄要在0-100之间")
    private Integer age;
}
