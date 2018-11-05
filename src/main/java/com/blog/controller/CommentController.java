package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("comments", commentService.getAll());
		return "comment";
	}

}
