package com.sufinawaz.rest;

import com.sufinawaz.model.User;
import com.sufinawaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @ResponseBody
    User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping("/user/{username}")
    @ResponseBody
    User getUser(@PathParam("username") final String username) {
        return userService.getUser(username);
    }
}
