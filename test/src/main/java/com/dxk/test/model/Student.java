package com.dxk.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author hzdengxuekai
 * @date 2018/12/7 11:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

	private Integer id;
	private String name;
	private Integer age;
}
