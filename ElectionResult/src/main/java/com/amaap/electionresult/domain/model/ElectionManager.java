package com.amaap.electionresult.domain.model;

public class ElectionManager {
    public Party createParty(String partyCode, String partyName) {
        return Party.create(partyCode,partyName);
    }
}
