package com.example.MultiLinks.Repositories;

import com.example.MultiLinks.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByName(String name);
    User findByNameAndEmail(String name, String email);
}
