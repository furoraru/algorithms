package com.konstantinova.algorithms.algebraicalgorithms;

/*
Найти количество простых чисел от 1 до N.

Решить задачу разными способами.
1. Через перебор делителей.
2. Несколько оптимизаций перебора делителей
3. Решето Эратосфена со сложностью O(n log log n).
4. Решето Эратосфена с оптимизацией памяти: битовая матрица, по 32 значения в одном int
5. Решето Эратосфена со сложностью O(n)
 */
public class Primes {
    /*
    Поиск количества простых чисел через перебор делителей, O(N^2)
     */
    public long enumerationOfDivisors(long n) {
        long countOfPrimes = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) countOfPrimes++;
        }
        return countOfPrimes;
    }

    private boolean isPrime(long n) {
        int countOfDivisors = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) countOfDivisors++;
        }
        return countOfDivisors == 2;
    }
}
