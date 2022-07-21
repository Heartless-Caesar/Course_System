package com.example.course_system.Services;

import com.example.course_system.Entities.Department;
import com.example.course_system.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department deptObj) {
        return departmentRepository.save(deptObj);
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getSingleDepartment(Long deptId) {
        return departmentRepository.findById(deptId).get();
    }

    @Override
    public void deleteDepartment(Long deptId) {
        departmentRepository.deleteById(deptId);
    }
}
