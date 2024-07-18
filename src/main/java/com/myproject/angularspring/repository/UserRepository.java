package com.myproject.angularspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.angularspring.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
    User findFirstByEmail(String email);    
}