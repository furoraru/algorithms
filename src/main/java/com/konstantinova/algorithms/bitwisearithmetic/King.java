package com.konstantinova.algorithms.bitwisearithmetic;

import java.math.BigInteger;

/*
1.Прогулка Короля - BITS

00000000 00000000 00000011 00000010 = 2^9 + 2^8 + 2^1 = 512 + 256 + 2 = 770

Король решил прогуляться по пустынной шахматной доске.
Сейчас он находится в указанной клетке.
Куда он может походить?
Вывести количество возможных ходов короля
и ulong число с установленными битами тех полей, куда он может походить.

Дано>: число от 0 до 63 - индекс позиции короля
Поля нумеруются от а1 = 0, b1 = 1  до  h8 = 63.

Надо: два числа на двух строчках:
количество возможных ходов
битовая маска всех возможных ходов короля.

На доске кроме короля никого нет,
король ходит на одну клетку в любую сторону
по горизонтали/вертикали/диагонали.

see more:
https://gekomad.github.io/Cinnamon/BitboardCalculator/
 */
public class King extends ChessFigure {
    public long bitmaskOfPossibleMoves(int position) {
        long bitboard = 1L << position;

        long notAMask = new BigInteger("18374403900871474942").longValue(); //  first column A exclusion
        long notHMask = new BigInteger("9187201950435737471").longValue(); //  last column H exclusion

        long notABitboard = bitboard & notAMask;
        long notHBitboard = bitboard & notHMask;

        long bitmask =
                notABitboard << 7 | bitboard << 8 | notHBitboard << 9 |
                        notABitboard >> 1 | notHBitboard << 1 |
                        notABitboard >> 9 | bitboard >> 8 | notHBitboard >> 7;
        return bitmask;
    }
}
