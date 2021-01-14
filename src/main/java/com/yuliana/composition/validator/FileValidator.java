package com.yuliana.composition.validator;

import java.io.File;

public class FileValidator {
    public static boolean isFileValid(String fileName){
        if(fileName == null){
            return false;
        }
        File file = new File(fileName);
        return file.isFile() && !(file.length() == 0);
    }
}
