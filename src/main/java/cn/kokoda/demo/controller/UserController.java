package cn.kokoda.demo.controller;


import cn.kokoda.demo.pojo.User;
import cn.kokoda.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/main";
        } else {
            model.addAttribute("warn", "用户名或者密码错误!");
            return "login";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("repeat_password") String repeatPassword, Model model) {
        if (!password.equals(repeatPassword)) {
            model.addAttribute("warn", "两次输入的密码不一致!");
            return "register";
        } else if (userService.register(username, password)) {
            model.addAttribute("success", "注册成功！");
            return "login";
        }
        return "redirect:/404";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.setAttribute("loginUser", null);
        return "redirect:/";
    }

}
