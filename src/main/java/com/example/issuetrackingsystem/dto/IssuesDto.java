package com.example.issuetrackingsystem.dto;

import com.example.issuetrackingsystem.model.Issues;

public class IssuesDto {
    private Long id;
    private String summary;
    private String description;
    private String type;
    private String state;

    public static IssuesDto from(Issues issues) {
        IssuesDto issuesDto = new IssuesDto();
        issuesDto.setId(issues.getIssueId());
        issuesDto.setDescription(issues.getDescription());
        issuesDto.setSummary(issues.getSummary());
        issuesDto.setState(issues.getState());
        issuesDto.setType(issues.getType());
        return issuesDto;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
