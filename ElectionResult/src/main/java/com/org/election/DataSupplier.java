package com.org.election;

import java.io.File;

public class DataSupplier {
    private File resultFile = new File("E:\\ElectionResults\\ElectionResult\\ElectionResult.txt");

    public File getResultFile() {
        return resultFile;
    }
}
