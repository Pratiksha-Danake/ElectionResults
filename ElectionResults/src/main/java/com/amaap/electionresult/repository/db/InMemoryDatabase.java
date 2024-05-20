package com.amaap.electionresult.repository.db;

import com.amaap.electionresult.domain.model.entity.Constituency;

import java.util.List;

public interface InMemoryDatabase {
    Constituency addConstituency(Constituency constituency);

    List<Constituency> getConstituencies();
}
