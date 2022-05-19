package com.konstantinova.algorithms.algebraicalgorithms;

import com.konstantinova.algorithms.algebraicalgorithms.fibonacci.Fibo;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

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
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            int data = Integer.parseInt(bufferedReader.readLine());

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);
            BigInteger expect = new BigInteger(bufferedReader.readLine());

            long actual = luckyTickets.seniorTicket(data);
            return expect == actual;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    private boolean RunTestPower(String inFile, String outFile) {

    }

    private boolean RunTestPrimes(String inFile, String outFile) {

    }

}
