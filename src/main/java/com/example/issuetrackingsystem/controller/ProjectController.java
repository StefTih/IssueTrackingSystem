package com.example.issuetrackingsystem.controller;

import com.example.issuetrackingsystem.dto.IssuesDto;
import com.example.issuetrackingsystem.dto.ProjectDto;
import com.example.issuetrackingsystem.model.Projects;
import com.example.issuetrackingsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//  @RestController is a convenient annotation that combines @Controller and @ResponseBody, which eliminates
//  the need to annotate every request handling method of the controller handling class.

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getProjects() {
        List<Projects> projects = projectService.getAllEmployees();
        List<ProjectDto> projectDto = projects.stream().map(ProjectDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(projectDto, HttpStatus.OK);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable Long id) {
        Projects project = projectService.getProject(id);
        return new ResponseEntity<>(ProjectDto.from(project),HttpStatus.OK);
    }
//    If we use a ResponseEntity we can provide more details in this class. For example we can add a status, header, etc
//    @RequestBody allows us to retrieve the request body and automatically convert it to Java Object
    @PostMapping("/projects")
    public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto projectDto) {
        System.out.println("CHECK");
        Projects projects = projectService.addProject(Projects.from(projectDto));
        return new ResponseEntity<>(ProjectDto.from(projects), HttpStatus.OK);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long id,@RequestBody ProjectDto projectDto) {
        Projects projects = projectService.updateProjects(Projects.from(projectDto),id);
        return new ResponseEntity<>(ProjectDto.from(projects), HttpStatus.OK);
    }

    @DeleteMapping("projects/{id}")
    public ResponseEntity<ProjectDto> deleteProject(@PathVariable Long id) {
        Projects project = projectService.deleteProjects(id);
        return new ResponseEntity<>(ProjectDto.from(project), HttpStatus.OK);
    }

    @PostMapping("projects/{projectId}/issues/{issueId}/add")
    public ResponseEntity<ProjectDto> addIssueToProject(@PathVariable("projectId") Long projectId,
                                                      @PathVariable("issueId") Long issueId) {
        Projects project = projectService.addIssueToProject(issueId,projectId);
        return new ResponseEntity<>(ProjectDto.from(project),HttpStatus.OK);
    }

    @DeleteMapping("projects/{projectId}/issues/{issueId}/add")
    public ResponseEntity<ProjectDto> removeIssueFromProject(@PathVariable("projectId") Long projectId,
                                                      @PathVariable("issueId") Long issueId) {
        Projects project = projectService.removeIssueFromCart(issueId,projectId);
        return new ResponseEntity<>(ProjectDto.from(project),HttpStatus.OK);
    }

}
