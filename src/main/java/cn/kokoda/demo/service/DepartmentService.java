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

    public boolean addDepartment(Department department) {
        return departmentMapper.insert(department) == 1;
    }

    public boolean editDepartment(Department department) {
        return departmentMapper.updateByPrimaryKeySelective(department) == 1;
    }

    public boolean deleteDepartment(int id) {
        return departmentMapper.deleteByPrimaryKey(id) == 1;
    }
}
