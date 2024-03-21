package com.org.election;

import java.util.Map;

public class ConstituencyVoteCounter {

    public String findWinner(Map<String, Map<String, Integer>> formattedResult) {
        int maxVotes = 0;
        String winnerPartyCode = "";

        for (Map.Entry<String, Map<String, Integer>> entry : formattedResult.entrySet()) {
            String constituency = entry.getKey();
            Map<String, Integer> partyVotesMap = entry.getValue();
            for (Map.Entry<String, Integer> partyEntry : partyVotesMap.entrySet()) {
                String partyCode = partyEntry.getKey();
                int partyVotes = partyEntry.getValue();
                if (partyVotes > maxVotes) {
                    maxVotes = partyVotes;
                    winnerPartyCode = partyCode;
                }
            }
        }
        return winnerPartyCode;
    }
}
//    String partyCode = partyEntry.getKey();
//    int votes = partyEntry.getValue();
//                System.out.println("Party Code: " + partyCode + ", Votes: " + votes);