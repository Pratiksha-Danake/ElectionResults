package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.Party;

import java.util.List;

public class WinnerEvaluatorService {

    public String findWinner(List<Constituency> constituenciesData) {
        String constituencyName = null;
        String winnerPartyOfTheConstituency = null;
        for (Constituency constituency : constituenciesData) {
            constituencyName = constituency.getName();
            List<Party> constituencyParties = constituency.getParties();
            winnerPartyOfTheConstituency = getWinnerOfTheConstituency(constituencyParties);
        }

        return winnerPartyOfTheConstituency;
//        Constituency constituency = constituenciesData.get(0);
//        constituency.getName();
//        List<Party> parties = constituency.getParties();
//        Party party = parties.get(0);
//        party.getName();
//        party.getVote();
    }

    private String getWinnerOfTheConstituency(List<Party> constituencyParties) {
        String winnerParty = null;
        int maxVotes = Integer.MIN_VALUE;
        for (Party party : constituencyParties) {
            if (party.getVote() > maxVotes) {
                maxVotes = party.getVote();
                winnerParty = party.getName();
            }
        }
        return winnerParty;
    }
}
