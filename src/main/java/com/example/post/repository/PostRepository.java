package com.example.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.post.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
