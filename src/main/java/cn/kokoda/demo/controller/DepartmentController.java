package cn.kokoda.demo.controller;

import cn.kokoda.demo.pojo.Department;
import cn.kokoda.demo.pojo.User;
import cn.kokoda.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/table")
    public String list(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        List<Department> allDepartment = departmentService.getAllDepartment(user.getId());
        System.out.println("allDepartment = " + allDepartment);
        model.addAttribute("departments", allDepartment);
        return "department";
    }

    @RequestMapping("/addDepartment")
    public String add(Department department) {
        if (departmentService.addDepartment(department)) {
            return "redirect:/dept/table";
        } else {
            return "error/404";
        }
    }

    @RequestMapping("/editDepartment")
    public String edit(Department department) {
        if (departmentService.editDepartment(department)) {
            return "redirect:/dept/table";
        } else {
            return "error/404";
        }
    }

    @RequestMapping("/deleteDepartment/{id}")
    public String delete(@PathVariable("id") int id) {
        if (departmentService.deleteDepartment(id)) {
            return "redirect:/dept/table";
        } else {
            return "error/404";
        }
    }
}
