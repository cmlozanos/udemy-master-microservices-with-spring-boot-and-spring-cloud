package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
