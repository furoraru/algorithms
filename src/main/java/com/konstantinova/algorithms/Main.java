package com.konstantinova.algorithms;

import com.konstantinova.algorithms.algebraicalgorithms.Primes;

public class Main {
    public static void main(String[] args) {
        Primes primes = new Primes();
        System.out.println(primes.enumerationOfDivisors(2));
        System.out.println(primes.divisionByPrimes(2));
    }
}
