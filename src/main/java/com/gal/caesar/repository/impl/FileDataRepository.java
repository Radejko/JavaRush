package com.gal.caesar.repository.impl;

import com.gal.caesar.repository.InputDataRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDataRepository implements InputDataRepository {
    private String inputDataPath;
    private String outputDataPath;
    private BufferedReader recordReader;
    private PrintWriter recordWriter;

    public FileDataRepository(String inputDataPath, String outputDataPath) {
        this.inputDataPath = inputDataPath;
        this.outputDataPath = outputDataPath;
    }


    public void init() throws IOException {
        recordReader = new BufferedReader(new FileReader(inputDataPath));
        recordReader.mark(1);
        Files.deleteIfExists(Path.of(outputDataPath));
        recordWriter = new PrintWriter(new FileWriter(outputDataPath));
    }


    public String readRecord() throws IOException {
        return recordReader.readLine();
    }

    public void writeRecord(String line) throws IOException {
        recordWriter.print(line);
    }

    @Override
    public void close() {
        try {
            recordWriter.close();
            recordReader.close();
        } catch (IOException ex) {
            System.out.println(String.format("Exception occurred: %s", ex.getMessage()));
            ex.printStackTrace();
        }

    }

    @Override
    public void reset() {
        try {
            recordReader.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
