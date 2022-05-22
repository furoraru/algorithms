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
public class King {

    public int numberOfPossibleMoves(int position) {

        return 1;
    }

    public BigInteger bitmaskOfPossibleMoves(int position) {
        BigInteger bitboard = BigInteger.ONE.shiftLeft(position);

        BigInteger notAMask = new BigInteger("18374403900871474942"); //  first column A exclusion
        BigInteger notHMask = new BigInteger("9187201950435737471"); //  last column H exclusion

        BigInteger notABitboard = bitboard.and(notAMask);
        BigInteger notHBitboard = bitboard.and(notHMask);

        BigInteger bitmask =
                        notABitboard.shiftLeft(7).  or(bitboard.shiftLeft(8))   .or(notHBitboard.shiftLeft(9)).or(
                        notABitboard.shiftRight(1))                                .or(notHBitboard.shiftLeft(1)).or(
                        notABitboard.shiftRight(9)).or(bitboard.shiftRight(8))  .or(notHBitboard.shiftRight(7));

//        long bitmask =
//                        notABitboard << 7 | bitboard << 8 | notHBitboard << 9 |
//                        notABitboard >> 1 |                 notHBitboard << 1 |
//                        notABitboard >> 7 | bitboard >> 8 | notHBitboard >> 9;
        return bitmask;
    }
}
