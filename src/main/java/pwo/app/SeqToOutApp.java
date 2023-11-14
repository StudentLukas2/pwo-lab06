package pwo.app;

import pwo.utils.SequenceTools;

/**
 * Klasa zawierająca funkcje służące do wypisywania liczb wygenerowanych przez
 * generatory w konsoli IDE.
 *
 * @author Łukasz
 * @version 1.0.0
 */
public class SeqToOutApp extends SeqToFileApp {

    /**
     * Metoda odpowiedzialna za pobieranie argumentów programu.
     *
     * @param args Argumenty programu.
     * @return true, jeśli udało się poprawnie pobrać argumenty, w przeciwnym
     * razie false.
     */
    @Override
    protected boolean getArgs(String[] args) {
        // Wywołanie metody getArgs z klasy nadrzędnej
        if (super.getArgs(args)) {
            return true;
        }

        // Sprawdzenie, czy wszystkie niezbędne argumenty są dostępne
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda odpowiedzialna za wypisanie sekwencji liczb w konsoli.
     *
     * @return true, jeśli udało się poprawnie wypisać sekwencję, w przeciwnym
     * razie false.
     */
    @Override
    protected boolean wirteSeq() {
        // Wypisanie sekwencji liczb w konsoli
        System.out.println(SequenceTools.getTermsAsColumn(
                seqType.getGenerator(), from, to));

        return true;
    }

    /**
     * Metoda uruchamiająca program.
     *
     * @param args Argumenty przekazane przy uruchamianiu programu.
     */
    @Override
    public void run(String[] args) {
        // Informacja o uruchamianym programie
        System.out.println("Sequence to terminal CLI app");

        // Sprawdzenie i pobranie argumentów programu
        if (!getArgs(args)) {
            // Wypisanie informacji o błędnych argumentach
            System.out.println("""
                               !Illegal arguments
                               Legal usage: seqName from to""");
            return;
        }

        // Wywołanie metody wypisującej sekwencję
        wirteSeq();
    }

}
