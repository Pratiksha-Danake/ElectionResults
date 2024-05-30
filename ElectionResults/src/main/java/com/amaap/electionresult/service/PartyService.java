package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidVoteCountException;

import java.io.FileNotFoundException;

public class PartyService {

    public Party createParty(String partyName, int voteCount) throws InvalidPartyNameException, FileNotFoundException, InvalidVoteCountException {
        return Party.create(partyName,voteCount);
    }
}
