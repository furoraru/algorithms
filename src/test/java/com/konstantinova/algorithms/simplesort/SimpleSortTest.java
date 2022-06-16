package com.konstantinova.algorithms.simplesort;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class SimpleSortTest {
    @Test
    public void RunTests() {
        Random random = new Random();
        int[] notSortedArray = random.ints(1_000_000, 1, 10_000).toArray();
        int arrayLength = notSortedArray.length;
        bubbleSort(Arrays.copyOf(notSortedArray, arrayLength));
        optimizedBubbleSort(Arrays.copyOf(notSortedArray, arrayLength));
        insertionSort(Arrays.copyOf(notSortedArray, arrayLength));
        insertionShiftSort(Arrays.copyOf(notSortedArray, arrayLength));
        shellSort(Arrays.copyOf(notSortedArray, arrayLength));
    }

    private void bubbleSort(int[] notSortedArray) {
        Instant startTime = Instant.now();
        int[] sortedArray = new BubbleSort().bubbleSort(notSortedArray);
        System.out.println("\nTime bubble sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");
    }

    private void optimizedBubbleSort(int[] notSortedArray) {
        Instant startTime = Instant.now();
        int[] sortedArray = new BubbleSort().optimizedBubbleSort(notSortedArray);
        System.out.println("\nTime bubble OPTIMIZED sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");
    }

    private void insertionSort(int[] notSortedArray) {
        Instant startTime = Instant.now();
        int[] sortedArray = new InsertionSort().insertionSort(notSortedArray);
        System.out.println("\nTime insertion sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");
    }

    private void insertionShiftSort(int[] notSortedArray) {
        Instant startTime = Instant.now();
        int[] sortedArray = new InsertionSort().insertionShiftSort(notSortedArray);
        System.out.println("\nTime insertion SHIFT sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");
    }

    private void shellSort(int[] notSortedArray) {
        Instant startTime = Instant.now();
        int[] sortedArray = new ShellSort().shellSort(notSortedArray);
        System.out.println("\nTime shell sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");
    }
}
