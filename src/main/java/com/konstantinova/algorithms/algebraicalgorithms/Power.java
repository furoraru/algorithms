package com.konstantinova.algorithms.algebraicalgorithms;

/*
Вычислить A^N. Результат вывести на экран в стандартном виде.

Решить задачу разными способами.
1. Через обычные итерации.
2. Через степень двойки с домножением.
3. Через двоичное разложение показателя степени.
 */
public class Power {
    /*
    Итеративный O(N) алгоритм возведения числа в степень
     */
    public double iteratingPower(double a, long n) {
        double result = 1.0; // A^0
        for (long power = 1; power <= n; power++) {
            result *= a;
        }
        return result;
    }

    /*
    Через домножение O(N/2+LogN) = O(N).
     */
    public double multiplicationPower(double a, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return a;

        double a1 = a;
        long power = 2L;
        for (; power <= n / 2; power *= 2) {
            a *= a; // a^2 a^4 a^8 ...
        }
        a *= a;
        power += 1;
        for (; power <= n; power++) {
            a *= a1;
        }
        return a;
    }

    /*
    Через двоичное разложение показателя степени O(2LogN) = O(LogN)
     */
    public double binaryDecomposition(double a, long n) {
        double result = 1.0;
        for (long power = n; power > 0 ; power /= 2) {
            if (power % 2 == 1) {
                result *= a;
            }
            a *= a;
        }
        return result;
    }
}
