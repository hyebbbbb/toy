package com.example.toy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.toy.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    public User findByEmailAndPwd(String email, String pwd);
}
