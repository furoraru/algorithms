package com.konstantinova.algorithms.bitwisearithmetic;

/*
Шахматный слон решил пробежаться по шахматной доске.
Сейчас он находится в указанной клетке.
Куда он может походить?
Вывести количество возможных ходов слона
и ulong число с установленными битами тех полей, куда он может походить.

Дано: число от 0 до 63 - индекс позиции слона
Поля нумеруются от а1 = 0, b1 = 1  до  h8 = 63.

Надо: два числа на двух строчках:
количество возможных ходов
битовая маска всех возможных ходов.

На доске кроме слона никого нет,
слон ходит на любое количество полей по диагонали.

http://www.talkchess.com/forum3/viewtopic.php?t=39053
 */
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
