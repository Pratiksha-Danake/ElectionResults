package com.amaap.electionresult.util;

import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.Constituency;

import java.util.ArrayList;
import java.util.List;

public class ConstituencyBuilder {

    public static List<Constituency> getConstituencies() {
        List<Constituency> constituencies = new ArrayList<Constituency>();

        List<Party> constituencyOneParties = new ArrayList<Party>();
        constituencyOneParties.add(Party.create("INC", 100));
        constituencyOneParties.add(Party.create("CPI", 200));
        constituencyOneParties.add(Party.create("BJP", 300));
        constituencyOneParties.add(Party.create("NCP", 400));
        constituencyOneParties.add(Party.create("BSP", 500));
        constituencyOneParties.add(Party.create("IND", 600));

        Constituency constituency1 = Constituency.create("Pune", constituencyOneParties);
        constituencies.add(constituency1);


        List<Party> constituencyTwoParties = new ArrayList<Party>();
        constituencyTwoParties.add(Party.create("INC", 350));
        constituencyTwoParties.add(Party.create("CPI", 400));
        constituencyTwoParties.add(Party.create("BJP", 450));
        constituencyTwoParties.add(Party.create("NCP", 500));
        constituencyTwoParties.add(Party.create("BSP", 800));
        constituencyTwoParties.add(Party.create("IND", 600));

        Constituency constituency2 = Constituency.create("Chennai", constituencyTwoParties);
        constituencies.add(constituency2);

        return constituencies;
    }
}
