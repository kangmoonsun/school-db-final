package com.school.project.schooldbproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/")
    @ResponseBody
    public String healthCheck() {
        return "hello, pos!";
    }

    @GetMapping("init")
    @ResponseBody
    public String createMockData() {
        demoService.createMockData();
        return "";
    }
}
