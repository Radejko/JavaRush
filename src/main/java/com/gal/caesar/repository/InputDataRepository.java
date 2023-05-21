package com.gal.caesar.repository;

import java.io.IOException;

public interface InputDataRepository {
    void init() throws IOException;

    String readRecord() throws IOException;

    void writeRecord(String line) throws IOException;

    void close();

    void reset();
}
