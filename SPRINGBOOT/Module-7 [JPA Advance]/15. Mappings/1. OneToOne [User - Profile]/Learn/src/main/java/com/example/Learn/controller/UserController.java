package com.example.Learn.controller;

import com.example.Learn.dto.ProfileDTO;
import com.example.Learn.dto.UserDTO;
import com.example.Learn.service.ProfileService;
import com.example.Learn.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    private final ProfileService profileService;

    @Autowired
    public UserController(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping("/users/{userId}/profiles")
    public ResponseEntity<ProfileDTO> saveProfile(@PathVariable(name = "userId") Long userId, @Valid @RequestBody ProfileDTO profileDTO) {
        ProfileDTO savedProfile = profileService.save(userId, profileDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(profileDTO);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable(name = "userId") Long id) {
        UserDTO user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @RequestMapping("/users/{userId}/profile")
    public ResponseEntity<ProfileDTO> findProfileByUserId(@PathVariable(name = "userId") Long id) {
        ProfileDTO profile = profileService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(profile);
    }

    /*
    * Here as user in profile is lazy so it does only one query to fetch the profile based on
    * user_id and then while mapping to entity it maps an proxy object of user which has only
    * the id which is fetched. and later if required then it does the second query when we access
    * profile.getUser() else no.
    * If fetch type is eager then it does the join query and fetches both and maps to entities.
    * */

}
