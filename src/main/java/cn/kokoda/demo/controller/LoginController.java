package cn.kokoda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/")
    public String main(Model model, HttpSession session) {
        if (session.getAttribute("loginUser") != null) {
            return "redirect:/main";
        } else {
            return "login";
        }
    }
}
