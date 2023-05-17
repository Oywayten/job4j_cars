package ru.job4j.cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Oywayten 13.05.2023.
 */
@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "redirect:/posts";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login-page";
    }
}
