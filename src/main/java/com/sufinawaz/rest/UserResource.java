package com.sufinawaz.rest;

import com.sufinawaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class UserResource {
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    @ResponseBody
    String home() {
        return userService.getUser();
    }
}
