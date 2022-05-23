package com.konstantinova.algorithms.bitwisearithmetic;

import java.math.BigInteger;

/*
2.Конь - BITS *

00000000 00000010 00000100 00000000 = 2^17 + 2^10 = 131072 + 1024 = 132096

Шахматный конь решил пробежаться по шахматной доске.
Сейчас он находится в указанной клетке.
Куда он может походить?
Вывести количество возможных ходов коня
и ulong число с установленными битами тех полей, куда он может походить.

Дано: число от 0 до 63 - индекс позиции коня
Поля нумеруются от а1 = 0, b1 = 1  до h8 = 63.

Надо: два числа на двух строчках:
количество возможных ходов
битовая маска всех возможных ходов коня.

На доске кроме коня никого нет,
конь ходит буквой "Г": две клетки вперёд и одна вбок.

http://www.talkchess.com/forum3/viewtopic.php?t=39053
 */
public class Knight extends ChessFigure {
    public long bitmaskOfPossibleMoves(int position) {
        long bitboard = 1L << (position);

        long notAMask = new BigInteger("18374403900871474942").longValue(); //  first column A exclusion
        long notHMask = new BigInteger("9187201950435737471").longValue(); //  last column H exclusion
        long notABMask = new BigInteger("18229723555195321596").longValue(); // AB exclusion
        long notGHMask = new BigInteger("4557430888798830399").longValue(); // GH exclusion

        long bitmask =
                notGHMask & (bitboard << 6 | bitboard >> 10)
                        | notHMask & (bitboard << 15 | bitboard >> 17)
                        | notAMask & (bitboard << 17 | bitboard >> 15)
                        | notABMask & (bitboard << 10 | bitboard >> 6);
        return bitmask;
    }

}
