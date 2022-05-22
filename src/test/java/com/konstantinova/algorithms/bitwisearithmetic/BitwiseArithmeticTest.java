package com.konstantinova.algorithms.bitwisearithmetic;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class BitwiseArithmeticTest {
    private static final String pathKing = "src/main/resources/bitwisearithmetic/king/test.";

    @Test
    public void RunTests() {
        String inFile;
        String outFile;
        for (int testNumber = 0; testNumber <= 9; testNumber++) {
            inFile = pathKing + testNumber + ".in";
            outFile = pathKing + testNumber + ".out";
            System.out.println("Test #" + testNumber + ": " + RunTest(inFile, outFile));
        }
    }

    private boolean RunTest(String inFile, String outFile) {
        King king = new King();
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            int data = Integer.parseInt(bufferedReader.readLine());

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            BigInteger expect = new BigInteger(bufferedReader.readLine());

            BigInteger actual = king.bitmaskOfPossibleMoves(data);
            return expect.equals(actual);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
