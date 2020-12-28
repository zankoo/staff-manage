package cn.kokoda.demo;

import cn.kokoda.demo.pojo.Department;
import cn.kokoda.demo.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DepartmentService departmentService;

    @Test
    void contextLoads() throws SQLException {
        Map<Integer, Department> allDepartment = departmentService.getAllDepartmentMap(2);
        System.out.println("allDepartment = " + allDepartment);
    }

}
