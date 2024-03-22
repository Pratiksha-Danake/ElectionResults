package com.org.election.io.file;

import java.io.File;

public class DataSupplier {
    private File resultFile;

    public File getFile(String pathToFileContainsElectionData) {
       resultFile  = new File(pathToFileContainsElectionData);
       return resultFile;
    }
}
