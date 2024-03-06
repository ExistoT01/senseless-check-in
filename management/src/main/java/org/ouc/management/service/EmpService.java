package org.ouc.management.service;

import org.ouc.common.result.Result;
import org.ouc.common.pojo.entity.Employee;
import org.ouc.management.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;


    public Result getById(String id) {
        Employee emp = empMapper.getById(id);
        return Result.success(emp);
    }

}
