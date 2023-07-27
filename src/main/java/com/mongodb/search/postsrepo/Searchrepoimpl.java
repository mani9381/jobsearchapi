package com.mongodb.search.postsrepo;

import java.util.List;


import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.search.collection.Posts;

@Component

public class Searchrepoimpl implements Searchrepo {
	@Autowired
	MongoClient client;
	
	@Autowired
	MongoConverter converter;

	@Override
	public List<Posts> findByText(String text) {
		
		
	
		// TODO Auto-generated method stub
		final List<Posts> posts = new ArrayList<>();
		
		MongoDatabase database = client.getDatabase("search");
        MongoCollection<Document> collection = database.getCollection("posts");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("skills", "description", "profile")))),
                        new Document("$sort",
                        new Document("exp", 1L)),
                        new Document("$limit", 5L)));
        result.forEach(doc -> posts.add(converter.read(Posts.class, doc)));
		
		
		return posts;
	}

}
