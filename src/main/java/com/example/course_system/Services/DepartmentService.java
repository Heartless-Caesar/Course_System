package com.example.course_system.Services;

import com.example.course_system.Entities.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    Department createDepartment(Department deptObj);

    List<Department> findAllDepartments();

    Department getSingleDepartment(Long deptId);

    void deleteDepartment(Long deptId);

    Department updateDepartment(Long deptId, Department deptObj);
}
