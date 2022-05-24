package com.konstantinova.algorithms.bitwisearithmetic;

/*
Шахматный ферзь решил пробежаться по шахматной доске.
Сейчас он находится в указанной клетке.
Куда он может походить?
Вывести количество возможных ходов ферзя
и ulong число с установленными битами тех полей, куда он может походить.

Дано: число от 0 до 63 - индекс позиции ферзя
Поля нумеруются от а1 = 0, b1 = 1  до  h8 = 63.

Надо: два числа на двух строчках:
количество возможных ходов
битовая маска всех возможных ходов.

На доске кроме ферзя никого нет,
ферзь ходит на любое количество полей по диагонали, горизонтали и вертикали.

http://www.talkchess.com/forum3/viewtopic.php?t=39053
 */
public class Queen extends ChessFigure {

    public long bitmaskOfPossibleMoves(int position) {
        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        long bitmask = rook.bitmaskOfPossibleMoves(position) + bishop.bitmaskOfPossibleMoves(position);
        return bitmask;
    }
}
