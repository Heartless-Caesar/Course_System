package com.example.course_system.Repositories;

import com.example.course_system.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findDepartmentByDepartmentNameIgnoreCase(String deptName);
}
