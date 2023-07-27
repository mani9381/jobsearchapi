package com.mongodb.search.conroller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.search.collection.Posts;
import com.mongodb.search.postsrepo.Joblistrepo;
import com.mongodb.search.postsrepo.Searchrepo;


@RestController
public class Controler {
	@Autowired
	Joblistrepo repo;
	@Autowired
	Searchrepo srepo;
	
	@GetMapping("/allposts")
	public ResponseEntity<List<Posts>> getall(){
		return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<Posts> post(@RequestBody Posts post) {
		return new ResponseEntity<>(repo.insert(post),HttpStatus.OK);
	}
	
	@GetMapping("/userpost/{id}")
	public ResponseEntity<Posts> getpost(@PathVariable String id) {
		Optional<Posts> p= repo.findById(id);
		if(p.isPresent()) {
			return new ResponseEntity<>(p.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/search/{text}")
	public ResponseEntity<List<Posts>> search(@PathVariable String text){
		
		return new ResponseEntity<>(srepo.findByText(text),HttpStatus.OK);
		
		
	}
	@GetMapping("/profile/{pro}")
	public ResponseEntity<Posts> fimd(@PathVariable String pro){
		return new ResponseEntity<>(repo.findByProfile(pro),HttpStatus.OK);
	}
	

}
