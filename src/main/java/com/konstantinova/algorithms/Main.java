package com.konstantinova.algorithms;

import com.konstantinova.algorithms.algebraicalgorithms.fibonacci.Fibo;

public class Main {
    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        System.out.println(fibo.iteratingFibo(100));
        System.out.println(fibo.matrixMultiplicationFibo(100));
    }
}
