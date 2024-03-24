package com.amaap.electionresult.domain.model.validators;

import com.amaap.electionresult.domain.model.exceptions.InvalidPartyNameException;

public class PartyValidator {

    public boolean isValidPartyName(String partyName) throws InvalidPartyNameException {
        if (partyName == null || partyName.isEmpty())
            throw new InvalidPartyNameException("Part name cannot be null or empty");
        return true;
    }
}
