package com.amaap.electionresult.domain;

import com.amaap.electionresult.domain.exceptions.InvalidPartyException;
import com.amaap.electionresult.domain.model.ConstituencyResult;
import com.amaap.electionresult.domain.model.PartyCodeConverter;
import com.amaap.electionresult.domain.service.WinnerDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataAnalyzer {
    static final int totalVotes = 2100;

    public List<WinnerDisplay> findWinner(List<ConstituencyResult> constituencyResult) throws InvalidPartyException {
        List<WinnerDisplay> winnersList = new ArrayList<>();
        for (ConstituencyResult result : constituencyResult) {
            String constituency = result.getConstituency();
            Map<String, Integer> partyVotes = result.getPartyVotes();
            winnersList.add(findWinnerParties(constituency,partyVotes));
        }
        return winnersList;
    }

    private WinnerDisplay findWinnerParties(String constituency, Map<String, Integer> partyVotes) throws InvalidPartyException {
        String winnerParty = null;
        double percentageOfVotes;
        int maxVotes = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : partyVotes.entrySet()) {
            String partyCode = entry.getKey();
            if(isValidParty(partyCode))
                throw new InvalidPartyException("Party does not exists..!");
            int votes = entry.getValue();
            if (votes > maxVotes) {
                maxVotes = votes;
                winnerParty = partyCode;
            }
        }
        percentageOfVotes = (double) maxVotes / totalVotes * 100;
        return new WinnerDisplay(constituency,winnerParty,maxVotes,percentageOfVotes);
    }

    private static boolean isValidParty(String partyCode) {
        if (PartyCodeConverter.getPartyFullName(partyCode).isEmpty())
            return true;
        return false;
    }
}
