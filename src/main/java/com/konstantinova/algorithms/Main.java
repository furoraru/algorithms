package com.konstantinova.algorithms;

import com.konstantinova.algorithms.simplesort.ShellSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] notSortedArray = random.ints(10, 10, 100).toArray();
        System.out.println(Arrays.toString(notSortedArray));

        ShellSort shellSort = new ShellSort();
        int[] sortedArray = shellSort.shellSort(notSortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}