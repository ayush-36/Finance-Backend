package com.zorvyn.finance.service;

import com.zorvyn.finance.entity.Role;
import com.zorvyn.finance.entity.User;
import com.zorvyn.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User updateRole(Long id, String role) {
        User user = repo.findById(id).orElseThrow();

        user.setRole(Role.valueOf(role.toUpperCase()));
        return repo.save(user);
    }

    public User updateStatus(Long id, boolean active) {
        User user = repo.findById(id).orElseThrow();

        user.setActive(active);
        return repo.save(user);
    }

    public void deleteUser(Long id) {

        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        repo.delete(user);
    }
}