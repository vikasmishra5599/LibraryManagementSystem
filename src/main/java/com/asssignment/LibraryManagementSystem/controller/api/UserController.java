package com.asssignment.LibraryManagementSystem.controller.api;

import com.asssignment.LibraryManagementSystem.domain.UserDetail;
import com.asssignment.LibraryManagementSystem.entity.User;
import com.asssignment.LibraryManagementSystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{username}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUsersDetail(@PathVariable @NotBlank final String username) {
        return ResponseEntity.ok(userService.fetchUserDetail(username));
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserDetail userDetail) {
        long userid = userService.createUser(userDetail);
        LOG.info("User with Id [{}] created successfully", userid);
        return ResponseEntity.status(CREATED).build();
    }
}
