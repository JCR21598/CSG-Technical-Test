package CSG.Techical.Test.Controllers;

import CSG.Techical.Test.Models.Employee;
import CSG.Techical.Test.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



// https://www.dariawan.com/tutorials/rest/http-methods-spring-restful-services/


@RestController
// "/api/employee"
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        int i = 1;
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/add/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id){

        Employee storedEmployee = employeeService.getEmployeeById(id);

        storedEmployee.setEmplooyeeName(employee.getEmplooyeeName());
        storedEmployee.setSalary(employee.getSalary());
        storedEmployee.setDepartmentId(employee.getDepartmentId());

        return employee;
    }

    @GetMapping("/getAll")
    public List<Employee> findAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee findEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }



    @GetMapping("/employeePerDepartment")
    public List<Employee> findEmployeePerDepartment(){
        return employeeService.getEmployeesPerDepartment();
    }


}
