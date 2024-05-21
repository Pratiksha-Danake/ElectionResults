package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.service.dto.WinnerPartyDto;

import java.util.List;

public class WinnerEvaluatorService {
    private int totalVotes = 0;

    public WinnerPartyDto findWinner(List<Constituency> constituenciesData) {
        String constituencyName = null;
        WinnerPartyDto winnerParty = null;
        for (Constituency constituency : constituenciesData) {
            constituencyName = constituency.getName();
            List<Party> constituencyParties = constituency.getParties();
            winnerParty = getWinnerOfTheConstituency(constituencyParties);
        }
        winnerParty.setConstituencyName(constituencyName);
        return winnerParty;
    }

    private WinnerPartyDto getWinnerOfTheConstituency(List<Party> constituencyParties) {
        String winnerParty = null;
        int maxVotes = Integer.MIN_VALUE;
        for (Party party : constituencyParties) {
            int votes = party.getVote();
            if (votes > maxVotes) {
                maxVotes = votes;
                totalVotes += votes;
                winnerParty = party.getName();
            }
        }
        double percentageOfVotes = getPercentageOfVotes(totalVotes, maxVotes);
        return new WinnerPartyDto(winnerParty, percentageOfVotes);
    }

    private double getPercentageOfVotes(int totalVotes, int maxVotes) {
        double percentage = ((double) maxVotes / totalVotes) * 100;
        double percentageOfVotes = Math.round(percentage * 100.0) / 100.0;
        return percentageOfVotes;
    }
}
