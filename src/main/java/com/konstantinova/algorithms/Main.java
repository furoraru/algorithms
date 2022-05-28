package com.konstantinova.algorithms;

import com.konstantinova.algorithms.basicstructures.IArray;
import com.konstantinova.algorithms.basicstructures.MatrixArray;

public class Main {
    public static void main(String[] args) {
        IArray<Integer> matrix = new MatrixArray<>();
        matrix.add(1);
        matrix.add(2);
        System.out.println(1);
        matrix.add(3, 1);
        System.out.println(2);
        matrix.remove(1);
        System.out.println(3);
    }
}