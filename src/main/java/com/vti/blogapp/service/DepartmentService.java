package com.vti.blogapp.service;

import com.vti.blogapp.dto.DepartmentDto;
import com.vti.blogapp.form.DepartmentCreateForm;
import com.vti.blogapp.form.DepartmentUpdateForm;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAll();

    DepartmentDto findById(Long id);

    DepartmentDto create(DepartmentCreateForm form);

    DepartmentDto update(Long id, DepartmentUpdateForm form);

    void deleteId(Long id);
}
