package org.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("test")
    public String test() {
        SecurityManager manager = SecurityUtils.getSecurityManager();
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Object princioal = subject.getPrincipal();
        return "test";
    }
}
