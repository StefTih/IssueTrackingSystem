package com.example.issuetrackingsystem.model;

import com.example.issuetrackingsystem.dto.ProjectDto;
import com.example.issuetrackingsystem.model.Issues;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name")
    private String name;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "`key`")
    private String key;

    @OneToMany(
//            mappedBy = "projects",
            cascade = CascadeType.ALL
//            orphanRemoval = true //if we remove the project all the issues will be removed together with the project
    )
    @JoinColumn(name = "project_id")
    private List<Issues> issues = new ArrayList<>();

    public static Projects from(ProjectDto projectDto) {
        Projects projects = new Projects();
        projects.setCompanyName(projectDto.getCompanyName());
        projects.setName(projectDto.getName());
        projects.setKey(projectDto.getKey());
        return projects;
    }

    public Projects(String name) {
        this.name = name;
    }

    public Projects() {

    }

    public List<Issues> getIssues() {
        return issues;
    }

    public void setIssues(List<Issues> issues) {
        this.issues = issues;
    }

    public void addIssue(Issues issue) {
        issues.add(issue);
    }

    public void removeIssue(Issues issue) {
        issues.remove(issue);
    }

    public Long getProjectId() {
        return projectId;
    }


    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
