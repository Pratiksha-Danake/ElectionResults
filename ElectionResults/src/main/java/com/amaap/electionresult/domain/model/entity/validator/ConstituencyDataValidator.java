package com.amaap.electionresult.domain.model.entity.validator;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConstituencyDataValidator {
    private static List<String> constituencies = new ArrayList<>();

    public static boolean isInvalidConstituencyName(String name) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream("E:\\ElectionResults\\ElectionResults\\src\\main\\java\\com\\amaap\\electionresult\\config\\ValidElectionData.yaml");
        Map<String, List<String>> validData = yaml.load(fileInputStream);
        constituencies = validData.get("Constituencies");
        return name == null || name.equals("") || !(name.matches("^[a-zA-Z]{4,}$")) || !constituencies.contains(name);
    }
}
