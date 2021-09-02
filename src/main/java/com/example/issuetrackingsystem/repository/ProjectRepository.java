package com.example.issuetrackingsystem.repository;

import com.example.issuetrackingsystem.model.Projects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//  Spring Data JPA internally provides @Repository annotation so we do not need to add the annotation
//  to EmployeeRepository interface.
public interface ProjectRepository extends CrudRepository<Projects, Long> {

}
