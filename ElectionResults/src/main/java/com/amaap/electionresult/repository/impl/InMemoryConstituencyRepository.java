package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.repository.ConstituencyRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

import java.util.List;

public class InMemoryConstituencyRepository implements ConstituencyRepository {
    private InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryConstituencyRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Constituency addConstituency(Constituency constituency) {
        return inMemoryDatabase.addConstituency(constituency);
    }

    @Override
    public List<Constituency> getConstituenciesData() {
        return inMemoryDatabase.getConstituencies();
    }
}
