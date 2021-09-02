package com.example.issuetrackingsystem.exception;

import java.text.MessageFormat;

public class IssueNotFoundException extends RuntimeException {

    public IssueNotFoundException(Long issueId) {
        super(MessageFormat.format("Could not find the requested issue with id: {0}!", issueId));
    }
}
