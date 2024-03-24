package com.amaap.electionresult.domain.model;

import com.amaap.electionresult.domain.model.exceptions.InvalidPartyCodeException;
import com.amaap.electionresult.domain.model.exceptions.InvalidPartyNameException;

import java.util.ArrayList;
import java.util.List;

public class ElectionManager {
    private List<Party> electionParties = new ArrayList<>();
    private List<Constituency> constiuencies = new ArrayList<>();

    public List<Party> getElectionParties() {
        return electionParties;
    }

    public List<Constituency> getConstiuencies() {
        return constiuencies;
    }

    public Party createParty(String partyCode, String partyName) throws InvalidPartyNameException, InvalidPartyCodeException {
        return Party.create(partyCode, partyName);
    }

    public void addParty(Party partyToAdd) {
        electionParties.add(partyToAdd);
    }

    public Constituency createConstituency(String constituencyToCreate) {
        return Constituency.create(constituencyToCreate);
    }

    public void addConstituency(Constituency constituencyToAdd) {
        constiuencies.add(constituencyToAdd);
    }
}
