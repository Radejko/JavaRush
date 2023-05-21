package com.gal.caesar.runner.impl;

import com.gal.caesar.domain.Command;
import com.gal.caesar.domain.InputDTO;

import java.io.IOException;
import java.util.Scanner;

public class CLIRunner extends BaseRunner {

    @Override
    protected void init() throws IOException {
        InputDTO inputDTO = new InputDTO();
        Scanner scanner = new Scanner(System.in);
        Command command = getCommand(scanner);
        while (command == null) {
            command = getCommand(scanner);
        }
        inputDTO.setCommand(command);

        String filePath = getFilePath(scanner);
        while (filePath == null || filePath.trim().length() == 0) {
            filePath = getFilePath(scanner);
        }
        inputDTO.setFilePath(filePath);


        int key = 0;
        while (true) {
            try {
                System.out.print("Enter key: ");
                key = scanner.nextInt();
                break;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        inputDTO.setKey(key);
        super.setInputDTO(inputDTO);
        super.init();

    }

    private String getFilePath(Scanner scanner) {
        System.out.print("Enter filepath: ");
        return scanner.nextLine();
    }

    private Command getCommand(Scanner scanner) {
        System.out.print("Enter command: ");
        return Command.valueOfLabel(scanner.nextLine());
    }

}
