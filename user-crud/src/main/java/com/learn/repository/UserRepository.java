package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
