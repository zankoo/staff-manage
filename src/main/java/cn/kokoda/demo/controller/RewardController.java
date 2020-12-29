package cn.kokoda.demo.controller;

import cn.kokoda.demo.pojo.Bonus;
import cn.kokoda.demo.pojo.Department;
import cn.kokoda.demo.pojo.Employee;
import cn.kokoda.demo.pojo.User;
import cn.kokoda.demo.service.EmployeeService;
import cn.kokoda.demo.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reward")
public class RewardController {

    @Autowired
    RewardService rewardService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/table")
    public String list(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        List<Bonus> allBonus = rewardService.getAllBonus(user.getId());
        Map<Integer, Employee> allEmployeeMap = employeeService.getAllEmployeeMap(user.getId());
        Map<String, Integer> nameIdMap = new HashMap<String, Integer>(100);
        for (Employee employee : employeeService.getAllEmployee(user.getId())) {
            nameIdMap.put(employee.getName(), employee.getId());
        }
        model.addAttribute("rewards", allBonus);
        model.addAttribute("employees", allEmployeeMap);
        model.addAttribute("employeeNameIdMap", nameIdMap);
        return "reward";
    }

    @RequestMapping("/add")
    public String add(Bonus bonus) {
        if (rewardService.addBonus(bonus)) {
            return "redirect:/reward/table";
        } else {
            return "error/404";
        }
    }

    @RequestMapping("/edit")
    public String edit(Bonus bonus) {
        if (rewardService.editBonus(bonus)) {
            return "redirect:/reward/table";
        } else {
            return "error/404";
        }
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (rewardService.deleteBonus(id)) {
            return "redirect:/reward/table";
        } else {
            return "error/404";
        }
    }

}
