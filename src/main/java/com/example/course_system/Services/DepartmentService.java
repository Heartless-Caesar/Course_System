package com.example.course_system.Services;

import com.example.course_system.Entities.Department;
import com.example.course_system.ErrorHandling.DepartmentExceptionHandler;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department deptObj);

    List<Department> findAllDepartments();

    Department getSingleDepartment(Long deptId) throws DepartmentExceptionHandler;

    void deleteDepartment(Long deptId);

    Department updateDepartment(Long deptId, Department deptObj);

    Department findDepartmentByDepartmentNameIgnoreCase(String deptName);
}
