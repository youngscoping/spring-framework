package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.form.CommentCreateForm;
import com.vti.blogapp.form.CommentUpdateForm;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();

    List<CommentDto> findByPostId();

    CommentDto findById(Long id);

    CommentDto create(Long postId, CommentCreateForm form);

    CommentDto update(Long id, CommentUpdateForm form);

    void deleteById(Long id);
}
