package com.example.Learn.controller;


import com.example.Learn.dto.PostDTO;
import com.example.Learn.dto.UserDTO;
import com.example.Learn.service.PostService;
import com.example.Learn.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable(name = "userId") Long userId){
        UserDTO user = userService.findUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<PostDTO> savePost(@PathVariable(name = "userId") Long userId, @Valid @RequestBody PostDTO postDTO) {
        PostDTO savedPost = postService.savePost(userId, postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

}
