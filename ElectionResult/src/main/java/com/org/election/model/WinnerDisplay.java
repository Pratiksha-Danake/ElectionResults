package com.org.election;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerDisplay that = (WinnerDisplay) o;
        return winnerPartyVotes == that.winnerPartyVotes && Objects.equals(winnerConstituency, that.winnerConstituency) && Objects.equals(winnerPartyCode, that.winnerPartyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerConstituency, winnerPartyCode, winnerPartyVotes);
    }
}
