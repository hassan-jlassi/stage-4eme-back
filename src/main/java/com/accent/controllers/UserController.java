package com.accent.controllers;

import com.accent.entities.User;
import com.accent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserById(id);

        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setNomUser(updatedUser.getNomUser());
            userToUpdate.setPrenomUser(updatedUser.getPrenomUser());
            userToUpdate.setEmailUser(updatedUser.getEmailUser());
            userToUpdate.setPasswordUser(updatedUser.getPasswordUser());
            userToUpdate.setRole(updatedUser.getRole());
            userToUpdate.setDepartement(updatedUser.getDepartement());

            return userService.saveUser(userToUpdate);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
    }
}
