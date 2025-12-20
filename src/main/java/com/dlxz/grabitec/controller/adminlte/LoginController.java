package com.dlxz.grabitec.controller.adminlte;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/adminlte")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        // 返回模板文件的名称（不需要加 .html 后缀）
        // 假设你的 HTML 文件路径是 src/main/resources/templates/login.html
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
