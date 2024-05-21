package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.service.dto.WinnerPartyDto;
import com.amaap.electionresult.service.valueobject.PartyCodeConverter;

import java.util.List;

public class WinnerDetailsPrintingService {
    public void print(List<WinnerPartyDto> winnerParties) {
        for (WinnerPartyDto winnerPartyDto : winnerParties) {

            System.out.println("Constituency:\t" + winnerPartyDto.getConstituencyName() +
                    "\tWinning Party:\t" + PartyCodeConverter.getPartyFullName(winnerPartyDto.getPartyName()) +
                    "\tPercentage of Votes Get:\t" + winnerPartyDto.getPercentageOfVotes());
        }
    }
}
