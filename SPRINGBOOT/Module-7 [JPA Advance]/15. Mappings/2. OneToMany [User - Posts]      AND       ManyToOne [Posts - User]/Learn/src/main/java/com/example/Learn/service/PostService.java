package com.example.Learn.service;

import com.example.Learn.dto.PostDTO;
import com.example.Learn.entity.Post;
import com.example.Learn.entity.User;
import com.example.Learn.mapper.UserMapper;
import com.example.Learn.repository.PostRepository;
import com.example.Learn.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public PostService(PostRepository postRepository, UserMapper mapper, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Transactional
    public PostDTO savePost(Long userID, PostDTO postDTO) {
        User user = userRepository.findById(userID)
                .orElseThrow();
        Post post = mapper.toEntity(postDTO);
        post.setUser(user);
        user.getPosts().add(post);
        Post savedPost = postRepository.save(post);
        return mapper.toDTO(savedPost);
    }
}
