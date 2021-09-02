package com.example.issuetrackingsystem.model;

import com.example.issuetrackingsystem.dto.IssuesDto;

import javax.persistence.*;

@Entity
@Table(name = "Issues")
public class Issues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    @Column(name = "summary")
    private String summary;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "state")
    private String state;

    @ManyToOne
    private Projects projects;

//    public Issues(Long issueId, Projects projects) {
//        this.issueId = issueId;
//        this.projects = projects;
//    }

    public Issues() {

    }

    public Projects getProjects() {
        return projects;
    }

    public static Issues from(IssuesDto issuesDto){
        Issues issues = new Issues();
        issues.setType(issuesDto.getType());
        issues.setSummary(issuesDto.getSummary());
        issues.setState(issuesDto.getState());
        issues.setDescription(issuesDto.getDescription());
        return issues;
    }


    public void setProjects(Projects projects) {
        this.projects = projects;
    }
//    @ManyToOne
//    private Projects project;



    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
