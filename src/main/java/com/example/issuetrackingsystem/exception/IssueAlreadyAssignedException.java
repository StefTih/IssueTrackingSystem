package com.example.issuetrackingsystem.exception;

import java.text.MessageFormat;

public class IssueAlreadyAssignedException extends RuntimeException {
    public IssueAlreadyAssignedException(Long issueId, Long projectId) {
        super(MessageFormat.format("Issue with id number {0} is already assigned to project {0}"
                ,issueId, projectId));
    }
}
