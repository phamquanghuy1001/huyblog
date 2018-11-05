package com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Post;
import com.blog.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postReposiotry;
	
	public Optional<Post> findById(Integer id) {
		
		return postReposiotry.findById(id);
	}

	public List<Post> getAll() {
		return (List<Post>) postReposiotry.findAll();
	}
	
	public Post save(Post post) {
		post.setUserId(1);
		return postReposiotry.save(post);
	}
	public void delete(Integer postId) {
		postReposiotry.deleteById(postId);
	}
}
