package com.gal.caesar;

import com.gal.caesar.runner.RunnerRegistry;

public class Solution {

    public static void main(String[] args){
        RunnerRegistry.getInstance(args).start();
    }
}
