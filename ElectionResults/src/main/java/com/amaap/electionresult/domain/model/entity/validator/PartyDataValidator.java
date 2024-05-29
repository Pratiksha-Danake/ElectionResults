package com.amaap.electionresult.domain.model.entity.validator;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PartyDataValidator {
    private static List<String> parties = new ArrayList<>();

    public static boolean isInvalidPartyName(String name) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream("E:\\ElectionResults\\ElectionResults\\src\\main\\java\\com\\amaap\\electionresult\\config\\ValidElectionData.yaml");
        Map<String, List<String>> validData = yaml.load(fileInputStream);
        parties = validData.get("PartyCodes");
        if (name == null || name.equals("") || !(name.matches("^[a-zA-Z]{3,}$")) || !parties.contains(name))
            return true;
        return false;
    }

    public static boolean isInvalidVoteCount(int vote) {
        return vote <= 0;
    }
}