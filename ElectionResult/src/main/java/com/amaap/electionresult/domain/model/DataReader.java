package com.amaap.electionresult.domain.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataReader {
    List<ConstituencyResult> constituencyResultList = new ArrayList<>();

    public List<ConstituencyResult> readData(File fileToRead) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileToRead))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] constituency = line.split(", ");
                String constituencyName = constituency[0];
                Map<String, Integer> partyVotes = new HashMap<>();
                for (int i = 1; i < constituency.length; i += 2) {
                    String partyCode = constituency[i+1];
                    int votes = Integer.parseInt(constituency[i]);
                    partyVotes.put(partyCode, votes);
                }
                ConstituencyResult result = new ConstituencyResult(constituencyName);
                result.setPartyVotes(partyVotes);
                constituencyResultList.add(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return constituencyResultList;
    }
}
