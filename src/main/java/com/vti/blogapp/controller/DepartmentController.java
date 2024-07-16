package com.vti.blogapp.controller;

import com.vti.blogapp.dto.DepartmentDto;
import com.vti.blogapp.form.DepartmentCreateForm;
import com.vti.blogapp.form.DepartmentUpdateForm;
import com.vti.blogapp.service.DepartmentService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @GetMapping("/api/v1/departments")
    public List<DepartmentDto> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/api/v1/departments/{id}")
    public DepartmentDto findById(@PathVariable("id") Long id) {
        return departmentService.findById(id);
    }

    @PostMapping("/api/v1/departments")
    public DepartmentDto create(@RequestBody DepartmentCreateForm form) {
        return departmentService.create(form);
    }

    @PutMapping("/api/v1/departments")
    public DepartmentDto update(@PathVariable Long id,@RequestBody DepartmentUpdateForm form) {
        return departmentService.update(id, form);
    }


    @DeleteMapping("/api/v1/departments")
    public void deleteId(@PathVariable("id") Long id) {
        departmentService.deleteId(id);
    }
}
