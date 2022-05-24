package com.konstantinova.algorithms.bitwisearithmetic;

public class Rook extends ChessFigure {
    private static final int BOARD_WIDTH = 8;

    public long bitmaskOfPossibleMoves(int position) {
        long bitboard = 1L << position;

        int leftEnd = position % BOARD_WIDTH; // сколько можно пройти от position до границы слева
        int rightEnd = BOARD_WIDTH - leftEnd - 1; // сколько можно пройти от position до границы справа

        long bitmask = 0;
        //ход вниз
        for (int n = 1; n <= BOARD_WIDTH - 1; n++) {
            bitmask |= bitboard >> n * BOARD_WIDTH;
        }
        //ход вверх
        for (int n = 1; n <= BOARD_WIDTH - 1; n++) {
            bitmask |= bitboard << n * BOARD_WIDTH;
        }
        //ход вправо
        for (int n = 1; n <= rightEnd; n++) {
            bitmask |= bitboard << n;
        }
        //ход влево
        for (int n = 1; n <= leftEnd; n++) {
            bitmask |= bitboard >> n;
        }
        return bitmask;
    }
}
