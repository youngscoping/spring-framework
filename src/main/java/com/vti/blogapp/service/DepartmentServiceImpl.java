package com.vti.blogapp.service;

import com.vti.blogapp.dto.DepartmentDto;
import com.vti.blogapp.entity.Department;
import com.vti.blogapp.form.DepartmentCreateForm;
import com.vti.blogapp.form.DepartmentUpdateForm;
import com.vti.blogapp.mapper.DepartmentMapper;
import com.vti.blogapp.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> findAll() {
        var departments = departmentRepository.findAll();
        var dtos = new ArrayList<DepartmentDto>();
        for (Department department : departments) {
            var dto = DepartmentMapper.map(department);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public DepartmentDto findById(Long id) {
        return departmentRepository.findById(id).map(DepartmentMapper::map).orElse(null);
    }

    @Override
    public DepartmentDto create(DepartmentCreateForm form) {
        var department = DepartmentMapper.map(form);
        var savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.map(department);
    }

    @Override
    public DepartmentDto update(Long id, DepartmentUpdateForm form) {
        var optional = departmentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var department = optional.get();
        DepartmentMapper.map(form, department);
        var savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.map(department);
    }

    @Override
    public void deleteId(Long id) {

    }
}
