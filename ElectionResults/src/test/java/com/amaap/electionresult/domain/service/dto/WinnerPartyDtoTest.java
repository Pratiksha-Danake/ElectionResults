package com.amaap.electionresult.domain.service.dto;

import com.amaap.electionresult.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;

class WinnerPartyDtoTest {
    private WinnerPartyDto winnerPartyDto;

    @BeforeEach
    void initialize() {
        Injector injector = Guice.createInjector(new AppModule());
        winnerPartyDto = injector.getInstance(WinnerPartyDto.class);
    }
}