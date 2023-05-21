package com.gal.caesar.service;

public interface Decryptor {
    void decrypt(Integer key);
    int getNewIndex(int key, Integer index);
}
