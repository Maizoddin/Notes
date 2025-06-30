package com.example.Learn.service;

import com.example.Learn.dto.ProfileDTO;
import com.example.Learn.entity.Profile;
import com.example.Learn.entity.User;
import com.example.Learn.mapper.UserMapper;
import com.example.Learn.repository.ProfileRepository;
import com.example.Learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, UserMapper mapper, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public ProfileDTO save(Long userId, ProfileDTO profileDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Profile profile = mapper.toEntity(profileDTO);
        profile.setUser(user);
        user.setProfile(profile);
        Profile savedProfile = profileRepository.save(profile);
        return mapper.toDTO(savedProfile);
    }

    public ProfileDTO findById(Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile Not Found"));
        return mapper.toDTO(profile);
    }
}