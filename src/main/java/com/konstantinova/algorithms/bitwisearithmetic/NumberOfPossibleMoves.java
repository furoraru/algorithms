package com.konstantinova.algorithms.bitwisearithmetic;

public class NumberOfPossibleMoves {
    int[] b = new int[256];

    public int popCount(long bitmask) {
        int count = 0;
        while (bitmask > 0) {
            if ((bitmask & 1) == 1) count++;
            bitmask >>= 1;
        }
        return count;
    }

    public int popCount2(long bitmask) {
        int count = 0;
        while (bitmask > 0) {
            count++;
            bitmask &= bitmask - 1;
        }
        return count;
    }

    public int popCount3(long bitmask) {
        fillBits();
        int count = 0;
        while (bitmask > 0) {
            count += b[(int) (bitmask & 255)];
            bitmask >>= 8;
        }
        return count;
    }

    private void fillBits() {
        for (int i = 0; i <= 255; i++) {
            b[i] = popCount2(i);
        }
    }
}
