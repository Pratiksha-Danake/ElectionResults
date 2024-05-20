package com.amaap.electionresult.repository.db.impl;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    private List<Constituency> constituencies = new ArrayList<>();

    @Override
    public Constituency addConstituency(Constituency constituency) {
        constituencies.add(constituency);
        return constituency;
    }

    @Override
    public List<Constituency> getConstituencies() {
        return constituencies;
    }
}
