package com.konstantinova.algorithms.simplesort;

public class ShellSort extends Sort {
    public void sort(int[] array) {
        int j;
        int temp;
        int N = array.length;
        for (int gap = N / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < N; i++) {
                temp = array[i];
                j = i;
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
    }

    @Override
    public void optimizedSort(int[] array) {
    }
}
