package com.org.election.test;

import com.org.election.PartyCodeConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartyCodeConverterTest {
    @Test
    void shouldAbleToreturnFullNameOfPartyForGivenCode(){
        //Arrange
        String partyCode = "BJP";
        String expectedFullName = "Bhartiya Janta Party";
        //Act
        String actualFullName= PartyCodeConverter.getPartyFullName(partyCode);
        //Assert
        Assertions.assertEquals(expectedFullName, actualFullName);
    }
}
