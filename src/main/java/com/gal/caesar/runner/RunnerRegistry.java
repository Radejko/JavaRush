package com.gal.caesar.runner;

import com.gal.caesar.runner.impl.CLIRunner;
import com.gal.caesar.runner.impl.CommandLineRunner;

import java.util.HashMap;
import java.util.Map;

public final class RunnerRegistry {
    private static final String CLI_INTERFACE = "cli";
    private static final String COMMAND_LINE_INTERFACE = "commandLine";
    private static volatile RunnerRegistry instance;
    private static final Map<String, Runner> registry = new HashMap<>();
    private static String[] args;

    private RunnerRegistry() {
    }

    public static RunnerRegistry getInstance(String[] value) {

        RunnerRegistry result = instance;
        if (result != null) {
            return result;
        }
        synchronized (RunnerRegistry.class) {
            if (instance == null) {
                initRegistry(value);
                instance = new RunnerRegistry();
            }
            return instance;
        }
    }


    private static void initRegistry(String[] args) {
        RunnerRegistry.args = args;
        if (args.length > 1) {
            registry.put(COMMAND_LINE_INTERFACE, new CommandLineRunner(args));
        }
        if (args.length == 0) {
            registry.put(CLI_INTERFACE, new CLIRunner());

        }
    }

    public void start() {
        if (args.length > 1) {
            registry.get(COMMAND_LINE_INTERFACE).run();
            return;
        }
        if (args.length == 0) {
            registry.get(CLI_INTERFACE).run();

        }

    }


}
