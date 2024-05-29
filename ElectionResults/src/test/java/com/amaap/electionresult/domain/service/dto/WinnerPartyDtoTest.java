package com.amaap.electionresult.domain.service.dto;

import com.amaap.electionresult.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnerPartyDtoTest {
    private WinnerPartyDto winnerPartyDto;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        winnerPartyDto = injector.getInstance(WinnerPartyDto.class);
    }

    @Test
    void shouldBeAbleToReturnHashCode() {
        // arrange
        String constituencyName = "Chennai";
        String partyName = "ABC";
        double percentageOfVotes = 50.50;

        // act
        WinnerPartyDto winnerPartyDto1 = new WinnerPartyDto(partyName, percentageOfVotes);
        winnerPartyDto1.setConstituencyName(constituencyName);

        // assert
        assertNotNull(winnerPartyDto1.hashCode());
    }

    @Test
    void shouldBeAbleToCheckEqualityOfTwoInstancesWithDifferentAttributeValues() {
        // arrange
        String constituencyName = "Chennai";
        String partyName = "ABC";
        double percentageOfVotes = 50.50;

        // act
        WinnerPartyDto winnerPartyDto1 = new WinnerPartyDto(partyName, percentageOfVotes);
        winnerPartyDto1.setConstituencyName(constituencyName);

        WinnerPartyDto winnerPartyDto2 = new WinnerPartyDto("XYZ", 40.40);

        WinnerPartyDto winnerPartyDto3 = new WinnerPartyDto(partyName, percentageOfVotes);
        winnerPartyDto3.setConstituencyName("constituencyName");

        // assert
        assertTrue(winnerPartyDto1.equals(winnerPartyDto1));
        assertFalse(winnerPartyDto1.equals(winnerPartyDto3));
        assertFalse(winnerPartyDto1.equals(null));
        assertFalse(winnerPartyDto1.equals(new Object()));
        assertFalse(winnerPartyDto1.equals(winnerPartyDto2));
    }
}