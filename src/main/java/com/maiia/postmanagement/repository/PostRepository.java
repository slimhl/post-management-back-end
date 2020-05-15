package com.maiia.postmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maiia.postmanagement.model.Post;

public interface PostRepository extends MongoRepository<Post, Long> {

}
