package com.mongodb.search.postsrepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.search.collection.Posts;

public interface Joblistrepo extends MongoRepository<Posts, String>{
	
	Posts  findByProfile(String profile);
}
