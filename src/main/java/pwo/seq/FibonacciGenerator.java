package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa reprezentująca generator sekwencji Fibonacciego, dziedzicząca po klasie
 * Generator.
 *
 * @author: Łukasz
 * @version 1.0.0
 */
public class FibonacciGenerator extends Generator {

    /**
     * Konstruktor inicjalizujący wartości początkowe generatora Fibonacciego.
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Metoda resetująca generator do stanu początkowego.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Metoda generująca kolejny element sekwencji Fibonacciego.
     *
     * @return Kolejny element sekwencji jako obiekt BigDecimal.
     */
    @Override
    public BigDecimal nextTerm() {

        if (lastIndex > 1) {
            // Obliczenie kolejnego elementu sekwencji
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            // Ustawienie wartości dla drugiego elementu sekwencji
            current = new BigDecimal(1);
        } else {
            // Ustawienie wartości dla pierwszego elementu sekwencji
            current = new BigDecimal(0);
        }

        lastIndex++;
        return current;
    }
}
