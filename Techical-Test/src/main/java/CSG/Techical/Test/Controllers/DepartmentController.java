package CSG.Techical.Test.Controllers;


import CSG.Techical.Test.Models.Department;
import CSG.Techical.Test.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public Department addDeparment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getAll")
    public List<Department> findAllDepartments(){
        return departmentService.getDepartments();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable int id){
        return departmentService.deleteDepartment(id);
    }

}
