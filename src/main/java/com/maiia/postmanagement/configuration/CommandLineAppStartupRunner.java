package com.maiia.postmanagement.configuration;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.maiia.postmanagement.model.Post;
import com.maiia.postmanagement.repository.PostRepository;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	private static final String URL = "https://jsonplaceholder.typicode.com/posts";

	private final Logger log = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
	private RestTemplate restTemplate;
	private PostRepository postRepository;

	public CommandLineAppStartupRunner(RestTemplate restTemplate, PostRepository postRepository) {
		this.restTemplate = restTemplate;
		this.postRepository = postRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("retrieving data on startup");
		try {
			Post[] posts = restTemplate.getForObject(URL, Post[].class);
			List<Post> ListOfPosts = Arrays.asList(posts);
			postRepository.saveAll(ListOfPosts);
		} catch (Exception e) {
			log.error("error while retreiving data ---> " + e.getMessage());
		}
	}
}