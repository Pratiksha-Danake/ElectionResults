package com.org.election;

public class WinnerDisplay {
    private String winnerConstituency;
    private String winnerPartyCode;
    private int winnerPartyVotes;

    public String getWinnerConstituency() {
        return winnerConstituency;
    }

    public String getWinnerPartyCode() {
        return winnerPartyCode;
    }

    public int getWinnerPartyVotes() {
        return winnerPartyVotes;
    }

    public WinnerDisplay(String winnerConstituency, String winnerPartyCode, int winnerPartyVotes) {
        this.winnerConstituency = winnerConstituency;
        this.winnerPartyCode = winnerPartyCode;
        this.winnerPartyVotes = winnerPartyVotes;
    }

    public void showWinnerDetails() {
        System.out.println("Winner Constituency : " + winnerConstituency
                +"\n"+
                "Winner Party Full Name : " + PartyCodeConverter.getPartyFullName(winnerPartyCode)
                +"\n"+"Winner Party Votes : "+winnerPartyVotes);
    }
}
