package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.domain.model.entity.validator.ConstituencyDataValidator;

import java.util.List;
import java.util.Objects;

public class Constituency {
    private String name;
    private List<Party> parties;

    private Constituency(String name, List<Party> parties) {
        this.name = name;
        this.parties = parties;
    }

    public static Constituency create(String name, List<Party> parties) throws InvalidConstituencyNameException {
        if (ConstituencyDataValidator.isInvalidConstituencyName(name))
            throw new InvalidConstituencyNameException("Constituency Name Can't Be:" + name);
        return new Constituency(name, parties);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constituency that = (Constituency) o;
        return Objects.equals(name, that.name) && Objects.equals(parties, that.parties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parties);
    }
}
