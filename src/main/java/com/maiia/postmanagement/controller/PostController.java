package com.maiia.postmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maiia.postmanagement.dto.PostDTO;
import com.maiia.postmanagement.service.PostService;

@RestController
@RequestMapping("api/post")
public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/all")
	public List<PostDTO> getAllPosts() {
		return postService.getPosts();
	}

}
