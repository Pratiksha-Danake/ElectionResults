package com.org.election.domain;

import com.org.election.PartyCodeConverter;
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
    private Map<String, Map<String, Integer>> results = new HashMap<>();

    public Map<String, Map<String, Integer>> getResults() {
        return results;
    }

    DataSupplier dataSupplier;

    public DataReader(DataSupplier dataSupplier) {
        this.dataSupplier = dataSupplier;
    }

    public List<String> readData(File fileToRead) {
        List<String> allConstituencyData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileToRead))) {
            String line;
            while ((line = br.readLine()) != null) {
                allConstituencyData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allConstituencyData;
    }

    public void processConstituenciesData(List<String> allConstituencyData) throws InvalidPartyException {
        for (String constituencyWiseData : allConstituencyData) {
            String[] parts = constituencyWiseData.split(", ");
            this.formatData(parts);
        }
    }

    public void formatData(String[] parts) throws InvalidPartyException {
        String constituencyName = parts[0];
        System.out.println("cname = "+constituencyName);
        Map<String,Integer> partyVotes = new HashMap<>();
        for (int i=1; i<parts.length; i+=1){
            String partyCode = parts[i+1];
            Integer votes = Integer.parseInt(parts[i]);
            if (PartyCodeConverter.getPartyFullName(partyCode).isEmpty())
                throw new InvalidPartyException("Party is not valid or recognized.");
            partyVotes.put(parts[i+1],Integer.parseInt(parts[i]));
            results.put(constituencyName,partyVotes);
        }
    }
}
