package com.gal.caesar.utils.mapper;

public final class FilePathMapper {

    private FilePathMapper() {
    }

    public static String replaceLast(String filePath, String replacement) {
        String pathWithoutExtention = filePath;
        String extention = "";
        if(filePath.contains(".")) {
            pathWithoutExtention = filePath.substring(0, filePath.lastIndexOf("."));
            extention = filePath.substring(filePath.lastIndexOf("."));
        }
        if (pathWithoutExtention.contains("[ENCRYPTED]")) {
            pathWithoutExtention = pathWithoutExtention.substring(0, pathWithoutExtention.lastIndexOf("["));
        }
        return pathWithoutExtention + replacement + extention;
    }
}
