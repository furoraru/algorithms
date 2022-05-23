package com.konstantinova.algorithms.bitwisearithmetic;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class BitwiseArithmeticTest {
    private static final String pathKing = "src/main/resources/bitwisearithmetic/king/test.";
    private static final String pathKnight = "src/main/resources/bitwisearithmetic/knight/test.";

    @Test
    public void RunTests() {
        String inFile;
        String outFile;
        for (int testNumber = 0; testNumber <= 9; testNumber++) {
            inFile = pathKing + testNumber + ".in";
            outFile = pathKing + testNumber + ".out";
            System.out.println("Test King #" + testNumber + ": " + RunTest(inFile, outFile, new King()));
        }
//        for (int testNumber = 0; testNumber <= 9; testNumber++) {
//            inFile = pathKnight + testNumber + ".in";
//            outFile = pathKnight + testNumber + ".out";
//            System.out.println("Test Knight #" + testNumber + ": " + RunTest(inFile, outFile, new Knight()));
//        }
    }

    private boolean RunTest(String inFile, String outFile, ChessFigure chessFigure) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            int data = Integer.parseInt(bufferedReader.readLine());

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);

            int expectCountOfPossibleMoves = Integer.parseInt(bufferedReader.readLine());
            long expectMask = new BigInteger(bufferedReader.readLine()).longValue();
            long actualMask = chessFigure.bitmaskOfPossibleMoves(data);
            int actualCountOfPossibleMoves = new NumberOfPossibleMoves().popCount(actualMask);
            return (expectMask == actualMask) & (expectCountOfPossibleMoves == actualCountOfPossibleMoves);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
