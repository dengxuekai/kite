package com.dxk.test.service;

import com.dxk.kite.common.model.Result;
import com.dxk.test.model.Student;

/**
 * @author hzdengxuekai
 * @date 2018/12/7 10:49
 */
public interface TestService {

    String setAndGet(String key, String value);

    boolean setStudent(String key, Student student);

    Student getStudent(String key);

    Result<Boolean> exception();

    Result<Boolean> limit(Student student, Integer status);

    Result<Boolean> submitOrder(Student student);
}
