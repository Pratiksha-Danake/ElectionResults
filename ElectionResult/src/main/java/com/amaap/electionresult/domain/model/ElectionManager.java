package com.amaap.electionresult.domain.model;

import com.amaap.electionresult.domain.model.exceptions.InvalidPartyCodeException;
import com.amaap.electionresult.domain.model.exceptions.InvalidPartyNameException;

import java.util.ArrayList;
import java.util.List;

public class ElectionManager {
    private List<Party> electionParties = new ArrayList<>();

    public List<Party> getElectionParties() {
        return electionParties;
    }

    public Party createParty(String partyCode, String partyName) throws InvalidPartyNameException, InvalidPartyCodeException {
        return Party.create(partyCode, partyName);
    }

    public void addParty(Party partyToAdd) {
        electionParties.add(partyToAdd);
    }
}
