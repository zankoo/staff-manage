package cn.kokoda.demo.service;

import cn.kokoda.demo.mapper.EmployeeMapper;
import cn.kokoda.demo.pojo.Employee;
import cn.kokoda.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployee(int userId) {
        return employeeMapper.selectAllByUserId(userId);
    }

    public Map<Integer, Employee> getAllEmployeeMap(int userId) {
        return employeeMapper.selectAllByUserIdToMap(userId);
    }

    public boolean addEmployee(Employee employee) {
        return employeeMapper.insert(employee) == 1;
    }

    public boolean editEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee) == 1;
    }

    public boolean deleteEmployee(int id) {
        return employeeMapper.deleteByPrimaryKey(id) == 1;
    }
}
