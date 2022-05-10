package com.konstantinova.algorithms.luckytickets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * ЗАДАНИЕ
 * Счастливые билеты 20
 *
 * Билет с 2N значным номером считается счастливым,
 * если сумма N первых цифр равна сумме последних N цифр.
 * Посчитать, сколько существует счастливых 2N-значных билетов.
 *
 * Начальные данные: число N от 1 до 10.
 * Вывод результата: количество 2N-значных счастливых билетов.
 */
public class LuckyTickets {
    // Количество разрядов
    private static final int DIGITS = 9;

    /*
     * УРОВЕНЬ JUNIOR
     * 6-значный билет считается счастливым,
     * если сумма 3 первых цифр равна сумме последних 3 цифр.
     * Посчитать, сколько существует счастливых 6-значных билетов.
     */
    public long juniorTicket() {
        int sumFirst;
        int sumSecond;
        long countOfSums = 0;
        for (int a1 = 0; a1 <= DIGITS; a1++)
            for (int a2 = 0; a2 <= DIGITS; a2++)
                for (int a3 = 0; a3 <= DIGITS; a3++) {
                    sumFirst = a1 + a2 + a3;
                    for (int b1 = 0; b1 <= DIGITS; b1++)
                        for (int b2 = 0; b2 <= DIGITS; b2++)
                            for (int b3 = 0; b3 <= DIGITS; b3++) {
                                sumSecond = b1 + b2 + b3;
                                if (sumFirst == sumSecond) countOfSums++;
                            }
                }
        System.out.println("My result = " + countOfSums);
        return countOfSums;
    }

    /*
     * УРОВЕНЬ MIDDLE
     * Прочитать условие задачи \src\main\resources\luckytickets\problem.txt
     * Решить задачу в общем случае и протестировать вручную на тестах, которые находятся в ресурсах.
     */
    public long middleTicket() {
        int N = 0;
        FileReader fileReader;
        BufferedReader bufferedReader;
        long trueResult = 0L;
        try {
            fileReader = new FileReader("src/main/resources/luckytickets/test.9.in");
            bufferedReader = new BufferedReader(fileReader);
            N = Integer.parseInt(bufferedReader.readLine());

            fileReader = new FileReader("src/main/resources/luckytickets/test.9.out");
            bufferedReader = new BufferedReader(fileReader);
            trueResult = Long.parseLong(bufferedReader.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // Количество разрядов из файла
        System.out.println("N = " + N);

        long result = computeLuckyTickets(N);

        System.out.println("My  result = " + result);
        System.out.println("Out result = " + trueResult);
        System.out.println("Is the same: " + (result == trueResult));

        return result;
    }

    /*
     * УРОВЕНЬ SENIOR
     * Создать систему тестирования на основе файлов.
     * Проверить работу программы в автоматическом режиме.
     */
    public long seniorTicket(int N) {
        return computeLuckyTickets(N);
    }

    private long computeLuckyTickets(int N) {
        // Заполнение таблицы начальными данными для случая с 1 разрядом
        long[][] sumTable = new long[DIGITS + 1][DIGITS * N + 1];
        for (int row = 0; row <= DIGITS; row++) {
            for (int column = 0; column <= DIGITS * N; column++) {
                if (row == column) sumTable[row][column] = 1;
                else sumTable[row][column] = 0;
            }
        }

        // Заполнение сумм для случая с 1 разрядом
        List<Long> newStepSum = new ArrayList<>(Collections.nCopies(DIGITS + 1, 1L));
        List<Long> lastStepSum;

        for (int n = 2; n <= N; n++) {
            // Переопределение сумм
            lastStepSum = new ArrayList<>(newStepSum);
            newStepSum = new ArrayList<>(Collections.nCopies(DIGITS * n + 1, 0L));

            // Сдвиг сумм в таблице
            for (int row = 0; row <= DIGITS; row++) {
                for (int column = row; column <= row + DIGITS * (n - 1); column++) {
                    sumTable[row][column] = lastStepSum.get(column - row);
                    newStepSum.set(column, newStepSum.get(column) + sumTable[row][column]);
                }
            }
        }

        long result = 0L;
        // Сумма квадратов
        for (int i = 0; i <= DIGITS * N; i++) {
            result += newStepSum.get(i) * newStepSum.get(i);
        }

        return result;
    }
}
