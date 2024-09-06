package com.accent.repositories;

import com.accent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailUserAndPasswordUser(String emailUser, String passwordUser);

}
