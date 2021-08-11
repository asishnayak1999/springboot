package com.fisglobal.organizationservice.controller;

import java.util.List;

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

import com.fisglobal.organizationservice.exception.*;
import com.fisglobal.organizationservice.model.Organization;
import com.fisglobal.organizationservice.repository.OrganizationRepository;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrganizations(){
		
		List<Organization> organization = organizationRepository.findAll();
		if(organization.size()>0) {
			return ResponseEntity.status(HttpStatus.OK).body(organization);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Data Found !!");
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrganizationById(@PathVariable("id") String id) throws ResourceNotFound{
		
		Organization org  = organizationRepository.findById(id).orElseThrow(()->new ResourceNotFound("Organization Not Found >> "+id));
		return ResponseEntity.ok().body(org);
	}
	
	@PostMapping("/addOrg")
	public ResponseEntity<?> createDepartment(@Valid @RequestBody Organization newOrganization)
	{
		if(organizationRepository.existsById(newOrganization.getOrgId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Already exists");
		}
		
		Organization org2 = organizationRepository.save(newOrganization);
		System.out.println(newOrganization);
		if(org2 != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(newOrganization);
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(newOrganization);
		}
		
			
		
	}
	
}
