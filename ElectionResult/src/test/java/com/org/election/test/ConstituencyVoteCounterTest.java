package com.org.election.test;

import com.org.election.ConstituencyVoteCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ConstituencyVoteCounterTest {
    ConstituencyVoteCounter constituencyVoteCounter = new ConstituencyVoteCounter();
    @Test
    void shouldAbleToFindTheWinnerPartyOfTheConstituency(){
        //Arrange
        Map<String, Map<String, Integer>> constituencyVotes = new HashMap<>();
        Map<String, Integer> constituency1Data = new HashMap<>();
        constituency1Data.put("BJP", 1000);
        constituency1Data.put("INC", 150);
        constituency1Data.put("BSP", 8000);
        constituencyVotes.put("Pune", constituency1Data);
        String expectedWinner = "BSP";
        //Act
        String actualWinner = constituencyVoteCounter.findWinner(constituencyVotes);
        //Assert
        Assertions.assertEquals(expectedWinner,actualWinner);
    }
}
