package com.gal.caesar.service;

public interface Encryptor {
    void encrypt(Integer key);
    int getNewIndex(int key, Integer index);
}
