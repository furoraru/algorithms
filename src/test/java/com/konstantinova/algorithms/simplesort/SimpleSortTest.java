package com.konstantinova.algorithms.simplesort;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class SimpleSortTest {
    @Test
    public void RunTests() {
        bubbleSort();
        insertionSort();
        shellSort();
    }

    private void bubbleSort() {
        Random random = new Random();
        int[] notSortedArray = random.ints(10000, 1, 10000).toArray();
        Instant startTime = Instant.now();
        int[] sortedArray = new BubbleSort().bubbleSort(notSortedArray);
        System.out.println("\nTime bubble sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");
    }

    private void insertionSort() {
        Random random = new Random();
        int[] notSortedArray = random.ints(10000, 1, 10000).toArray();
        Instant startTime = Instant.now();
        int[] sortedArray = new InsertionSort().insertionSort(notSortedArray);
        System.out.println("\nTime insertion sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");
    }

    private void shellSort() {
        Random random = new Random();
        int[] notSortedArray = random.ints(10000, 1, 10000).toArray();
        Instant startTime = Instant.now();
        int[] sortedArray = new ShellSort().shellSort(notSortedArray);
        System.out.println("\nTime shell sort: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");
    }
}
