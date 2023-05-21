package com.gal.caesar.service.impl;

import com.gal.caesar.constant.Vocabulary;
import com.gal.caesar.repository.InputDataRepository;
import com.gal.caesar.service.Decryptor;

import java.io.IOException;

public class Decoder implements Decryptor {
    private InputDataRepository dataRepository;

    public Decoder(InputDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void decrypt(Integer key) {
        String currentRecord = "";
        try {
            while (true) {
                String nextRecord = dataRepository.readRecord();
                StringBuilder result = new StringBuilder();
                decryptLine(currentRecord, result, key);
                if (nextRecord != null && currentRecord != "") {
                    result.append("\n");
                }
                dataRepository.writeRecord(result.toString());
                currentRecord = nextRecord;
                if (nextRecord == null) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(String.format("Failed to read record from data repository. Exception: %s", e.getMessage()));
            e.printStackTrace();
        }
        dataRepository.close();
        System.out.println("Decrypted");
    }

    @Override
    public int getNewIndex(int key, Integer index) {
        var delta = (index - key) % Vocabulary.ALPHABET.length();
        return delta < 0 ? Vocabulary.ALPHABET.length() + delta : delta;
    }

    public InputDataRepository getDataRepository() {
        return dataRepository;
    }

    protected void decryptLine(String currentRecord, StringBuilder result, int key) {
        for (char letter : currentRecord.toCharArray()) {
            if (!Vocabulary.valueMap.containsKey(letter)) {
                result.append(letter);
                continue;
            }
            Integer index = Vocabulary.valueMap.get(letter);
            int newIndex = getNewIndex(key, index);
            result.append(Vocabulary.indexMap.get(newIndex));
        }
    }
}
