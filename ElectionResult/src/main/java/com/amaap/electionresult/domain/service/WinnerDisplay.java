package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.PartyCodeConverter;

import java.util.List;
import java.util.Objects;

public class WinnerDisplay {
    private String winnerConstituency;
    private String winnerPartyCode;
    private int winnerPartyVotes;
    private double votesPercentage;

    public double getVotesPercentage() {
        return votesPercentage;
    }

    public String getWinnerConstituency() {
        return winnerConstituency;
    }

    public String getWinnerPartyCode() {
        return winnerPartyCode;
    }

    public int getWinnerPartyVotes() {
        return winnerPartyVotes;
    }

    public WinnerDisplay(String winnerConstituency, String winnerPartyCode, int winnerPartyVotes, double percentageOfVotes) {
        this.winnerConstituency = winnerConstituency;
        this.winnerPartyCode = winnerPartyCode;
        this.winnerPartyVotes = winnerPartyVotes;
        this.votesPercentage = percentageOfVotes;
    }

    public void showWinnerPartyDetails(List<WinnerDisplay> winners) {
        System.out.println("Winner Constituency : " + winnerConstituency
                +"\n"+
                "Winner Party Full Name : " + PartyCodeConverter.getPartyFullName(winnerPartyCode)
                +"\n"+"Winner Party Votes : "+getWinnerPartyVotes()
                +"\n"+"Percentage Of Votes casted to winner party : "+getVotesPercentage());
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
