package com.konstantinova.algorithms.simplesort;

public class HeapSort extends Sort {
    @Override
    public void sort(int[] array) {
        // build the heap
        for (int root = array.length / 2 - 1; root >= 0; root--) {
            heapify(array, root, array.length);
        }
    }

    @Override
    public void optimizedSort(int[] array) {

    }

    // move max to root
    public void heapify(int[] array, int root, int size) {
        int x = root;
        int left = 2 * x + 1;
        int right = left + 1;

        if (size > 0 && array[left] > array[x]) x = left;
        if (size > 0 && array[right] > array[x]) x = right;
        if (x == root) return;
        swap(x, root);
        heapify(array, x, size);
    }

    public void swap(int x, int root) {

    }
}
