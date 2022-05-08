package com.konstantinova.algorithms.luckytickets;

/**
 * ЗАДАНИЕ
 * Счастливые билеты
 */
public class LuckyTickets {
    /**
     * УРОВЕНЬ JUNIOR
     * 6-значный билет считается счастливым,
     * если сумма 3 первых цифр равна сумме последних 3 цифр.
     * Посчитать, сколько существует счастливых 6-значных билетов.
     */
    public long juniorTicket() {
        int sumFirst;
        int sumSecond;
        long countOfSums = 0;
        for (int a1 = 0; a1 < 10; a1++)
            for (int a2 = 0; a2 < 10; a2++)
                for (int a3 = 0; a3 < 10; a3++) {
                    sumFirst = a1 + a2 + a3;
                    for (int b1 = 0; b1 < 10; b1++)
                        for (int b2 = 0; b2 < 10; b2++)
                            for (int b3 = 0; b3 < 10; b3++) {
                                sumSecond = b1 + b2 + b3;
                                if (sumFirst == sumSecond) countOfSums++;
                            }
                }
        return countOfSums;
    }

    /*
     * УРОВЕНЬ MIDDLE
     * Прочитать условие задачи \1.Tickets\problem.txt
     * Решить задачу в общем случае и протестировать вручную на тестах, которые находятся в ресурсах.
     * УРОВЕНЬ SENIOR
     * Создать систему тестирования на основе файлов.
     * Проверить работу программы в автоматическом режиме.
     */
}
