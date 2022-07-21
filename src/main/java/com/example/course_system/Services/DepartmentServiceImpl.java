package com.example.course_system.Services;

import com.example.course_system.Entities.Department;
import com.example.course_system.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Department updateDepartment(Long deptId, Department deptObj) {
        Department dept = departmentRepository.findById(deptId).get();

        if(Objects.nonNull(deptObj.getDepartmentName())
                && !"".equalsIgnoreCase(deptObj.getDepartmentName()))
        {
            dept.setDepartmentName(deptObj.getDepartmentName());
        }

        if(Objects.nonNull(deptObj.getDepartmentCode())
                && !"".equalsIgnoreCase(deptObj.getDepartmentCode())){
            dept.setDepartmentCode(deptObj.getDepartmentCode());
        }

        if(Objects.nonNull(deptObj.getDepartmentLocation())
                && !"".equalsIgnoreCase(deptObj.getDepartmentLocation())){
            dept.setDepartmentLocation(deptObj.getDepartmentLocation());
        }

        return departmentRepository.save(dept);
    }
}
