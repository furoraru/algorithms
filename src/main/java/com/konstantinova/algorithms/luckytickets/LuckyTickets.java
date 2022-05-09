package com.konstantinova.algorithms.luckytickets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
     * Прочитать условие задачи \src\main\resources\luckytickets\problem.txt
     * Решить задачу в общем случае и протестировать вручную на тестах, которые находятся в ресурсах.*/
    public long middleTicket() {
        int N = 0;
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("src/main/resources/luckytickets/test.0.in");
            bufferedReader = new BufferedReader(fileReader);
            N = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("N = " + N);

        return 1L;
    }
    /*
     * УРОВЕНЬ SENIOR
     * Создать систему тестирования на основе файлов.
     * Проверить работу программы в автоматическом режиме.
     */
}
