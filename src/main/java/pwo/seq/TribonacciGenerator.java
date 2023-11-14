package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa reprezentująca generator sekwencji Tribonacciego, dziedzicząca po
 * klasie FibonacciGenerator.
 *
 * @author: Łukasz
 * @version 1.0.0
 */
public class TribonacciGenerator extends FibonacciGenerator {

    /**
     * Konstruktor inicjalizujący wartość początkową trzeciego elementu
     * generatora Tribonacciego.
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Metoda resetująca generator Tribonacciego do stanu początkowego.
     */
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }

    /**
     * Metoda generująca kolejny element sekwencji Tribonacciego.
     *
     * @return Kolejny element sekwencji jako obiekt BigDecimal.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            // Obliczenie kolejnego elementu sekwencji
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            // Ustawienie wartości dla trzeciego elementu sekwencji
            current = new BigDecimal(1);
        } else {
            // Ustawienie wartości dla pierwszego i drugiego elementu sekwencji
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
