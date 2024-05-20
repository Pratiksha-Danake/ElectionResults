package com.amaap.electionresult.domain.model.entity.exception;

public class InvalidVoteCountException extends Throwable {
    public InvalidVoteCountException(String message) {
        super(message);
    }
}
