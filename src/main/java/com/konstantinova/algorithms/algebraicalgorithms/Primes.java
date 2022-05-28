package com.konstantinova.algorithms.algebraicalgorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Найти количество простых чисел от 1 до N.

Решить задачу разными способами.
1. Через перебор делителей.
2. Несколько оптимизаций перебора делителей
3. Решето Эратосфена со сложностью O(n log log n).
4. Решето Эратосфена с оптимизацией памяти: битовая матрица, по 32 значения в одном int
5. Решето Эратосфена со сложностью O(n)

------------------------------------------------------------------------------------------------------------------------
                                                PRIMES

N	            |  enumerationOfDivisors, ms    |	divisionByPrimes, ms     |	  eratosthenes, ms
------------------------------------------------------------------------------------------------------------------------
10	            |         0	                    |        0	                 |         2
1	            |         0	                    |        0	                 |         0
2	            |         0	                    |        0	                 |         0
3	            |         0	                    |        0	                 |         0
4	            |         0	                    |        0	                 |         0
5	            |         0	                    |        0	                 |         0
100	            |         0 	                |        0	                 |         0
1000 	        |         6 	                |        0	                 |         1
10000	        |         681	                |        0  	             |         4
100000          |         52915	                |        8	                 |         12
1000000         |         долго                 |        71                  |         46
10000000        |         долго                 |       1071                 |         627
100000000       |         долго                 |       19745                |         5875
1000000000      |         долго                 |       долго                |         java.lang.OutOfMemoryError: Java heap space
123456789       |         долго                 |       долго                |         java.lang.OutOfMemoryError: Java heap space
                                                                                       нужна доп. память
________________________________________________________________________________________________________________________

 */
public class Primes {
    /*
    Поиск количества простых чисел через перебор делителей, O(N^2)
     */
    public long enumerationOfDivisors(long n) {
        long countOfPrimes = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrimeEnumerationOfDivisors(i)) countOfPrimes++;
        }
        return countOfPrimes;
    }

    private boolean isPrimeEnumerationOfDivisors(long n) {
        int countOfDivisors = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) countOfDivisors++;
        }
        return countOfDivisors == 2;
    }

    /*
      Оптимизация поиска с делением только на простые числа, O(N * Sqrt(N) / Ln (N)).
     */
    public long divisionByPrimes(int n) {
        if (n == 1) return 0;
        int[] primes = new int[n / 2 + 1];
        int countOfPrimes = 0;
        primes[countOfPrimes] = 2;
        countOfPrimes++;
        for (int prime = 3; prime <= n; prime++)
            if (isPrimeDivisionByPrimes(prime, primes)) {
                primes[countOfPrimes] = prime;
                countOfPrimes++;
            }
        return countOfPrimes;
    }

    private boolean isPrimeDivisionByPrimes(int n, int[] primes) {
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 0; primes[i] <= sqrtN; i++)
            if (n % primes[i] == 0)
                return false;
        return true;
    }

    /*
    Решето Эратосфена для быстрого поиска простых чисел O(N Log Log N)
     */
    public long eratosthenes(int n) {
        if (n == 1) return 0;

        int[] a = new int[n + 1];
        // заполняем массив всеми числами
        for (int i = 0; i <= n; i++) {
            a[i] = i;
        }

        a[1] = 0;

        int i = 2;
        int p;
        // сначала вычеркиваем числа 2p, 3p.. потом берем первое незачеркнутое и повторяем вычеркивание
        while (i <= n) {
            if (a[i] != 0) {
                p = i + i;
                while (p <= n) {
                    a[p] = 0;
                    p += i;
                }
            }
            i += 1;
        }

        // убираем повторяющиеся нули
        Set<Integer> set = IntStream.of(a).boxed().collect(Collectors.toSet());
        // убираем последний нуль
        set.remove(0);

        return set.size();
    }
}
