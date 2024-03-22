package com.org.election.domain;

import com.org.election.io.file.DataSupplier;
import com.org.election.model.ConstituencyResult;
import com.org.election.model.WinnerDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataAnalyzer {
    static final int totalVotes = 2100;

    public List<WinnerDisplay> findWinner(List<ConstituencyResult> constituencyResult) {
        List<WinnerDisplay> winnersList = new ArrayList<>();
        for (ConstituencyResult result : constituencyResult) {
            String constituency = result.getConstituency();
            Map<String, Integer> partyVotes = result.getPartyVotes();
            winnersList.add(findWinnerParty(constituency,partyVotes));
        }
        return winnersList;
    }

    private static WinnerDisplay findWinnerParty(String constituency, Map<String, Integer> partyVotes) {
        String winnerParty = null;
        double percentageOfVotes;
        int maxVotes = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : partyVotes.entrySet()) {
            String partyCode = entry.getKey();
            int votes = entry.getValue();
            if (votes > maxVotes) {
                maxVotes = votes;
                winnerParty = partyCode;
            }
        }
        percentageOfVotes = (double) maxVotes / totalVotes * 100;
        return new WinnerDisplay(constituency,winnerParty,maxVotes,percentageOfVotes);
    }
}
