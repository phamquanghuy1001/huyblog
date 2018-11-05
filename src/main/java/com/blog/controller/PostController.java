package com.blog.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.model.Post;
import com.blog.service.CategoryService;
import com.blog.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "admin/posts", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("posts", postService.getAll());
		model.addAttribute("post", new Post());
		return "posts/list";
	}
	
	@RequestMapping(value = "admin/posts", method = RequestMethod.POST)
	public String save(@ModelAttribute Post post) {
		post.setRegDate(new Timestamp(new Date().getTime()));
		post.setModDate(new Timestamp(new Date().getTime()));
		postService.save(post);
		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "admin/posts/add", method = RequestMethod.GET)
	public String addPage(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("post", new Post());
		return "posts/save";
	}
	
	
	@RequestMapping(value = "admin/posts/update", method = RequestMethod.GET)
	public String updatePage(Model model, @RequestParam("id") Integer id) {
		Post post = postService.findById(id).get();
		model.addAttribute("post", post);
		model.addAttribute("categories", categoryService.getAll());
		return "posts/save";
	}
	
	
	@RequestMapping(value = "admin/posts/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") Integer id) {
		postService.delete(id);
		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public String postClientPage(Model model, @PathVariable("id") Integer id) {
		Post post = postService.findById(id).get();
		model.addAttribute("post", post);
		return "post";
	}

}
