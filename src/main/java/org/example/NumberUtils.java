package org.example;

public class NumberUtils {

    // Método que verifica se um número é primo
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Método que verifica se um número é par
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Método que verifica se um número é múltiplo de outro
    public boolean isMultiple(int number, int divisor) {
        return divisor != 0 && number % divisor == 0;
    }
}
