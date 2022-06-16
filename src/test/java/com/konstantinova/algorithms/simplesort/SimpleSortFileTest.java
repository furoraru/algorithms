package com.konstantinova.algorithms.simplesort;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class SimpleSortFileTest {
    private static final String randomPath = "src/main/resources/sorting/0.random/test.";
    private static final String digitsPath = "src/main/resources/sorting/1.digits/test.";
    private static final String sortedPath = "src/main/resources/sorting/2.sorted/test.";
    private static final String reversPath = "src/main/resources/sorting/3.revers/test.";

    @Test
    public void RunTests() {
        String inFile;
        String outFile;
        for (int testNumber = 0; testNumber <= 0; testNumber++) {
            inFile = randomPath + testNumber + ".in";
            outFile = randomPath + testNumber + ".out";
            System.out.println("Test #" + testNumber + ": " + RunTest(inFile, outFile));
        }
    }

    private boolean RunTest(String inFile, String outFile) {
        BubbleSort bubbleSort = new BubbleSort();
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);

            int arraySize = Integer.parseInt(bufferedReader.readLine());
            System.out.println(arraySize);

            int[] notSortedArray = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(notSortedArray));

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);

            int[] expectedArray = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] sortedArray = bubbleSort.bubbleSort(notSortedArray);
            return expectedArray == sortedArray;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
