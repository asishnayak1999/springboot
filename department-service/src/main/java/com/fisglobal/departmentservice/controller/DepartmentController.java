package com.fisglobal.departmentservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.departmentservice.exception.ResourceNotFound;
import com.fisglobal.departmentservice.model.Department;
import com.fisglobal.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDepartments()
	{
		List<Department> departments = departmentRepository.findAll();
		if(departments.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(departments);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No data found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) throws ResourceNotFound
	{

		Department dept = departmentRepository.findById(id).orElseThrow(()->new ResourceNotFound("Employee not found :: "+id));
		return ResponseEntity.ok().body(dept);
//		Optional<Department> optional= departmentRepository.findById(id);
//		
//		if(optional.isPresent()) {
//			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
//		}
//		else
//		{
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record exists for Department having dID= " +id);
//		}
	}

	@PostMapping("/addDept")
	public ResponseEntity<?> createDepartment(@Valid @RequestBody Department newDepartment)
	{
		if(departmentRepository.existsById(newDepartment.getDeptId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Already exists");
		}
		
		Department dept2 = departmentRepository.save(newDepartment);
		System.out.println(newDepartment);
		if(dept2 != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(newDepartment);
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(newDepartment);
		}
		
			
		
	}
}
