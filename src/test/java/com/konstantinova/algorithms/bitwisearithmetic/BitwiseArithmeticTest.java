package com.konstantinova.algorithms.bitwisearithmetic;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class BitwiseArithmeticTest {
    private static final String PATH_KING = "src/main/resources/bitwisearithmetic/king/test.";
    private static final String PATH_KNIGHT = "src/main/resources/bitwisearithmetic/knight/test.";
    private static final String PATH_ROOK = "src/main/resources/bitwisearithmetic/rook/test.";
    private static final String PATH_BISHOP = "src/main/resources/bitwisearithmetic/bishop/test.";
    private static final String PATH_QUEEN = "src/main/resources/bitwisearithmetic/queen/test.";

    @Test
    public void RunTests() {
        String inFile;
        String outFile;
        for (int testNumber = 0; testNumber <= 9; testNumber++) {
            inFile = PATH_KING + testNumber + ".in";
            outFile = PATH_KING + testNumber + ".out";
            System.out.println("Test King #" + testNumber + ": " + RunTest(inFile, outFile, new King()));
        }
        for (int testNumber = 0; testNumber <= 9; testNumber++) {
            inFile = PATH_KNIGHT + testNumber + ".in";
            outFile = PATH_KNIGHT + testNumber + ".out";
            System.out.println("Test Knight #" + testNumber + ": " + RunTest(inFile, outFile, new Knight()));
        }
        for (int testNumber = 0; testNumber <= 9; testNumber++) {
            inFile = PATH_ROOK + testNumber + ".in";
            outFile = PATH_ROOK + testNumber + ".out";
            System.out.println("Test Rook #" + testNumber + ": " + RunTest(inFile, outFile, new Rook()));
        }
        for (int testNumber = 0; testNumber <= 9; testNumber++) {
            inFile = PATH_BISHOP + testNumber + ".in";
            outFile = PATH_BISHOP + testNumber + ".out";
            System.out.println("Test Bishop #" + testNumber + ": " + RunTest(inFile, outFile, new Bishop()));
        }
        for (int testNumber = 0; testNumber <= 9; testNumber++) {
            inFile = PATH_QUEEN + testNumber + ".in";
            outFile = PATH_QUEEN + testNumber + ".out";
            System.out.println("Test Queen #" + testNumber + ": " + RunTest(inFile, outFile, new Queen()));
        }
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
            int actualCountOfPossibleMoves = new NumberOfPossibleMoves().popCount3(actualMask);

            return (expectMask == actualMask) & (expectCountOfPossibleMoves == actualCountOfPossibleMoves);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
