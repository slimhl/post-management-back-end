package com.maiia.postmanagement.dto;

import java.util.List;

import com.maiia.postmanagement.model.Post;

public class PostList {
	private List<Post> posts;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
