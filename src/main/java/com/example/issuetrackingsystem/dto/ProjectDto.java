package com.example.issuetrackingsystem.dto;


import com.example.issuetrackingsystem.model.Issues;
import com.example.issuetrackingsystem.model.Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectDto {

    private Long id;
    private String name;
    private String companyName;
    private String key;
    private List<IssuesDto> issuesDto = new ArrayList<>();

    public static ProjectDto from(Projects projects) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(projects.getProjectId());
        projectDto.setCompanyName(projects.getCompanyName());
        projectDto.setName(projects.getName());
        projectDto.setKey(projects.getKey());
        projectDto.setIssuesDto(projects.getIssues().stream().map(IssuesDto::from).collect(Collectors.toList()));
        return projectDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<IssuesDto> getIssuesDto() {
        return issuesDto;
    }

    public void setIssuesDto(List<IssuesDto> issuesDto) {
        this.issuesDto = issuesDto;
    }
}
