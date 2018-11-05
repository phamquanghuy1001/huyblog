package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Comment;
import com.blog.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public List<Comment> getAll() {
		return (List<Comment>) commentRepository.findAll();
	}
}
