package com.Zijin.service;

import com.Zijin.mapper.EmployeeMapper;
import com.Zijin.pojo.Employee;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
