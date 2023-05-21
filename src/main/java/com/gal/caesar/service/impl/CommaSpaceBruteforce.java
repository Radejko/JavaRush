package com.gal.caesar.service.impl;

import com.gal.caesar.constant.Vocabulary;
import com.gal.caesar.repository.InputDataRepository;
import com.gal.caesar.service.BruteForce;

import java.io.IOException;

public class CommaSpaceBruteforce extends Decoder implements BruteForce {

    public CommaSpaceBruteforce(InputDataRepository inputDataRepository) {
        super(inputDataRepository);
    }


    @Override
    public boolean decrypt() {
        String currentRecord = "";
        try {
            while (true) {
                if (currentRecord == null) {
                    getDataRepository().close();
                    return Boolean.FALSE;
                }

                StringBuilder result = new StringBuilder();
                for (int key = 1; key < Vocabulary.ALPHABET.length(); key++) {
                    decryptLine(currentRecord, result, key);
                    if (result.toString().contains(", ")) {
                        getDataRepository().reset();
                        decrypt(key);
                        System.out.println("Key is: " + key);
                        return Boolean.TRUE;
                    }
                }
                currentRecord = getDataRepository().readRecord();

            }
        } catch (IOException e) {
            System.out.println(String.format("Failed to read record from data repository. Exception: %s", e.getMessage()));
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

}
