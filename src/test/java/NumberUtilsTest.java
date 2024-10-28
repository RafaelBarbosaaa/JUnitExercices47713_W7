
import static org.junit.jupiter.api.Assertions.*;

import org.example.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberUtilsTest {

    private NumberUtils numberUtils = new NumberUtils();

    // Teste parametrizado para números primos
    @ParameterizedTest
    @ValueSource(ints = {3, 23, 311, 487, 653, 947})
    public void testIsPrime(int number) {
        assertTrue(numberUtils.isPrime(number), "O número deve ser primo: " + number);
    }

    // Teste parametrizado para números pares
    @ParameterizedTest
    @ValueSource(ints = {32, 64, 2, 20, 30, 26})
    public void testIsEven(int number) {
        assertTrue(numberUtils.isEven(number), "O número deve ser par: " + number);
    }

    // Teste parametrizado para múltiplos de 23
    @ParameterizedTest
    @CsvSource({
            "23, 23",
            "46, 23",
            "115, 23",
            "184, 23",
            "207, 23",
            "230, 23"
    })
    public void testIsMultiple(int number, int divisor) {
        assertTrue(numberUtils.isMultiple(number, divisor), "O número " + number + " deve ser múltiplo de " + divisor);
    }

    // Teste com outros valores para verificar resultados opostos
    @ParameterizedTest
    @CsvSource({
            "4, false",    // 4 não é primo
            "9, false",    // 9 não é primo
            "17, true",    // 17 é primo
            "28, true",    // 28 é par
            "15, false",   // 15 não é par
            "99, 3, true", // 99 é múltiplo de 3
            "100, 7, false" // 100 não é múltiplo de 7
    })
    public void testVariousCases(int number, boolean expectedResult) {
        assertEquals(expectedResult, numberUtils.isPrime(number) || numberUtils.isEven(number) || numberUtils.isMultiple(number, 3), "Resultado esperado: " + expectedResult);
    }
}
