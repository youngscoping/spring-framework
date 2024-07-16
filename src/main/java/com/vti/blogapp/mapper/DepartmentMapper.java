package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.DepartmentDto;
import com.vti.blogapp.entity.Department;
import com.vti.blogapp.form.DepartmentCreateForm;
import com.vti.blogapp.form.DepartmentUpdateForm;

public class DepartmentMapper {
    public static Department map(DepartmentCreateForm form) {
        var department = new Department();
        department.setId(form.getId());
        department.setName(form.getName());
        return department;
    }

    public static DepartmentDto map(Department department){
        var dto = new DepartmentDto();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setCreatedAt(department.getCreatedAt());
        dto.setUpdateAt(department.getCreatedAt());
        return dto;
    }

    public static void map(DepartmentUpdateForm form, Department department) {
        department.setId(form.getId());
        department.setName(form.getName());
    }
}
