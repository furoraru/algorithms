package com.konstantinova.algorithms.algebraicalgorithms;

import com.konstantinova.algorithms.algebraicalgorithms.fibonacci.Fibo;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;

public class AlgebraicAlgorithmsTest {
    private static final String pathFibo = "src/main/resources/algebraicalgorithms/fibo/test.";
    private static final String pathPower = "src/main/resources/algebraicalgorithms/power/test.";
    private static final String pathPrimes = "src/main/resources/algebraicalgorithms/primes/test.";

    @Test
    public void RunTests() {
        String inFile;
        String outFile;
        for (int testNumber = 0; testNumber <= 12; testNumber++) {
            inFile = pathFibo + testNumber + ".in";
            outFile = pathFibo + testNumber + ".out";
            System.out.println("Test Fibonacci #" + testNumber + ": " + RunTestFibo(inFile, outFile));
        }
        for (int testNumber = 0; testNumber <= 9; testNumber++) {
            inFile = pathPower + testNumber + ".in";
            outFile = pathPower + testNumber + ".out";
            System.out.println("Test Power #" + testNumber + ": " + RunTestPower(inFile, outFile));
        }
        for (int testNumber = 0; testNumber <= 14; testNumber++) {
            inFile = pathPrimes + testNumber + ".in";
            outFile = pathPrimes + testNumber + ".out";
            System.out.println("Test Primes #" + testNumber + ": " + RunTestPrimes(inFile, outFile));
        }
    }

    private boolean RunTestFibo(String inFile, String outFile) {
        Fibo fibo = new Fibo();

        FileReader fileReader;
        BufferedReader bufferedReader;
        Instant startTime;
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            int data = Integer.parseInt(bufferedReader.readLine());

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);
            BigInteger expect = new BigInteger(bufferedReader.readLine());

            startTime = Instant.now();
            BigInteger actual = fibo.matrixMultiplicationFibo(data);
            System.out.println("\nTime fibo: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

            return expect.equals(actual);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    private boolean RunTestPower(String inFile, String outFile) {
        Power power = new Power();

        FileReader fileReader;
        BufferedReader bufferedReader;
        Instant startTime;
        DecimalFormat df = new DecimalFormat("#.0000000");
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            double a = Double.parseDouble(bufferedReader.readLine());
            long n = Long.parseLong(bufferedReader.readLine());

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);
            double expect = Double.parseDouble(bufferedReader.readLine());

            startTime = Instant.now();
            double actual = power.binaryDecomposition(a, n);
            System.out.println("\nTime power: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

            return df.format(expect).equals(df.format(actual));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    private boolean RunTestPrimes(String inFile, String outFile) {
        Primes primes = new Primes();

        FileReader fileReader;
        BufferedReader bufferedReader;
        Instant startTime;
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            int data = Integer.parseInt(bufferedReader.readLine());

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);
            long expect = Long.parseLong(bufferedReader.readLine());

            startTime = Instant.now();
            long actual = primes.eratosthenes(data);
            System.out.println("\nTime primes: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

            return expect == actual;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

}
