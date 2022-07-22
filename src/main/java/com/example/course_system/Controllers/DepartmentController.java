package com.example.course_system.Controllers;

import com.example.course_system.Entities.Department;
import com.example.course_system.ErrorHandling.DepartmentExceptionHandler;
import com.example.course_system.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department/create")
    public Department CreateDepartment(@Valid @RequestBody Department deptObj){
     return departmentService.createDepartment(deptObj);
    }

    @GetMapping("/departments")
    public List<Department> GetDepartments(){
        return departmentService.findAllDepartments();
    }

    @GetMapping("/department/{id}")
    public Department GetSingleDepartment(@PathVariable("id") Long deptId) throws DepartmentExceptionHandler {
        return departmentService.getSingleDepartment(deptId);
    }

    @GetMapping("/department/{name}")
    public Department GetDepartmentByName(@PathVariable("name") String deptName){
        return departmentService.findDepartmentByDepartmentName(deptName);
    }

    @DeleteMapping("/department/delete/{id}")
    public String DeleteDepartment(@PathVariable("id") Long deptId){
         departmentService.deleteDepartment(deptId);
         return "Department deleted";
    }

    @PatchMapping("/department/update/{id}")
    public Department UpdateDepartment(@PathVariable("id") Long deptId, @RequestBody Department deptObj){
        return departmentService.updateDepartment(deptId,deptObj);
    }
}
