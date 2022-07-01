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
        //sort(new BubbleSort(), Arrays.copyOf(notSortedArray, arrayLength), false);
        //sort(new BubbleSort(), Arrays.copyOf(notSortedArray, arrayLength), true);
        sort(new InsertionSort(), Arrays.copyOf(notSortedArray, arrayLength), false);
        sort(new InsertionSort(), Arrays.copyOf(notSortedArray, arrayLength), true);
        sort(new ShellSort(), Arrays.copyOf(notSortedArray, arrayLength), false);
    }

    private void sort(Sort someSort, int[] notSortedArray, boolean optimized) {
        Instant startTime;
        Instant endTime;
        if (optimized) {
            startTime = Instant.now();
            someSort.optimizedSort(notSortedArray);
            endTime = Instant.now();
        } else {
            startTime = Instant.now();
            someSort.sort(notSortedArray);
            endTime = Instant.now();
        }
        System.out.printf("\n%s\nOptimized: %b\nSort time: %d ms%n",
                someSort.getClass().getSimpleName(), optimized, Duration.between(startTime, endTime).toMillis());
    }
}
