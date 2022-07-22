package com.example.course_system.Services;

import com.example.course_system.Entities.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void validDepartmentName_thenReturnsDepartment(){
        String deptName = "IT";
        Department found = departmentService.findDepartmentByDepartmentName(deptName);

        assertEquals(deptName,found.getDepartmentName());
    }


}