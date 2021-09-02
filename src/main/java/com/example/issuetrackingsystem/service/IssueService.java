package com.example.issuetrackingsystem.service;

import com.example.issuetrackingsystem.model.Issues;
import com.example.issuetrackingsystem.repository.IssueRepository;

import java.util.List;

public interface IssueService {

    Issues addIssue(Issues issue);
    List<Issues> getAllIssues();
    Issues getIssue(Long id);
    Issues deleteIssue(Long id);
    Issues updateIssue(Long id,Issues issue);
}
