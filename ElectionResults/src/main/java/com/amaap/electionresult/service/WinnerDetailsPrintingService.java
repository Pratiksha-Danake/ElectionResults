package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.service.dto.WinnerPartyDto;

import java.util.List;

public class WinnerDetailsPrintingService {
    public void print(List<WinnerPartyDto> winnerParties) {
        for (WinnerPartyDto winnerPartyDto : winnerParties) {
            System.out.println("Constituency:\t" + winnerPartyDto.getConstituencyName() +
                    "\tWinning Party:\t" + winnerPartyDto.getPartyName() +
                    "\tPercentage of Votes Get:\t" + winnerPartyDto.getPercentageOfVotes());
        }
    }
}
