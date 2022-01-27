package com.trialdex.dex.controllers;

import com.trialdex.dex.models.User;
import com.trialdex.dex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) throws Exception {
        User user = userService.getUserById(id);
        if(Objects.nonNull(user)) {
            return user;
        }
        // add ControllerAdvice if needed
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: " + id + " not found");
    }
}
