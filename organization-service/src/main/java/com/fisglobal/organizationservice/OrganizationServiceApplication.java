package com.fisglobal.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.organizationservice.model.Organization;
import com.fisglobal.organizationservice.repository.OrganizationRepository;


@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OrganizationServiceApplication.class, args);
		OrganizationRepository organizationRepository = context.getBean(OrganizationRepository.class);
		//Organization org1 = new Organization("O001","Fidelity","Bangalore");
		//organizationRepository.save(org1);
		//context.close();
	}
	
}
