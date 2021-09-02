package com.example.issuetrackingsystem.service.impl;

import com.example.issuetrackingsystem.exception.IssueAlreadyAssignedException;
import com.example.issuetrackingsystem.exception.ResourceNotFoundException;
import com.example.issuetrackingsystem.model.Issues;
import com.example.issuetrackingsystem.repository.IssueRepository;
import com.example.issuetrackingsystem.repository.ProjectRepository;
import com.example.issuetrackingsystem.model.Projects;
import com.example.issuetrackingsystem.service.IssueService;
import com.example.issuetrackingsystem.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

//  From Spring 4.3, if a class, which is configured as a Spring bean,
//  has only one constructor, the @Autowired annotation can be
//  omitted and Spring will use that constructor and inject all
//  necessary dependencies.
@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private IssueService issueService;

    public ProjectServiceImpl(ProjectRepository projectRepository, IssueService issueService) {
        this.projectRepository = projectRepository;
        this.issueService = issueService;
    }

    @Override
    public Projects addProject(Projects project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Projects> getAllEmployees() {
        return (List<Projects>) projectRepository.findAll();
    }

    @Override
    public Projects getProject(Long id) {
//        Optional<Projects> projects = projectRepository.findById(id);
//        if (projects.isPresent()) {
//            return projects.get();
//        } else {
//            throw new ResourceNotFoundException("Projects","Id",id);
//        }

//        Another way of doing this is by using lambda expression
        return projectRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Projects","Id",id));
    }

    @Transactional
    @Override
    public Projects updateProjects(Projects project, Long id) {
        Projects existingProject = projectRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Project","Id",id));

        existingProject.setCompanyName(project.getCompanyName());
        existingProject.setName(project.getName());
        existingProject.setKey(project.getKey());

        projectRepository.save(existingProject);
        return existingProject;
    }

    @Override
    public Projects deleteProjects(Long id) {
        // check whether this id exists or not inside the DB
//        projectRepository.findById(id).orElseThrow(() ->
//                new ResourceNotFoundException("Projects","Id",id));
        Projects projects = getProject(id);
        projectRepository.delete(projects);
        return projects;
    }

    // SECTION 2 OF THE SERVICES WHICH INCLUDE THE ISSUE ENTITY
    @Transactional
    @Override
    public Projects addIssueToProject(Long issueId, Long projectId) {
        Projects project = getProject(projectId);
        Issues issue = issueService.getIssue(issueId);
//        To check if the issue has already been assigned to another project
        if(Objects.nonNull(issue.getProjects())) {
            throw new IssueAlreadyAssignedException(issueId,issue.getProjects().getProjectId());
        }
        project.addIssue(issue);
        return project;
    }

    @Transactional
    @Override
    public Projects removeIssueFromCart(Long issueId, Long projectId) {
        Projects project = getProject(projectId);
        Issues issue = issueService.getIssue(issueId);
        project.removeIssue(issue);
        return project;
    }

}
