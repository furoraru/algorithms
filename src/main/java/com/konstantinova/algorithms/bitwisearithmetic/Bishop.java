package com.konstantinova.algorithms.bitwisearithmetic;

public class Bishop extends ChessFigure {
    private static final int BOARD_WIDTH = 8;

    public long bitmaskOfPossibleMoves(int position) {
        long bitboard = 1L << position;

        int leftEnd = position % BOARD_WIDTH;
        int rightEnd = BOARD_WIDTH - leftEnd - 1;
        int downEnd = position / BOARD_WIDTH;
        int upEnd = BOARD_WIDTH - downEnd - 1;

        long bitmask = 0;

        //ход вверх вправо
        for (int n = 1; n <= Math.min(rightEnd, upEnd); n++) {
            bitmask |= bitboard << (n * (BOARD_WIDTH + 1));
        }
        //ход вверх влево
        for (int n = 1; n <= Math.min(leftEnd, upEnd); n++) {
            bitmask |= bitboard << n * (BOARD_WIDTH - 1);
        }
        //ход вниз вправо
        for (int n = 1; n <= Math.min(rightEnd, downEnd); n++) {
            bitmask |= bitboard >> n * (BOARD_WIDTH - 1);
        }
        //ход вниз влево
        for (int n = 1; n <= Math.min(leftEnd, downEnd); n++) {
            bitmask |= bitboard >> n * (BOARD_WIDTH + 1);
        }

        return bitmask;
    }
}
