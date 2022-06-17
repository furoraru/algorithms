package com.konstantinova.algorithms.simplesort;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
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
        String path = sortedPath;
        for (int testNumber = 0; testNumber <= 7; testNumber++) {
            inFile = path + testNumber + ".in";
            outFile = path + testNumber + ".out";
            System.out.println("================================");
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

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);

            int[] expectedArray = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Instant startTime = Instant.now();
            int[] sortedArraySort = sort.sort(Arrays.copyOf(notSortedArray, arrayLength));
            System.out.println("Time sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

            boolean optimizedSort = true;
            if (!(sort instanceof ShellSort)) {
                startTime = Instant.now();
                int[] sortedArrayOptimizedSort = sort.optimizedSort(Arrays.copyOf(notSortedArray, arrayLength));
                System.out.println("Time optimized sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

                optimizedSort = Arrays.equals(expectedArray, sortedArrayOptimizedSort);
            }
            return Arrays.equals(expectedArray, sortedArraySort) && optimizedSort;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
