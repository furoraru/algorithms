package com.konstantinova.algorithms;

import com.konstantinova.algorithms.algebraicalgorithms.Fibo;

public class Main {
    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        System.out.println(fibo.iteratingFibo(10000000));
    }
}
