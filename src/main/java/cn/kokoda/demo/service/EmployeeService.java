package cn.kokoda.demo.service;

import cn.kokoda.demo.mapper.EmployeeMapper;
import cn.kokoda.demo.pojo.Employee;
import cn.kokoda.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployee(int userId) {
        return employeeMapper.selectAllByUserId(userId);
    }

    public boolean addEmployee(Employee employee) {
        return employeeMapper.insert(employee) == 1;
    }
}
