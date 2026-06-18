package com.mediahub.subscriptionPlan.service;

import com.mediahub.subscriptionPlan.dto.CreateUserRequest;
import com.mediahub.subscriptionPlan.dto.UpdateUserRequest;
import com.mediahub.subscriptionPlan.model.User;
import com.mediahub.subscriptionPlan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // POST
    public Map<String, String> createUser(CreateUserRequest request) {
        Map<String, String> response = new HashMap<>();
        userRepository.findByEmail(request.getEmail()).ifPresent(existing -> {
            throw new IllegalStateException("Email already exists");
        });
        User user = User.builder()
                .name(request.getName())
                .roles(request.getRoles())
                .email(request.getEmail())
                .phone(request.getPhone())
                .country(request.getCountry())
                .build();
        userRepository.save(user);
        response.put("message", "User created successfully");
        return response;
    }

    // GET all
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }

    // GET by ID
    public User fetchUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // PUT
    public Map<String, String> updateUser(Long userId, UpdateUserRequest request) {
        Map<String, String> response = new HashMap<>();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (request.getName() != null) user.setName(request.getName());
        if (request.getPhone() != null) user.setPhone(request.getPhone());
        if (request.getCountry() != null) user.setCountry(request.getCountry());
        userRepository.save(user);
        response.put("message", "User updated successfully");
        return response;
    }
}