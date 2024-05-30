package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.amaap.electionresult.service.PartyService;
import com.google.inject.Inject;

import java.io.FileNotFoundException;

public class PartyController {
    private PartyService partyService;

    @Inject
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    public Response createParty(String partyName, int voteCount) throws FileNotFoundException {
        Response response = null;
        try {
            partyService.createParty(partyName, voteCount);
            response = new Response(HttpStatus.OK, "CREATED");
        } catch (InvalidPartyDataException e) {
            response = new Response(HttpStatus.BAD_REQUEST, "Invalid Data Provided");
        }
        return response;
    }
}
