package com.org.election.test;

import com.org.election.WinnerDisplay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinnerDisplayTest {
    @Test
    void shouldAbleToDisplayDataOfWinnerPartyFromConstituency(){
        //Arrange
        String expectedWinnerConstituency = "Pune";
        String expectedWinnerPartyCode = "BSP";
        int expectedWinnerPartyVotes = 100;
        WinnerDisplay winnerDisplay = new WinnerDisplay(
                expectedWinnerConstituency,expectedWinnerPartyCode,expectedWinnerPartyVotes);
        //Act
        winnerDisplay.showWinnerDetails();
        //Assert
        Assertions.assertEquals(expectedWinnerConstituency,winnerDisplay.getWinnerConstituency());
        Assertions.assertEquals(expectedWinnerPartyCode,winnerDisplay.getWinnerPartyCode());
        Assertions.assertEquals(expectedWinnerPartyVotes,winnerDisplay.getWinnerPartyVotes());
    }
}
