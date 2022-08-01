package com.konstantinova.algorithms.simplesort;

public class HeapSort extends Sort {
    @Override
    public void sort(int[] array) {
        // build the heap
        for (int root = array.length / 2 - 1; root >= 0; root--) {
            heapify(array, root, array.length);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i); // swap max element to the end of the array, and exclude it from search
            heapify(array, 0, i); // heap restore
        }
    }

    @Override
    public void optimizedSort(int[] array) {

    }

    // move max to root
    public void heapify(int[] array, int root, int size) {
        int left = 2 * root + 1;
        int right = left + 1;
        int x = root;

        if (size > left && array[left] > array[x]) x = left;
        if (size > right && array[right] > array[x]) x = right;
        if (x == root) return;
        swap(array, x, root);
        heapify(array, x, size);
    }

    public void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}
