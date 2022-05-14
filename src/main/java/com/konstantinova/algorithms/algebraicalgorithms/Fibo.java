package com.konstantinova.algorithms.algebraicalgorithms;

import java.math.BigInteger;

/*
Найти и вывести на экран точное значение N-ого числа Фибоначчи.

Решить задачу разными способами.
1. Через рекурсию.
2. Через итерацию.
3. Через формулу золотого сечения.
4. Через возведение матрицы в степень.
 */
public class Fibo {
    /*
    Рекурсивный O(2^N)
     */
    public long recursionFibo(long n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return recursionFibo(n - 1) + recursionFibo(n - 2);
    }

    /*
    Итеративный O(N)
     */
    public BigInteger iteratingFibo(long n) {
        if (n == 0) return BigInteger.valueOf(0);

        BigInteger fib = BigInteger.valueOf(0);
        BigInteger fib1 = BigInteger.valueOf(1);
        BigInteger fib2 = BigInteger.valueOf(1);
        for (long i = 1; i <= n; i++) {
            fib = fib1;
            fib1 = fib2;
            fib2 = fib.add(fib1);
        }
        return fib;
    }
}
