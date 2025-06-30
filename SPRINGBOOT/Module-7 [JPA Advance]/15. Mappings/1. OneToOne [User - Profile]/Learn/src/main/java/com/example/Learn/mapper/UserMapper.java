package com.example.Learn.mapper;

import com.example.Learn.dto.ProfileDTO;
import com.example.Learn.dto.UserDTO;
import com.example.Learn.entity.Profile;
import com.example.Learn.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDTO toDTO(User user);

    ProfileDTO toDTO(Profile profile);

    User toEntity(UserDTO dto);

    Profile toEntity(ProfileDTO dto);

    @AfterMapping
    default void setProfileUserReference(@MappingTarget User user, UserDTO userDTO) {
        if (user.getProfile() != null) {
            user.getProfile().setUser(user);
        }
    }
}
