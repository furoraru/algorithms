package com.konstantinova.algorithms;

import com.konstantinova.algorithms.bitwisearithmetic.King;

public class Main {
    public static void main(String[] args) {
        King king = new King();
        System.out.println(king.bitmaskOfPossibleMoves(15));
    }
}
