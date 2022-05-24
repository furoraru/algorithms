package com.konstantinova.algorithms.bitwisearithmetic;

public class Rook extends ChessFigure {
    public long bitmaskOfPossibleMoves(int position) {
        long bitboard = 1L << position;

        int leftEnd = position % 8; // сколько можно пройти от position до границы слева
        int rightEnd = 8 - leftEnd - 1; // сколько можно пройти от position до границы справа

        long bitmask = 0;
        //ход вниз
        for (int n = 1; n <= 7; n++) {
            bitmask |= bitboard >> n * 8;
        }
        //ход вверх
        for (int n = 1; n <= 7; n++) {
            bitmask |= bitboard << n * 8;
        }
        //ход вправо
        for (int n = rightEnd; n > 0; n--) {
            bitmask |= bitboard << n;
        }
        //ход влево
        for (int n = 1; n <= leftEnd; n++) {
            bitmask |= bitboard >> n;
        }
        return bitmask;
    }
}
