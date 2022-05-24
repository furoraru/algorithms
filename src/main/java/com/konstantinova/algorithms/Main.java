package com.konstantinova.algorithms;

import com.konstantinova.algorithms.bitwisearithmetic.Bishop;

public class Main {
    public static void main(String[] args) {
        Bishop bishop = new Bishop();
        System.out.println(bishop.bitmaskOfPossibleMoves(41));
    }
}