package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;

import java.io.FileNotFoundException;

public class PartyService {

    public Party createParty(String partyName, int voteCount) throws FileNotFoundException, InvalidPartyDataException {
        return Party.create(partyName, voteCount);
    }
}
