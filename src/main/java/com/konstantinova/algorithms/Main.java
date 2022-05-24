package com.konstantinova.algorithms;

import com.konstantinova.algorithms.bitwisearithmetic.Rook;

public class Main {
    public static void main(String[] args) {
        Rook rook = new Rook();
        System.out.println(rook.bitmaskOfPossibleMoves(27));
    }
}