package com.example.Learn.service;

import com.example.Learn.dto.UserDTO;
import com.example.Learn.entity.User;
import com.example.Learn.mapper.UserMapper;
import com.example.Learn.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserService(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Transactional
    public UserDTO saveUser(UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return mapper.toDTO(savedUser);
    }

    public UserDTO findUserById(Long id){
        User user = userRepository.findById(id).orElseThrow();
        return mapper.toDTO(user);
    }
}
