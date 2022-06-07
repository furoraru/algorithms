package com.konstantinova.algorithms.simplesort;

public class InsertionSort {
    public int[] insertionSort(int[] array) {
        int temp;
        int N = array.length;
        for (int k = 1; k < N; k++) {
            for (int p = k; p > 0; p--) {
                // если предыдущий больше текущего
                if (array[p - 1] > array[p]) {
                    // swap
                    temp = array[p - 1];
                    array[p - 1] = array[p];
                    array[p] = temp;
                }
            }
        }
        return array;
    }
}
