package com.amaap.electionresult.service.valueobject;

import org.junit.jupiter.api.Test;

import static com.amaap.electionresult.service.valueobject.PartyCodeConverter.getPartyFullName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PartyCodeConverterTest {
    @Test
    void shouldAbleToReturnFullNameOfPartyForGivenCode() {
        //arrange
        String partyCode = "BJP";
        String expectedFullName = "Bhartiya Janta Party";

        //act
        String actualFullName = getPartyFullName(partyCode);

        //assert
        assertEquals(expectedFullName, actualFullName);
        assertEquals("Indian National Congress", getPartyFullName("INC"));
        assertEquals("Communist Party of India", getPartyFullName("CPI"));
        assertEquals("Nationalist Congress Party", getPartyFullName("NCP"));
    }

    @Test
    void shouldBeAbleToCreateInstanceOfPartyCodeConverter() {
        // arrange && act
        PartyCodeConverter partyCodeConverter = new PartyCodeConverter();

        // assert
        assertNotNull(partyCodeConverter);
    }
}