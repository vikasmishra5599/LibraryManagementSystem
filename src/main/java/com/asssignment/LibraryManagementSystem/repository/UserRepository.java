package com.asssignment.LibraryManagementSystem.repository;

import com.asssignment.LibraryManagementSystem.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmailid(String username);
}
