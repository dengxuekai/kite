package com.dxk.test.service.impl;

import com.dxk.kite.redis.service.RedisService;
import com.dxk.kite.rpc.annotation.CurrentLimit;
import com.dxk.kite.rpc.annotation.MethodInOutLog;
import com.dxk.kite.rpc.annotation.ReturnExceptionResult;
import com.dxk.kite.utils.ResultUtil;
import com.dxk.kite.utils.exception.BaseException;
import com.dxk.kite.utils.result.Result;
import com.dxk.test.model.Student;
import com.dxk.test.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hzdengxuekai
 * @date 2018/12/7 10:49
 */
@Service
public class TestServiceImpl implements TestService {

	@Resource
	private RedisService redisService;

	@Override
	public String setAndGet(String key, String value) {
		redisService.set(key, value);
		return (String) redisService.get(key);
	}

	@Override
	public boolean setStudent(String key, Student student) {
		return redisService.set(key, student);
	}

	@Override
	public Student getStudent(String key) {
		return (Student) redisService.get(key);
	}

	@Override
	@ReturnExceptionResult
	public Result exception() {
		throw new BaseException(1234, "自定义异常");
	}

	@Override
	@CurrentLimit
	@MethodInOutLog
	@ReturnExceptionResult
	public Result<Boolean> limit(Student student, Integer status) {
		return ResultUtil.genResultWhitSuccess(true);
	}

}
