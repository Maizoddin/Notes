package com.example.Learn.mapper;

import com.example.Learn.dto.PostDTO;
import com.example.Learn.dto.UserDTO;
import com.example.Learn.entity.Post;
import com.example.Learn.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);

    Post toEntity(PostDTO postDTO);

    PostDTO toDTO(Post post);

    @AfterMapping
    default void setPostUserReference(@MappingTarget User user, UserDTO userDTO) {
        if (user.getPosts() != null) {
            for (Post post : user.getPosts()) {
                post.setUser(user);
            }
        }
    }
}
