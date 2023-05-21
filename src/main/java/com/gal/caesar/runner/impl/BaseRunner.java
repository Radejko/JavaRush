package com.gal.caesar.runner.impl;

import com.gal.caesar.domain.Command;
import com.gal.caesar.domain.InputDTO;
import com.gal.caesar.exception.AppException;
import com.gal.caesar.repository.impl.FileDataRepository;
import com.gal.caesar.runner.Runner;
import com.gal.caesar.service.BruteForce;
import com.gal.caesar.service.Decryptor;
import com.gal.caesar.service.Encryptor;
import com.gal.caesar.service.impl.CommaSpaceBruteforce;
import com.gal.caesar.service.impl.Decoder;
import com.gal.caesar.service.impl.Encoder;
import com.gal.caesar.utils.mapper.FilePathMapper;
import com.gal.caesar.utils.validation.CommandLineValidator;

import java.io.IOException;

public abstract class BaseRunner implements Runner {
    private InputDTO inputDTO;
    private Encryptor encryptor;
    private Decryptor decryptor;
    private BruteForce bruteForce;


    protected void init() throws IOException {
        if (!CommandLineValidator.validate(inputDTO)) {
            throw new AppException("Invalid input data");
        }
        var dataRepository = new FileDataRepository(inputDTO.getFilePath(), getOutputDataPath());
        dataRepository.init();
        encryptor = new Encoder(dataRepository);
        decryptor = new Decoder(dataRepository);
        bruteForce = new CommaSpaceBruteforce(dataRepository);
    }


    public void run() {
        try {
            init();
            Command command = inputDTO.getCommand();
            Integer key = inputDTO.getKey();
            switch (command) {
                case ENCRYPT:
                    encryptor.encrypt(key);
                    break;
                case DECRYPT:
                    decryptor.decrypt(key);
                    break;
                case BRUTE_FORCE:
                    bruteForce.decrypt();
                    break;
                default:
                    throw new IOException("Invalid command");
            }
        } catch (IOException e) {
            System.out.println(String.format("Exception occurred: %s", e.getMessage()));
            e.printStackTrace();
        }

    }

    private String getOutputDataPath() {
        return FilePathMapper.replaceLast(inputDTO.getFilePath(), inputDTO.getCommand().toString());
    }

    public void setInputDTO(InputDTO inputDTO) {
        this.inputDTO = inputDTO;
    }

}

