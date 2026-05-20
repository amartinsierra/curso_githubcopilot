package com.caixaba.absis.microtypi.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.capgemini.microtypi.api.domain.Comment;
import com.capgemini.microtypi.api.domain.Post;
@Service
public class TypiServiceImpl implements TypiService {

	private String url = "https://jsonplaceholder.typicode.com";
	private RestClient restClient;

	public TypiServiceImpl(RestClient.Builder builder) {
		this.restClient = builder.baseUrl(url).build();
	}

	@Override
	public List<Post> getPosts() {
		return restClient.get()
				.uri("/posts")
				.retrieve()
				.body(new ParameterizedTypeReference<List<Post>>() {});
	}

	@Override
	public List<Comment> getCommentsByPost(Integer postId) {
		return restClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/comments")
						.queryParam("postId", postId)
						.build())
				.retrieve()
				.body(new ParameterizedTypeReference<List<Comment>>() {});
	}

	@Override
	public void createPost(Post post) {
		restClient.post()
				.uri("/posts")
				.contentType(MediaType.APPLICATION_JSON)
				.body(post)
				.retrieve()
				.toBodilessEntity();
	}

}