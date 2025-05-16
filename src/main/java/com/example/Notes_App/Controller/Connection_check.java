package com.example.Notes_App.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Connection_check {
    // This is a simple controller to check if the application is running
    @GetMapping("/check")
    public String check() {
        return "Application is running";
    }
}
