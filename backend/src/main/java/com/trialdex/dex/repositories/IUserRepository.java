package com.trialdex.dex.repositories;

import com.trialdex.dex.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    Optional<User> findByEmail(String email);
}
