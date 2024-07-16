package com.vti.blogapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DepartmentDto {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
