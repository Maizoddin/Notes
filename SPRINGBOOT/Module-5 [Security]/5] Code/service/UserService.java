package com.example.authentication.service;

import com.example.authentication.dto.SignupRequest;
import com.example.authentication.entity.User;
import com.example.authentication.exception.UsernameAlreadyExistsException;
import com.example.authentication.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public User saveUser(SignupRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            throw new UsernameAlreadyExistsException("User already exists");
        }
        User user = new User();
        user.setName(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    public User findByEmail(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow();
        return user;
    }
}
