package com.example.issuetrackingsystem.controller;

import com.example.issuetrackingsystem.dto.IssuesDto;
import com.example.issuetrackingsystem.model.Issues;
import com.example.issuetrackingsystem.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IssueController {

    @Autowired
    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        super();
        this.issueService = issueService;
    }

    @PostMapping("/issues")
    public ResponseEntity<IssuesDto> addIssue(@RequestBody IssuesDto issuesDto) {
        System.out.println("CHECK2");
        Issues issue = issueService.addIssue(Issues.from(issuesDto));
        return new ResponseEntity<>(IssuesDto.from(issue), HttpStatus.OK);
    }

    @GetMapping("/issues")
    public ResponseEntity<List<IssuesDto>> getAllIssues() {
        List<Issues> issues = issueService.getAllIssues();
        List<IssuesDto> issuesDto = issues.stream().map(IssuesDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(issuesDto, HttpStatus.OK);
    }

    @GetMapping("/issues/{id}")
    public ResponseEntity<IssuesDto> getIssue(@PathVariable Long id) {
        Issues issues = issueService.getIssue(id);
        return new ResponseEntity<>(IssuesDto.from(issues),HttpStatus.OK);
    }

    @DeleteMapping("/issues/{id}")
    public ResponseEntity<IssuesDto> deleteIssue(@PathVariable Long id) {
        Issues issues = issueService.deleteIssue(id);
        return new ResponseEntity<>(IssuesDto.from(issues),HttpStatus.OK);
    }

    @PutMapping("/issues/{id}")
    public ResponseEntity<IssuesDto> updateIssue(@PathVariable Long id, @RequestBody IssuesDto issuesDto) {
        Issues editedIssue = issueService.updateIssue(id,Issues.from(issuesDto));
        return new ResponseEntity<>(IssuesDto.from(editedIssue),HttpStatus.OK);
    }
}
