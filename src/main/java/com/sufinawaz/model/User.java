package com.sufinawaz.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "users")
public class User {

    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private Long accountId;

    @NotNull
    private String password;
}
