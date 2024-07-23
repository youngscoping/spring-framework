package com.vti.blogapp.validation;

import com.vti.blogapp.repository.CommentRepository;
import com.vti.blogapp.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CommentIdExistsValidator implements ConstraintValidator<CommentIdExists, Long> {

    private CommentRepository commentRepository;
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return commentRepository.existsById(id);
    }
}
