package com.example.course_system.Controllers;

import com.example.course_system.Entities.Department;
import com.example.course_system.ErrorHandling.DepartmentExceptionHandler;
import com.example.course_system.Services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Department department;

    @MockBean
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("CE")
                .departmentCode("05")
                .departmentLocation("GO")
                .departmentId(1L)
                .build();
    }

    @Test
    void createDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("CE")
                .departmentCode("05")
                .departmentLocation("GO")
                .build();

        Mockito.when(departmentService.createDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/department/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{\n" +
                        "\t\"departmentName\": \"CE\",\n" +
                        "\t\"departmentCode\" : \"05\",\n" +
                        "\t\"departmentLocation\": \"GO\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getSingleDepartment() throws Exception {
        Mockito.when(departmentService.getSingleDepartment(1L)).thenReturn(department);
        mockMvc.perform(get("/department/single/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.departmentName")
                                .value(department.getDepartmentName()));
    }
}