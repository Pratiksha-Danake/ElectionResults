package com.amaap.electionresult.domain.service.dto;

import java.util.Objects;

public class WinnerPartyDto {
    private String constituencyName;
    private String partyName;
    private double percentageOfVotes;

    public WinnerPartyDto(String party, double percentageOfVotes) {
        this.partyName = party;
        this.percentageOfVotes = percentageOfVotes;
    }

    public String getConstituencyName() {
        return constituencyName;
    }

    public void setConstituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
    }

    public String getPartyName() {
        return partyName;
    }

    public double getPercentageOfVotes() {
        return percentageOfVotes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerPartyDto that = (WinnerPartyDto) o;
        return Double.compare(that.percentageOfVotes, percentageOfVotes) == 0 && Objects.equals(constituencyName, that.constituencyName) && Objects.equals(partyName, that.partyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constituencyName, partyName, percentageOfVotes);
    }
}
