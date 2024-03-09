package org.ouc.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.ouc.common.pojo.dto.EmployeeDTO;
import org.ouc.common.result.Result;
import org.ouc.management.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable String id) {
        log.debug("收到员工id: {}", id);
        return empService.getById(id);
    }

    /**
     * 新增员工
     * @param employeeDTO
     * @return
     */
    @PostMapping
    public Result save(@RequestBody EmployeeDTO employeeDTO) {
        log.debug("新增员工: {}", employeeDTO);
        return empService.save(employeeDTO);
    }
}
