package com.konstantinova.algorithms;

import com.konstantinova.algorithms.algebraicalgorithms.Power;

public class Main {
    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.iteratingPower(1.0000000001, 10000000000L));
        System.out.println(power.multiplicationPower(1.0000000001, 10000000000L));
    }
}
