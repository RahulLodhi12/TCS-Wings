package com.wings.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wings.models.UserInfo;

// Import required annotations to make use of the Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByUsername(String username);
}