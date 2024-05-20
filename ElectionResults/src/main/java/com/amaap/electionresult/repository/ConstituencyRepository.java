package com.amaap.electionresult.repository;

import com.amaap.electionresult.domain.model.entity.Constituency;

import java.util.List;

public interface ConstituencyRepository {
    Constituency addConstituency(Constituency constituency);

    List<Constituency> getConstituenciesData();
}
