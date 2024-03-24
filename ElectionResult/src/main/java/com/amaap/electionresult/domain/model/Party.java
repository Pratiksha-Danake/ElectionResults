package com.amaap.electionresult.domain.model;

import com.amaap.electionresult.domain.model.exceptions.InvalidPartyCodeException;
import com.amaap.electionresult.domain.model.exceptions.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.validators.PartyValidator;

import java.util.Objects;

public class Party {
    private String code;
    private String name;

    private Party(String partyCode, String partyName) {
        this.code = code;
        this.name = name;
    }

    public static Party create(String partyCode, String partyName) throws InvalidPartyNameException, InvalidPartyCodeException {
        if (!PartyValidator.isValidPartyName(partyName))
            throw new InvalidPartyNameException("parry name cannot be empty or null");
        else if (!PartyValidator.isValidPartyCode(partyCode))
            throw new InvalidPartyCodeException("parry code cannot be empty or null");
        return new Party(partyCode, partyName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return Objects.equals(code, party.code) && Objects.equals(name, party.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
