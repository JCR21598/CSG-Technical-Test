package CSG.Techical.Test.Repositories;

import CSG.Techical.Test.Models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    //Link contains an example of how to make special queries to the database.
    //https://www.codejava.net/frameworks/spring-boot/spring-boot-spring-data-jpa-mysql-example

    @Query(value="SELECT department.id, COUNT(employee.depto_id) FROM department LEFT JOIN employee ON department.id = employee.depto_id GROUP BY department.id ORDER BY department.id ASC", nativeQuery = true)
    public List<Employee> getCountPerDepartment();

}
