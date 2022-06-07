package com.konstantinova.algorithms.simplesort;

/*
Visual: https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
 */
public class BubbleSort {
    public int[] bubbleSort(int[] array) {
        int temp;
        int N = array.length;
        for (int k = 0; k < N - 1; k++) {
            for (int p = 0; p < N - k - 1; p++) {
                if (array[p] > array[p + 1]) {
                    // swap
                    temp = array[p];
                    array[p] = array[p + 1];
                    array[p + 1] = temp;
                }
            }
        }
        return array;
    }

    // Если не было обменов, значит все элементы на своих местах -> массив остортирован
    public int[] optimizedBubbleSort(int[] array) {
        int temp;
        int N = array.length;
        boolean swapped;
        for (int k = 0; k < N - 1; k++) {
            swapped = false;
            for (int p = 0; p < N - k - 1; p++) {
                if (array[p] > array[p + 1]) {
                    // swap
                    temp = array[p];
                    array[p] = array[p + 1];
                    array[p + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return array;
    }
}
