package com.gal.caesar.runner.impl;

import com.gal.caesar.utils.mapper.InputDataMapper;

import java.io.IOException;

public class CommandLineRunner extends BaseRunner {
    private String[] args;

    public CommandLineRunner(String[] args) {
        this.args = args;
    }

    @Override
    protected void init() throws IOException {
        super.setInputDTO(InputDataMapper.mapToInputDTO(args));
        super.init();
    }
}
