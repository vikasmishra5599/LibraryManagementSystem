package com.asssignment.LibraryManagementSystem.service;

import com.asssignment.LibraryManagementSystem.domain.UserDetail;
import com.asssignment.LibraryManagementSystem.entity.User;
import com.asssignment.LibraryManagementSystem.exception.CreationFailureException;
import com.asssignment.LibraryManagementSystem.exception.NotFoundException;
import com.asssignment.LibraryManagementSystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;
import static java.lang.String.format;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User fetchUserDetail(String username) {
        try {
            return userRepository.findByEmailid(username);
        } catch (Exception e) {
            LOG.warn("User with name {} was not found", username, e);
            throw new NotFoundException(format("User with name [%s] not found", username), e);
        }
    }

    public long createUser(UserDetail userDetail) {
        User user = mapToUser(userDetail);
        try {
            LOG.info("Create user request received");
            User newUser = userRepository.save(user);
            return newUser.getId();
        } catch (Exception e) {
            LOG.warn("An error occurred while creating user", e);
            throw new CreationFailureException("Failed to create user", e);
        }
    }

    private User mapToUser(UserDetail userDetail) {
        User user = new User();
        user.setEmailid(userDetail.getEmailid());
        user.setContactno(userDetail.getContactno());
        user.setFirstname(userDetail.getFirstname());
        user.setLastname(userDetail.getLastname());
        user.setCreatedtime(ZonedDateTime.now());
        return user;
    }
}
