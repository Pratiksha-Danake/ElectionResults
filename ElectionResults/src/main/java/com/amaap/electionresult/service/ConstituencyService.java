package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.repository.ConstituencyRepository;
import com.google.inject.Inject;

import java.util.List;

public class ConstituencyService {
    private final ConstituencyRepository constituencyRepository;

    @Inject
    public ConstituencyService(ConstituencyRepository constituencyRepository) {
        this.constituencyRepository = constituencyRepository;
    }

    public List<Constituency> getConstituenciesData() {
        return constituencyRepository.getConstituenciesData();
    }

    public Constituency createConstituency(String constituencyName, List<Party> parties) throws InvalidConstituencyNameException {
        Constituency constituency = Constituency.create(constituencyName, parties);
        return constituencyRepository.addConstituency(constituency);
    }
}
