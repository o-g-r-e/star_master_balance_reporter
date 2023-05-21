package com.example.starmanufacture.starmanufacture.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }

    @GetMapping("/workers")
    String workersPage(Model model) {
        return "workers";
    }

    @GetMapping("/items")
    String itemsPage(Model model) {
        return "items";
    }

    @GetMapping("/worktasks")
    String worktasksPage(Model model) {
        return "worktasks";
    }

    @GetMapping("/new_task")
    String newtaskPage(Model model) {
        return "new_task";
    }
}
