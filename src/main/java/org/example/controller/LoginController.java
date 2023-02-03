package org.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.example.controller.request.LoginRequest;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public String login(@RequestBody LoginRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(request.getUserName(), request.getPassWord());
        subject.login(token);
        return SecurityUtils.getSubject().getSession().getId().toString();
    }

    @GetMapping("unauth")
    public ResponseEntity<String> unAuth() {
        return new ResponseEntity<>("error auth", HttpStatus.FORBIDDEN);
    }

    @PostMapping("createUser")
    public void createUser(@RequestBody LoginRequest request) {
        userService.addUser(request.getUserName(), request.getPassWord());
    }

    @DeleteMapping("logout")
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
