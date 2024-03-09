package org.ouc.management.service;

import org.ouc.common.constant.PasswordConstant;
import org.ouc.common.constant.StatusConstant;
import org.ouc.common.pojo.dto.EmployeeDTO;
import org.ouc.common.result.Result;
import org.ouc.common.pojo.entity.Employee;
import org.ouc.management.mapper.EmpMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;


    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    public Result getById(String id) {
        Employee emp = empMapper.getById(id);
        return Result.success(emp);
    }


    /**
     * 新增员工
     * @param employeeDTO
     * @return
     */
    public Result save(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);

        // 员工默认状态启用
        employee.setStatus(StatusConstant.ENABLE);

        // 设置默认密码，并md5加密
        employee.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));

        // 设置创建及更新日期
        // TODO 后期有时间改成自动注入的
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        empMapper.insert(employee);

        return Result.success();
    }
}
