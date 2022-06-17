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
        for (int testNumber = 0; testNumber <= 1; testNumber++) {
            inFile = randomPath + testNumber + ".in";
            outFile = randomPath + testNumber + ".out";
             System.out.println("Test #" + testNumber + ": " + RunTest(inFile, outFile, new BubbleSort()));
            // System.out.println("Test #" + testNumber + ": " + RunTest(inFile, outFile, new InsertionSort()));
            //System.out.println("Test #" + testNumber + ": " + RunTest(inFile, outFile, new ShellSort()));
        }
    }

    private boolean RunTest(String inFile, String outFile, Sort sort) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);

            int arrayLength = Integer.parseInt(bufferedReader.readLine());
            int[] notSortedArray = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(notSortedArray));

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);

            int[] expectedArray = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] sortedArraySort = sort.sort(Arrays.copyOf(notSortedArray, arrayLength));
            System.out.println(Arrays.toString(sortedArraySort));
            boolean optimizedSort = true;
            if (!(sort instanceof ShellSort)) {
                int[] sortedArrayOptimizedSort = sort.optimizedSort(Arrays.copyOf(notSortedArray, arrayLength));
                optimizedSort = Arrays.equals(expectedArray, sortedArrayOptimizedSort);
                System.out.println(Arrays.toString(sortedArrayOptimizedSort));
            }
            return Arrays.equals(expectedArray, sortedArraySort) && optimizedSort;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
