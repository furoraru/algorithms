package com.konstantinova.algorithms;

import com.konstantinova.algorithms.basicstructures.IArray;
import com.konstantinova.algorithms.basicstructures.SingleArray;

public class Main {
    public static void main(String[] args) {
        IArray<Integer> singleArray = new SingleArray<>();
        singleArray.add(1);
        singleArray.add(2);
        singleArray.add(3);
        singleArray.add(4);
        singleArray.add(5);

        singleArray.add(6, 0);
    }
}