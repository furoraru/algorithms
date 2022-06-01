package com.konstantinova.algorithms.simplesort;

public class InsertionSort {
    public int[] insertionSort(int[] array) {
        int p;
        int pivot;
        int N = array.length;
        for (int k = 1; k < N; k++) {
            pivot = array[k];
            p = k - 1;
            while (p >= 0 && pivot < array[p]) {
                array[p + 1] = array[p];
                p--;
            }
            array[p + 1] = pivot;
        }
        return array;
    }
}
