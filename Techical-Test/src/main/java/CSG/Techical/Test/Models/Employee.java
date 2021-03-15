package CSG.Techical.Test.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    private String employeeName;

    @Column(name = "salary")
    @NotNull
    private int salary;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "depto_id", nullable = false)
    private Department departmentId;


    public Employee(int id, String employeeName, int salary, Department departmentId){
        super();

        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public Employee(){
        super();
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


    public String getEmplooyeeName(){
        return employeeName;
    }

    public void setEmplooyeeName(String emplooyeeName){
        this.employeeName = emplooyeeName;
    }


    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }


    public Department getDepartmentId(){
        return departmentId;
    }

    public void setDepartmentId(Department departmentId){
        this.departmentId = departmentId;
    }
}
