package cn.kokoda.demo.controller;

import cn.kokoda.demo.pojo.Department;
import cn.kokoda.demo.pojo.Employee;
import cn.kokoda.demo.pojo.User;
import cn.kokoda.demo.service.DepartmentService;
import cn.kokoda.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/table")
    public String list(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        List<Employee> allEmployee = employeeService.getAllEmployee(user.getId());
        Map<Integer, Department> allDepartmentMap = departmentService.getAllDepartmentMap(user.getId());
        List<Department> allDepartment = departmentService.getAllDepartment(user.getId());
        model.addAttribute("departments", allDepartment);
        model.addAttribute("departmentsMap", allDepartmentMap);
        model.addAttribute("employees", allEmployee);
        return "table";
    }

    @RequestMapping("/addEmployee")
    public String add(Employee employee, Model model) {
        if (employeeService.addEmployee(employee)) {
            return "redirect:/emp/table";
        } else {
            return "error/404";
        }
    }

    @RequestMapping("/editEmployee")
    public String edit(Employee employee, Model model) {
        if (employeeService.editEmployee(employee)) {
            return "redirect:/emp/table";
        } else {
            return "error/404";
        }
    }
}
