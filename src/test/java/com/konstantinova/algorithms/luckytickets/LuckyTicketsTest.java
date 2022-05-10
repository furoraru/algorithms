package com.konstantinova.algorithms.luckytickets;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LuckyTicketsTest {
    private static final String path = "src/main/resources/luckytickets/test.";

    @Test
    public void RunTests() {
        String inFile;
        String outFile;
        for (int testNumber = 0; testNumber <= 9; testNumber++) {
            inFile = path + testNumber + ".in";
            outFile = path + testNumber + ".out";
            System.out.println("Test #" + testNumber + ": " + RunTest(inFile, outFile));
        }
    }

    private boolean RunTest(String inFile, String outFile) {
        LuckyTickets luckyTickets = new LuckyTickets();
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            int data = Integer.parseInt(bufferedReader.readLine());

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);
            long expect = Long.parseLong(bufferedReader.readLine());

            long actual = luckyTickets.seniorTicket(data);
            return expect == actual;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

}
