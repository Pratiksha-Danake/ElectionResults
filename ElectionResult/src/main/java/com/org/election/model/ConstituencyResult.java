package com.org.election.model;

import java.util.HashMap;
import java.util.Map;

public class ConstituencyResult {
    private String constituency;
    private Map<String, Integer> partyVotes;

    public ConstituencyResult(String constituency) {
        this.constituency = constituency;
        this.partyVotes = new HashMap<>();
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public Map<String, Integer> getPartyVotes() {
        return partyVotes;
    }

    public void setPartyVotes(Map<String, Integer> partyVotes) {
        this.partyVotes = partyVotes;
    }
}
