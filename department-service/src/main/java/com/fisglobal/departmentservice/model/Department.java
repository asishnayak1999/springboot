package com.fisglobal.departmentservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dept2")
public class Department {
	

	@Id
	@NonNull
	@NotNull
	private String deptId;
	@NonNull
	@NotNull
	@Size(min = 5, max = 20, message = "name should be atleast 5 and max 20")
	private String deptName;
	@NonNull
	@NotNull
	private String deptLoc;
	@Email
	@NonNull
	@NotNull
	private String email;
	@NotNull
	@NonNull
	private double maxDeptSal;
	
	

}


