package com.gal.caesar.service.impl;

import com.gal.caesar.constant.Vocabulary;
import com.gal.caesar.repository.InputDataRepository;
import com.gal.caesar.service.Encryptor;

import java.io.IOException;

public class Encoder implements Encryptor {
    private InputDataRepository dataRepository;

    public Encoder(InputDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    public void encrypt(Integer key) {
        String currentRecord = "";
        try {
            while (true) {

                String nextRecord = dataRepository.readRecord();

                StringBuilder result = new StringBuilder();
                for (char letter : currentRecord.toCharArray()) {
                    if (!Vocabulary.valueMap.containsKey(letter)) {
                        result.append(letter);
                        continue;
                    }
                    Integer index = Vocabulary.valueMap.get(letter);
                    int newIndex = getNewIndex(key, index);
                    result.append(Vocabulary.indexMap.get(newIndex));

                }
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
        System.out.println("Encrypted");
    }

    @Override
    public int getNewIndex(int key, Integer currentIndex) {
        return Math.abs((currentIndex + key) % Vocabulary.ALPHABET.length());
    }
}
