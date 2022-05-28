package com.konstantinova.algorithms.algebraicalgorithms;

/*
Вычислить A^N. Результат вывести на экран в стандартном виде.

Решить задачу разными способами.
1. Через обычные итерации.
2. Через степень двойки с домножением.
3. Через двоичное разложение показателя степени.

------------------------------------------------------------------------------------------------------------------------
                                                POWER

A               N	            |  iteratingPower, ms   |	multiplicationPower, ms  |	  binaryDecomposition, ms
------------------------------------------------------------------------------------------------------------------------
2               10	            |         0	            |        0	                 |         0
123456789       0	            |         0	            |        0	                 |         0
1.001           1000	        |         0	            |        0	                 |         0
1.0001          10000	        |         0	            |        0	                 |         0
1.00001         100000	        |         0	            |        0	                 |         0
1.000001        1000000	        |         2	            |        1	                 |         0
1.0000001       10000000	    |         13	        |        6	                 |         0
1.00000001      100000000 	    |         153	        |        57	                 |         0
1.000000001     1000000000	    |         1396	        |        816	             |         0
1.0000000001    10000000000	    |         12830	        |        2019	             |         0
                                                         погрешность растет быстрее     погрешность растет быстрее
________________________________________________________________________________________________________________________

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
