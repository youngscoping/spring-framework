package com.vti.blogapp.service;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.PostCreateForm;
import com.vti.blogapp.form.PostUpdateForm;
import com.vti.blogapp.mapper.PostMapper;
import com.vti.blogapp.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;



    @Override
    public Page<PostDto> findAll(Pageable pageable) {
        return postRepository.findAll(pageable).map(PostMapper::map);
    }

    @Override
    public PostDto findById(Long id) {
        return postRepository.findById(id).map(PostMapper::map).orElse(null);
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public PostDto update(Long id,PostUpdateForm form) {
       var optional = postRepository.findById(id);
       if (optional.isEmpty()) {
           return null;
       }
       var post = optional.get();
       PostMapper.map(form, post);
       var savedPost = postRepository.save(post);
       return PostMapper.map(savedPost);
    }

    @Override
    public void deleteId(Long id) {

    }
}
