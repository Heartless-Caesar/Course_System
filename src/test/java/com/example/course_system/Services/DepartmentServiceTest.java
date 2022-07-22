package com.example.course_system.Services;

import com.example.course_system.Entities.Department;
import com.example.course_system.Repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department dept = Department.builder()
                .departmentId(1L)
                .departmentName("IT")
                .departmentCode("01")
                .departmentLocation("MG")
                .build();

        Mockito.when(departmentRepository.findDepartmentByDepartmentNameIgnoreCase("IT"))
                .thenReturn(dept);
    }

    @Test
    @DisplayName("Get dept based on provided name")
    public void validDepartmentName_thenReturnsDepartment(){
        String deptName = "IT";
        Department found = departmentService.findDepartmentByDepartmentName(deptName);

        assertEquals(deptName,found.getDepartmentName());
    }


}