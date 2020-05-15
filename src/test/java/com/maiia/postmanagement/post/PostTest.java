package com.maiia.postmanagement.post;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.maiia.postmanagement.PostManagementApplicationTests;
import com.maiia.postmanagement.dto.PostDTO;
import com.maiia.postmanagement.model.Post;
import com.maiia.postmanagement.repository.PostRepository;
import com.maiia.postmanagement.serviceImpl.PostServiceImpl;


public class PostTest extends PostManagementApplicationTests {

	@Mock
	private PostRepository postRepository;
	private Post post;
	private List<Post> posts= new ArrayList<>();
	
	@InjectMocks
	private PostServiceImpl postServiceImpl= new PostServiceImpl(postRepository);

	@BeforeEach
	public void setUp() {
		post = new Post();
		post.setId(1L);
		post.setTitle("title");
		posts.add(post);
		when(postRepository.findAll()).thenReturn(posts);
	}

	@DisplayName("Test Mock PostService + PostRepository")
	@Test
	public void test_get_all_posts() {
		
		List<PostDTO> result = postServiceImpl.getPosts();
		assertEquals(1, result.size());
	}

}
