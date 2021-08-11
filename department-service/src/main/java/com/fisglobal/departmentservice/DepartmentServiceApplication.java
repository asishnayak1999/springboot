package com.fisglobal.departmentservice;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.departmentservice.model.Department;
import com.fisglobal.departmentservice.repository.DepartmentRepository;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext context = SpringApplication.run(DepartmentServiceApplication.class, args);
		 DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
		 
	//Department department = new Department("I01","developer","Bangalore","abc@gmail.com",20000);
		 
		//departmentRepository.save(department);
		 
		//context.close();
		 

		 // List<Department> departments = departmentRepository.findAll();
		  //departments.forEach(System.out::println);
		 
	
	}

}
