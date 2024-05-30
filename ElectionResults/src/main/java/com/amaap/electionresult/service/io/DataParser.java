package com.amaap.electionresult.service.io;

import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.exception.InvalidPartyDataException;
import com.amaap.electionresult.service.ConstituencyService;
import com.google.inject.Inject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private final ConstituencyService constituencyService;

    @Inject
    public DataParser(ConstituencyService constituencyService) {
        this.constituencyService = constituencyService;
    }

    public boolean parseInputLine(String line) throws InvalidPartyDataException, InvalidConstituencyNameException, FileNotFoundException {
        List<Party> parties = new ArrayList<Party>();
        String[] data = line.split(", ");
        String constituencyName = data[0];
        for (int i = 1; i < data.length; i += 2) {
            parties.add(Party.create(data[i], Integer.parseInt(data[i + 1])));
        }
        constituencyService.createConstituency(constituencyName, parties);
        return true;
    }
}
