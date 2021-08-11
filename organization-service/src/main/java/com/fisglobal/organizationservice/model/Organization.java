package com.fisglobal.organizationservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "org")
public class Organization {
	
	@Id
	@NonNull
	@NotNull
	@Size(min = 3, message = "Id should be atleast 3")
	private String orgId;
	@NonNull
	@NotNull
	@Size(min = 5, max = 20, message = "name should be atleast 5 and max 20")
	private String orgtName;
	@NonNull
	@NotNull
	private String orgLoc;
}
