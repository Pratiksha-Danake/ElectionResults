package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.service.dto.WinnerPartyDto;

import java.util.ArrayList;
import java.util.List;

public class WinnerEvaluatorService {

    public List<WinnerPartyDto> findWinner(List<Constituency> constituenciesData) {
        List<WinnerPartyDto> winnerPartyDtoList = new ArrayList<>();

        for (Constituency constituency : constituenciesData) {
            String constituencyName = constituency.getName();
            List<Party> constituencyParties = constituency.getParties();
            WinnerPartyDto winnerPartyDto = getWinnerOfTheConstituency(constituencyParties);
            winnerPartyDto.setConstituencyName(constituencyName);
            winnerPartyDtoList.add(winnerPartyDto);
        }
        return winnerPartyDtoList;
    }

    private WinnerPartyDto getWinnerOfTheConstituency(List<Party> constituencyParties) {
        String winnerParty = null;
        int maxVotes = Integer.MIN_VALUE;
        int totalVotes = 0;

        for (Party party : constituencyParties) {
            int votes = party.getVote();
            totalVotes += votes;
            if (votes > maxVotes) {
                maxVotes = votes;
                winnerParty = party.getName();
            }
        }

        double percentageOfVotes = getPercentageOfVotes(totalVotes, maxVotes);
        return new WinnerPartyDto(winnerParty, percentageOfVotes);
    }

    private double getPercentageOfVotes(int totalVotes, int maxVotes) {
        double percentage = ((double) maxVotes / totalVotes) * 100;
        return Math.round(percentage * 100.0) / 100.0;
    }
}
