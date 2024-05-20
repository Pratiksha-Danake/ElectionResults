package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.validator.PartyDataValidator;

import java.util.Objects;

import static com.amaap.electionresult.domain.model.entity.validator.PartyDataValidator.isInvalidPartyName;

public class Party {
    private String name;
    private int vote;

    private Party(String name, int vote) {
        this.name = name;
        this.vote = vote;
    }

    public static Party create(String name, int vote) throws InvalidPartyNameException {
        if (isInvalidPartyName(name))
            throw new InvalidPartyNameException("Party name can't be: "+ name);
        return new Party(name, vote);
    }

    public String getName() {
        return name;
    }

    public int getVote() {
        return vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return vote == party.vote && Objects.equals(name, party.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vote);
    }
}
