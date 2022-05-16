package com.konstantinova.algorithms.algebraicalgorithms.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

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

    /*
    Золотое сечение
    */
    public BigInteger goldenRatioFibo(int n) {
        if (n == 0) return BigInteger.valueOf(0);
        double rootOfFive = Math.pow(5, 0.5);
        BigDecimal ratio = BigDecimal.valueOf((1 + rootOfFive) / 2).pow(n);
        BigDecimal goldenDivision = ratio.divide(BigDecimal.valueOf(rootOfFive), 2, RoundingMode.HALF_UP);
        BigDecimal goldenSum = goldenDivision.add(new BigDecimal(0.5));
        return goldenSum.toBigInteger();
    }

    /*
    Умножение матриц
     */
    public BigInteger matrixMultiplicationFibo(int n) {
        if (n == 0) return BigInteger.valueOf(0L);

        Matrix2D base = Matrix2D.BASE;
        Matrix2D result = Matrix2D.IDENTITY;
        for (int power = n - 1; power > 0; power /= 2) {
            if (power % 2 == 1) {
                result = result.multiply(base);
            }
            base = base.multiply(base);
        }
        return result.getX11();
    }
}
