package com.amaap.electionresult.service;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.service.dto.WinnerPartyDto;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class WinnerDetailsPrintingServiceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private WinnerDetailsPrintingService winnerDetailsPrintingService;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        winnerDetailsPrintingService = injector.getInstance(WinnerDetailsPrintingService.class);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void shouldBeAbleToPrintDetailsOfWinnerParties() {
        // arrange
        WinnerPartyDto expectedWinner1 = new WinnerPartyDto("IND", 28.57);
        expectedWinner1.setConstituencyName("Pune");

        WinnerPartyDto expectedWinner2 = new WinnerPartyDto("BSP", 25.81);
        expectedWinner2.setConstituencyName("Chennai");

        List<WinnerPartyDto> expectedWinnerParties = List.of(expectedWinner1, expectedWinner2);

        // act
        winnerDetailsPrintingService.print(expectedWinnerParties);

        // assert
        String expectedOutput = "Constituency:\tPune\tWinning Party:\tIndependent\tPercentage of Votes Get:\t28.57\n" +
                "Constituency:\tChennai\tWinning Party:\tBahujan Samaj Party\tPercentage of Votes Get:\t25.81";

        System.setOut(originalOut);
    }
}
