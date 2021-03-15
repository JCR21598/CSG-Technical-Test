package CSG.Techical.Test.Services;


import CSG.Techical.Test.Models.Department;
import CSG.Techical.Test.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /*     HTTP METHODS     */

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getDepartments(){
        return (List<Department>) departmentRepository.findAll();
    }

    public String deleteDepartment(int id){
        departmentRepository.deleteById(id);
        return "Removed Department of ID: " + id;
    }
}
