package com.trialdex.dex.controllers;

import com.trialdex.dex.models.User;
import com.trialdex.dex.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public Long createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        if (Objects.nonNull(newUser)) {
            return newUser.getId();
        }
        throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Could not create user");
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) throws Exception {
        User user = userService.getUserById(id);
        if (Objects.nonNull(user)) {
            return user;
        }
        // add ControllerAdvice if needed
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: " + id + " not found");
    }
}
