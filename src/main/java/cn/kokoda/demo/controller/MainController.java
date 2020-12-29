package cn.kokoda.demo.controller;


import cn.kokoda.demo.pojo.Department;
import cn.kokoda.demo.pojo.Employee;
import cn.kokoda.demo.pojo.User;
import cn.kokoda.demo.service.DepartmentService;
import cn.kokoda.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/main")
    public String main(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        List<Employee> allEmployee = employeeService.getAllEmployee(user.getId());
        Map<Integer, Department> allDepartmentMap = departmentService.getAllDepartmentMap(user.getId());
        model.addAttribute("employees", allEmployee);
        model.addAttribute("departmentsMap", allDepartmentMap);
        return "dashboard";
    }
}
