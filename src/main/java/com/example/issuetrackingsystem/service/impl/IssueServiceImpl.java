package com.example.issuetrackingsystem.service.impl;

import com.example.issuetrackingsystem.exception.ResourceNotFoundException;
import com.example.issuetrackingsystem.model.Issues;
import com.example.issuetrackingsystem.repository.IssueRepository;
import com.example.issuetrackingsystem.repository.ProjectRepository;
import com.example.issuetrackingsystem.service.IssueService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IssueServiceImpl implements IssueService {

    private IssueRepository issueRepository;

    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public Issues addIssue(Issues issue) {
        return issueRepository.save(issue);
    }

    @Override
    public List<Issues> getAllIssues() {
        return (List<Issues>) issueRepository.findAll();

//        This is another way to return the list of all lists using a stream
//        return StreamSupport
//                .stream(issueRepository.findAll().spliterator(), false)
//                .collect(Collectors.toList());
    }

    @Override
    public Issues getIssue(Long id) {
        return issueRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Issues","Id",id));
    }

    @Override
    public Issues deleteIssue(Long id) {
        Issues issues = getIssue(id);
         issueRepository.delete(issues);
         return issues;
    }

    @Transactional
    @Override
    public Issues updateIssue(Long id,Issues issue) {
        Issues issueToUpdate = getIssue(id);
        issueToUpdate.setDescription(issue.getDescription());
        issueToUpdate.setState(issue.getState());
        issueToUpdate.setSummary(issue.getSummary());
        issueToUpdate.setType(issue.getType());

        issueRepository.save(issueToUpdate);
        return  issueToUpdate;
    }



}
