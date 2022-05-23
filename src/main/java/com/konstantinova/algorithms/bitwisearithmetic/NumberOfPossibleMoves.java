package com.konstantinova.algorithms.bitwisearithmetic;

public class NumberOfPossibleMoves {
    public int popCount(long bitmask) {
        int count = 0;
        while (bitmask > 0) {
            if ((bitmask & 1) == 1) count++;
            bitmask >>= 1;
        }
        return count;
    }
}
