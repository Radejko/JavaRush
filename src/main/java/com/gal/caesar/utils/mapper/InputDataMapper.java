package com.gal.caesar.utils.mapper;

import com.gal.caesar.domain.Command;
import com.gal.caesar.domain.InputDTO;
import com.gal.caesar.exception.AppException;
import com.gal.caesar.utils.validation.CommandLineValidator;

public final class InputDataMapper {

    private InputDataMapper() {
    }

    public static InputDTO mapToInputDTO(String[] args) {
        InputDTO inputDTO = new InputDTO();
        Command command = Command.valueOf(args[0]);
        inputDTO.setCommand(command);
        inputDTO.setFilePath(args[1]);
        if (Command.BRUTE_FORCE == command) {
            return inputDTO;
        }
        var key = 0;
        try {
            key = Math.abs(Integer.parseInt(args[2].trim()));
        } catch (NumberFormatException ex) {
            System.out.println(CommandLineValidator.ENTER_KEY_MSG);
            throw new AppException("Provided invalid value of key");
        }
        inputDTO.setKey(key);
        return inputDTO;
    }

}
