package com.example.issuetrackingsystem.repository;

import com.example.issuetrackingsystem.model.Issues;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issues, Long> {
}
