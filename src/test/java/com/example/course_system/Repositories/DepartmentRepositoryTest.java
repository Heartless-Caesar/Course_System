package com.example.course_system.Repositories;

import com.example.course_system.Entities.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp(){
        Department dept = Department.builder()
                .departmentName("ME")
                .departmentCode("04")
                .departmentLocation("MS")
                .build();

        testEntityManager.persist(dept);
    }

    @Test
    public void whenFindById_ReturnDepartment(){
        Department dept = departmentRepository.findById(1L).get();

        assertEquals(dept.getDepartmentName(),"ME");
    }
}