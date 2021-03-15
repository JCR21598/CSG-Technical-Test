CREATE DATABASE csgdb;


USE csgdb; -- Select the DB 


CREATE TABLE Department(
	id 	int NOT NULL AUTO_INCREMENT, 
    name varchar(50) NOT NULL,
    location varchar(50) NOT NULL,
    
    PRIMARY KEY(id)
);

INSERT INTO department(name, location) Values("Executive", "Sydney");
INSERT INTO department(name, location) Values("Production", "Sydney");
INSERT INTO department(name, location) Values("Resources", "Cape Town");
INSERT INTO department(name, location) Values("Technical", "Texas");
INSERT INTO department(name, location) Values("Management", "Paris");


CREATE TABLE Employee(
	id 	int NOT NULL AUTO_INCREMENT, 
    name varchar(50) NOT NULL,
    salary int NOT NULL,
    depto_id int,
    
    PRIMARY KEY(id), 
    FOREIGN KEY (depto_id) REFERENCES department(id)
);

INSERT INTO employee(name, salary, depto_id) Values("Candice", 4685, 1);
INSERT INTO employee(name, salary, depto_id) Values("Julia", 2559, 2);
INSERT INTO employee(name, salary, depto_id) Values("Bob", 4405, 4);
INSERT INTO employee(name, salary, depto_id) Values("Scarlet", 2350, 1);
INSERT INTO employee(name, salary, depto_id) Values("Ilena", 1151, 4);


SELECT * FROM department;
SELECT * FROM employee;


SELECT department.id AS "Department ID", department.name AS "Department Name", COUNT(employee.depto_id) AS "Number of Employee"
FROM department
LEFT JOIN employee
	ON department.id = employee.depto_id
GROUP BY department.id
ORDER BY department.id ASC;


