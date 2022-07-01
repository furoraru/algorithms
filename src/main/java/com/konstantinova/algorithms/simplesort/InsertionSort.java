package com.konstantinova.algorithms.simplesort;

public class InsertionSort extends Sort {
    public void sort(int[] array) {
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
    }

    public void optimizedSort(int[] array) {
        int temp;
        int N = array.length;
        for (int k = 1; k < N; k++) {
            temp = array[k];
            for (int p = k; p >= 0; p--) {
                // когда temp максимальный
                if ((temp > array[p]) && (k - p == 1)) {
                    break;
                }
                // когда temp не максимальный и мы ищем для него index
                if ((temp > array[p])) {
                    System.arraycopy(array, p + 1, array, p + 2, k - p - 1);
                    array[p + 1] = temp;
                    break;
                }
                // крайняя левая позиция
                if ((temp < array[p]) && (p == 0)) {
                    System.arraycopy(array, p, array, p + 1, k - p);
                    array[p] = temp;
                }
            }
        }
    }
}
