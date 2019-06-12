package com.dxk.test;

import com.dxk.test.model.Student;
import com.dxk.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	Random random = new Random();

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

	@Test
	public void test2() {
		int number = 10000000;
		List<Double> list = new ArrayList<>(number);
		for (int i = 0; i < number; i ++) {
			double tem = random.nextDouble();
			if (tem < 0.10000000000D) {
				list.add(tem);
			}
		}
		log.info(">>>>> str :{}", list.size() / (float) number);
//		log.info(">>>>> str :{}", list.toString());
	}

	@Test
	public void test3() {
		for (int i = 0; i < 10; i ++) {
			test2();
		}
	}
}
