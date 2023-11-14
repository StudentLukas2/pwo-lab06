package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa reprezentująca generator sekwencji Lucasa, dziedzicząca po klasie
 * FibonacciGenerator.
 *
 * @author: Łukasz
 * @version 1.0.0
 */
public class LucasGenerator extends FibonacciGenerator {

    /**
     * Konstruktor inicjalizujący wartości początkowe generatora Lucasa.
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Metoda resetująca generator Lucasa do stanu początkowego.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Metoda generująca kolejny element sekwencji Lucasa.
     *
     * @return Kolejny element sekwencji jako obiekt BigDecimal.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            // Obsługa generacji pierwszego elementu sekwencji
            lastIndex++;
            return new BigDecimal(2);
        }
        // Wywołanie metody z klasy nadrzędnej do generowania kolejnych elementów
        return super.nextTerm();
    }
}
