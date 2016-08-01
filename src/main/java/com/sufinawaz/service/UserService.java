package com.sufinawaz.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("${app.random.number}")
    private int randomNumber;

    public String getUser() {
        return "User was found: " + randomNumber;
    }
}
