package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.service.ConstituencyService;
import com.google.inject.Inject;

import java.io.FileNotFoundException;
import java.util.List;

public class ConstituencyController {
    private ConstituencyService constituencyService;

    @Inject
    public ConstituencyController(ConstituencyService constituencyService) {
        this.constituencyService = constituencyService;
    }

    public Response createConstituency(String name, List<Party> parties) throws FileNotFoundException {
        Response response = null;
        try {
            constituencyService.createConstituency(name, parties);
            response = new Response(HttpStatus.OK, "CREATED");
        } catch (InvalidConstituencyNameException e) {
            response = new Response(HttpStatus.BAD_REQUEST, "Invalid Data Provided");
        }
        return response;
    }
}
