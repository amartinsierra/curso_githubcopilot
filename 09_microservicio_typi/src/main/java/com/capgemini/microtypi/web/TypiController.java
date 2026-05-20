package com.capgemini.microtypi.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.caixaba.absis.microtypi.service.TypiService;
import com.capgemini.microtypi.api.TypiApi;
import com.capgemini.microtypi.api.domain.Comment;
import com.capgemini.microtypi.api.domain.Post;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
public class TypiController implements TypiApi {

    private TypiService typiService;

    public TypiController(TypiService typiService) {
        this.typiService = typiService;
    }

    @Override
    public ResponseEntity<Void> createPost(@Valid Post post) {
        typiService.createPost(post);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<List<Comment>> getCommentsByPost(@NotNull @Valid Integer postId) {
        return ResponseEntity.ok(typiService.getCommentsByPost(postId));
    }

    @Override
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(typiService.getPosts());
    }

}