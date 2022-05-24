package com.konstantinova.algorithms.bitwisearithmetic;

public class Queen extends ChessFigure {

    public long bitmaskOfPossibleMoves(int position) {
        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        long bitmask = rook.bitmaskOfPossibleMoves(position) + bishop.bitmaskOfPossibleMoves(position);
        return bitmask;
    }
}
