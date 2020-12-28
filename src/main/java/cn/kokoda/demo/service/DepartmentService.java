package cn.kokoda.demo.service;


import cn.kokoda.demo.mapper.DepartmentMapper;
import cn.kokoda.demo.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public Map<Integer, Department> getAllDepartmentMap(int userId) {
        return departmentMapper.selectAllByUserIdToMap(userId);
    }

    public List<Department> getAllDepartment(int userId) {
        return departmentMapper.selectAllByUserId(userId);
    }
}
