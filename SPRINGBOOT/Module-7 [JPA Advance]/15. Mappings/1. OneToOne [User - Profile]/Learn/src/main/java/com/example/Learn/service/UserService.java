package com.example.Learn.service;

import com.example.Learn.dto.UserDTO;
import com.example.Learn.entity.User;
import com.example.Learn.mapper.UserMapper;
import com.example.Learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired
    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDTO save(UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        User savedUser = repository.save(user);
        return mapper.toDTO(savedUser);
    }

    public UserDTO findById(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        return mapper.toDTO(user);
    }

}
