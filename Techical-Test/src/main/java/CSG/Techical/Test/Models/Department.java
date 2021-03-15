package CSG.Techical.Test.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @JsonManagedReference
    @Column(name = "name")
    @OneToMany(mappedBy = "departmentId", cascade = CascadeType.ALL)
    @NotNull
    private Set<Employee> departmentName;

    @Column(name = "location")
    @NotNull
    private String location;


    public Department(int id, Set<Employee> departmentName, String location){
        super();

        this.departmentName = departmentName;
        this.location = location;
    }

    public Department(){
        super();
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


    public Set<Employee> getDepartmentName(){
        return departmentName;
    }

    public void setDepartmentName(Set<Employee> departmentName){
        this.departmentName = departmentName;
    }


    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }
}
