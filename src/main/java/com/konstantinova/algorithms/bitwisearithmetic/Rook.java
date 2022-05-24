package com.konstantinova.algorithms.bitwisearithmetic;

/*
Шахматная ладья решила пробежаться по шахматной доске.
Сейчас она находится в указанной клетке.
Куда она может сейчас походить?
Вывести количество возможных ходов ладьи
и ulong число с установленными битами тех полей, куда она может походить.

Дано: число от 0 до 63 - индекс позиции ладьи
Поля нумеруются от а1 = 0, b1 = 1  до  h8 = 63.

Надо: два числа на двух строчках:
количество возможных ходов
битовая маска всех возможных ходов коня.

На доске кроме ладьи никого нет,
ладья ходит на любое количество полей по горизонтали или по вертикали.

http://www.talkchess.com/forum3/viewtopic.php?t=39053
 */
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
