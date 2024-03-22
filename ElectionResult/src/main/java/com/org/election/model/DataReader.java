package com.org.election.model;

import com.org.election.exceptions.InvalidPartyException;
import com.org.election.io.file.DataSupplier;

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

//    public void processConstituenciesData(List<String> allConstituencyData) throws InvalidPartyException {
//        for (String constituencyWiseData : allConstituencyData) {
//            String[] parts = constituencyWiseData.split(", ");
//            this.formatData(parts);
//        }
//    }
//
//    public void formatData(String[] parts) throws InvalidPartyException {
//        String constituencyName = parts[0];
//        System.out.println("cname = "+constituencyName);
//        Map<String,Integer> partyVotes = new HashMap<>();
//        for (int i=1; i<parts.length; i+=2){
//            String partyCode = parts[i+1];
//            Integer votes = Integer.parseInt(parts[i]);
//            if (PartyCodeConverter.getPartyFullName(partyCode).isEmpty())
//                throw new InvalidPartyException("Party is not valid or recognized.");
//            partyVotes.put(parts[i+1],Integer.parseInt(parts[i]));
//            results.put(constituencyName,partyVotes);
//        }
//    }
}
