package com.vti.blogapp.dto;

import com.vti.blogapp.entity.Post;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String name;
    private String email;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
