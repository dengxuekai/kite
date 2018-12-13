package com.dxk.test;

import com.dxk.test.model.Student;
import com.dxk.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author hzdengxuekai
 * @date 2018/12/7 10:52
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class BaseTest {

	@Resource
	private TestService testService;

	@Test
	public void test() {
		log.info(">>>>> success");
		String str = testService.setAndGet("str", "hzdengxuekai");
		log.info(">>>>> str :{}", str);
	}

	@Test
	public void test1() {
		log.info(">>>>> success");
		Student student = new Student(1, "kaikai", 18);
		testService.setStudent("str", student);
		Student str = testService.getStudent("str");
		log.info(">>>>> str :{}", str);
	}
}
