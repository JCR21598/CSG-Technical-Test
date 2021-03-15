package CSG.Techical.Test.Services;


import CSG.Techical.Test.Models.Employee;
import CSG.Techical.Test.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    /*     HTTP METHODS     */

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public String deleteEmployee(int id){
        employeeRepository.deleteById(id);
        return "Removed Employee of ID: " + id;
    }


    /*     Custom Method(s)    */

    public List<Employee> getEmployeesPerDepartment(){
        return employeeRepository.getCountPerDepartment();
    }



}
