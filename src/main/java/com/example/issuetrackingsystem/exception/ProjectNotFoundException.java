package com.example.issuetrackingsystem.exception;

import java.text.MessageFormat;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(Long issueId) {
        super(MessageFormat.format("Could not find the requested project with id: {0}!", issueId));
    }
}
