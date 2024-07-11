package com.vti.blogapp.service;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.PostCreateForm;
import com.vti.blogapp.form.PostUpdateForm;
import com.vti.blogapp.mapper.PostMapper;
import com.vti.blogapp.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;


    @Override
    public List<PostDto> findAll() {
        var post = postRepository.findAll();
        var dtos = new ArrayList<PostDto>();
        for (Post post : posts) {
            var dto = PostMapper.map(post);
            dto.add(dto);
        }
        return dtos;
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
    public PostDto update(PostUpdateForm form) {
        return null;
    }

    @Override
    public void deleteId(Long id) {

    }
}
