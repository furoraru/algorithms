package com.konstantinova.algorithms.simplesort;

public class SelectionSort extends Sort {
    @Override
    public void sort(int[] array) {
        int maxIndex = findIndexOfMaxElement(array, array.length);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, maxIndex, i);
            maxIndex = findIndexOfMaxElement(array, i);
        }
    }

    private void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    private int findIndexOfMaxElement(int[] array, int size) {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (array[i] > array[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }

    @Override
    public void optimizedSort(int[] array) {

    }
}
