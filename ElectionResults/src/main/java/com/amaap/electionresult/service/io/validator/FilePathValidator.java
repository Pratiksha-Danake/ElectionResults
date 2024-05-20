package com.amaap.electionresult.service.io.validator;

public class FilePathValidator {

    public static boolean isInvalidPath(String filePath) {
        if (filePath == null || filePath.equals(""))
            return true;
        return false;
    }
}
