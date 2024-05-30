package com.amaap.electionresult.domain.model.entity.exception;

public class InvalidVoteCountException extends InvalidPartyDataException {
    public InvalidVoteCountException(String message) {
        super(message);
    }
}
