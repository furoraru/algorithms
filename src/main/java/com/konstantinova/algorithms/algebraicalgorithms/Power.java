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
    public double juniorPower(double a, long n) {
        System.out.println("A = " + a + "\nN = " + n);
        double result = 1.0;
        if (n == 0) {
            System.out.println(result);
            return result;
        }
        result = a;
        for (long power = 2; power <= n; power++) {
            result *= a;
        }
        System.out.println(result);
        return result;
    }
}
