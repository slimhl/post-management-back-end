package com.maiia.postmanagement.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.maiia.postmanagement.dto.PostDTO;
import com.maiia.postmanagement.model.Post;
import com.maiia.postmanagement.repository.PostRepository;
import com.maiia.postmanagement.service.PostService;
import com.maiia.postmanagement.utility.ObjectMapper;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public List<PostDTO> getPosts() {
		List<Post> orderedPosts = new ArrayList<>();
		List<Post> posts = postRepository.findAll();
		posts.sort(Comparator.comparing(Post::getTitle));
		orderedPosts = posts.stream().limit(50).collect(Collectors.toList());
		return ObjectMapper.mapAll(orderedPosts, PostDTO.class);
	}

}
