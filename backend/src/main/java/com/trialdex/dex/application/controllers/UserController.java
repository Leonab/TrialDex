package com.trialdex.dex.application.controllers;

import com.trialdex.dex.models.User;
import com.trialdex.dex.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final IUserService userService;

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
