package com.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}