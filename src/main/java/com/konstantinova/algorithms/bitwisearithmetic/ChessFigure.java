package com.konstantinova.algorithms.bitwisearithmetic;

public abstract class ChessFigure {
    public abstract long bitmaskOfPossibleMoves(int position);

    public abstract int numberOfPossibleMoves(int position);
}
