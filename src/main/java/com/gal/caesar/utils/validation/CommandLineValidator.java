package com.gal.caesar.utils.validation;

import com.gal.caesar.domain.Command;
import com.gal.caesar.domain.InputDTO;

public final class CommandLineValidator {
    public static final String ENTER_KEY_MSG = "Enter key in range from -2147483000 to 2147483000";
    public static final int MAX_KEY = 2147483000;

    private CommandLineValidator() {
    }

    public static boolean validate(InputDTO inputDTO) {
        if (inputDTO == null) {
            return Boolean.FALSE;
        }
        if (inputDTO.getCommand() == null) {
            System.out.println(String.format("Please enter valid command: [%s, %s, %s]",
                    Command.ENCRYPT, Command.DECRYPT, Command.BRUTE_FORCE));
            return Boolean.FALSE;
        }

        if (inputDTO.getCommand() != Command.BRUTE_FORCE && (inputDTO.getKey() == null)) {
            System.out.println(ENTER_KEY_MSG);
            return Boolean.FALSE;
        }

        if (inputDTO.getCommand() == Command.BRUTE_FORCE) {
            return Boolean.TRUE;
        }


        int key = Math.abs(inputDTO.getKey());
        if (key > MAX_KEY) {
            System.out.println(ENTER_KEY_MSG);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

