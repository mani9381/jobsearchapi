package com.mongodb.search.postsrepo;

import java.util.List;

import com.mongodb.search.collection.Posts;

public interface Searchrepo {
	List<Posts> findByText(String text);
}
