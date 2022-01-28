package com.trialdex.dex.services;

import com.trialdex.dex.models.User;

public interface IUserService {

    User createUser(User user);

    void updateUser(User user);

    User getUserById(Long id);
}
