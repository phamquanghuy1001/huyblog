package com.blog.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

import com.blog.service.PostService;

@Controller
public class HomeController {
	
	@Autowired
	private LocaleResolver localeResolver;

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		Locale locale = localeResolver.resolveLocale(request);
		model.addAttribute("posts", postService.getAll());
		System.out.println(locale.getDisplayLanguage());

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String page404() {

		return "404";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("posts", postService.getAll());
		return "admin";
	}

	@GetMapping("/international")
	public String getInternationalPage() {
		return "international";
	}

}
