package com.konstantinova.algorithms;

import com.konstantinova.algorithms.bitwisearithmetic.Bishop;
import com.konstantinova.algorithms.bitwisearithmetic.Rook;

public class Main {
    public static void main(String[] args) {
        Bishop bishop = new Bishop();
        Rook rook = new Rook();

        System.out.println(bishop.bitmaskOfPossibleMoves(0) + rook.bitmaskOfPossibleMoves(0));
    }
}