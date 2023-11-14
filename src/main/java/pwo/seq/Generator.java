package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

/**
 * Klasa abstrakcyjna stanowiąca bazę dla generatorów sekwencji, implementująca
 * interfejs SequenceGenerator.
 *
 * @author: Łukasz
 * @version 1.0.0
 */
abstract class Generator implements SequenceGenerator {

    // Pola przechowujące informacje o stanie generatora
    protected int lastIndex = 0;
    protected BigDecimal current = null,
            f_1 = null,
            f_2 = null,
            f_3 = null;

    /**
     * Metoda resetująca stan generatora.
     */
    @Override
    public void reset() {
        lastIndex = 0;
    }

    /**
     * Metoda zwracająca i-ty element sekwencji.
     *
     * @param i Indeks elementu sekwencji.
     * @return i-ty element sekwencji jako obiekt BigDecimal.
     * @throws IllegalArgumentException jeśli przekazany indeks jest mniejszy od
     * 0.
     */
    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            // Obsługa błędnego indeksu
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            // Resetowanie generatora, jeśli indeks jest mniejszy niż ostatni indeks użyty
            reset();
        }
        while (lastIndex <= i) {
            // Generowanie kolejnych elementów sekwencji, aż do osiągnięcia żądanego indeksu
            nextTerm();
        }
        return current;
    }
}
