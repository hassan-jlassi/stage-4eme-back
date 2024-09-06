package com.accent.services;

import com.accent.entities.User;

import java.util.List;
import java.util.Optional;

public interface IuserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    User saveUser(User user);
    void deleteUserById(int id);
    User getUserByEmailAndPassword(String email, String password);
}
