package com.example.issuetrackingsystem.service;

import com.example.issuetrackingsystem.model.Issues;
import com.example.issuetrackingsystem.model.Projects;

import java.util.List;
import java.util.Set;

public interface ProjectService {
    Projects addProject(Projects project);
    List<Projects> getAllEmployees();
    Projects getProject(Long id);
    Projects updateProjects(Projects project, Long id);
    Projects deleteProjects(Long id);
    Projects addIssueToProject(Long issueId, Long projectId);
    Projects removeIssueFromCart(Long issueId, Long projectId);
}
