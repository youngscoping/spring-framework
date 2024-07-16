package com.vti.blogapp.controller;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.form.CommentCreateForm;
import com.vti.blogapp.form.CommentUpdateForm;
import com.vti.blogapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("/api/v1/comments")
    public List<CommentDto> findAll() {
        return commentService.findAll();
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDto findById(@PathVariable("id") Long id) {
        return commentService.findById(id);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(@PathVariable("postId") Long postId,@RequestBody  CommentCreateForm form) {
        return commentService.create(postId, form);
    }

    @PutMapping("/api/v1/comments/{id}")
    public CommentDto update(
            @PathVariable("id") Long id,
     @RequestBody  CommentUpdateForm form) {
        return commentService.update(id, form);
    }

    public void deleteById(@PathVariable("id") Long id) {
        commentService.deleteById(id);
    }
}
