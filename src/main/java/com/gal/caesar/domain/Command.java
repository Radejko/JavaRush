package com.gal.caesar.domain;

public enum Command {
    ENCRYPT("[ENCRYPTED]"), DECRYPT("[DECRYPTED]"), BRUTE_FORCE("[BRUTE_FORCED]");
    private final String label;

    private Command(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }

    public static Command valueOfLabel(String label) {
        for (Command command: values()) {
            if (command.name().equals(label)) {
                return command;
            }
        }
        return null;
    }

}
