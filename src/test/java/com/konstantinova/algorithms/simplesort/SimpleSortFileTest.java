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
        String path = reversPath;
        for (int testNumber = 0; testNumber <= 7; testNumber++) {
            inFile = path + testNumber + ".in";
            outFile = path + testNumber + ".out";
            System.out.println("================================");
            System.out.println("\nTest #" + testNumber + ": " + RunTest(inFile, outFile, new HeapSort()));
        }
    }

    private boolean RunTest(String inFile, String outFile, Sort sort) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);

            int arrayLength = Integer.parseInt(bufferedReader.readLine());
            System.out.printf("Array length: %d", arrayLength);
            int[] notSortedArrayForSort = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] notSortedArrayForOptimizedSort = Arrays.copyOf(notSortedArrayForSort, arrayLength);

            fileReader = new FileReader(outFile);
            bufferedReader = new BufferedReader(fileReader);

            int[] expectedArray = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Instant startTime = Instant.now();
            sort.sort(notSortedArrayForSort);
            Instant endTime = Instant.now();
            System.out.printf("\nTime %s: %d ms",
                    sort.getClass().getSimpleName(), Duration.between(startTime, endTime).toMillis());

            boolean optimizedSort = true;
            if (!(sort instanceof ShellSort) && !(sort instanceof HeapSort) && !(sort instanceof SelectionSort)) {
                startTime = Instant.now();
                sort.optimizedSort(notSortedArrayForOptimizedSort);
                endTime = Instant.now();
                System.out.printf("\nTime optimized %s: %d ms",
                        sort.getClass().getSimpleName(), Duration.between(startTime, endTime).toMillis());

                optimizedSort = Arrays.equals(expectedArray, notSortedArrayForOptimizedSort);
            }
            return Arrays.equals(expectedArray, notSortedArrayForSort) && optimizedSort;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
