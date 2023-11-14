package pwo.app;

import pwo.seq.SeqType;
import pwo.utils.SequenceTools;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

/**
 * Klasa bazowa zawierająca funkcje służące do zapisywania liczb wygenerowanych
 * przez generatory do pliku.
 *
 * @author Łukasz
 * @version 1.0.0
 */
class SeqToFileApp {

    // Pola przechowujące informacje o rodzaju sekwencji, zakresie i nazwie pliku
    protected SeqType seqType = null;
    protected Integer from = null, to = null;
    protected String fileName = null;

    /**
     * Metoda odpowiedzialna za pobieranie argumentów programu.
     *
     * @param args Argumenty programu.
     * @return true, jeśli udało się poprawnie pobrać argumenty, w przeciwnym
     * razie false.
     */
    protected boolean getArgs(String[] args) {
        try {
            // Pobranie i przetworzenie argumentów
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            // Obsługa błędnych danych wejściowych
            return false;
        }

        try {
            // Sprawdzenie poprawności ścieżki do pliku
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        // Sprawdzenie, czy wszystkie niezbędne argumenty są dostępne
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda odpowiedzialna za zapisanie sekwencji liczb do pliku.
     *
     * @return true, jeśli udało się poprawnie zapisać sekwencję do pliku, w
     * przeciwnym razie false.
     */
    protected boolean wirteSeq() {
        // Wywołanie metody zapisującej sekwencję do pliku
        return SequenceTools.writeToFile(seqType.getGenerator(),
                from, to, fileName);
    }

    /**
     * Metoda uruchamiająca program.
     *
     * @param args Argumenty przekazane przy uruchamianiu programu.
     */
    public void run(String[] args) {
        // Informacja o uruchamianym programie
        System.out.println("Sequence to file CLI app");

        // Sprawdzenie i pobranie argumentów programu
        if (!getArgs(args)) {
            // Wypisanie informacji o błędnych argumentach
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to fileName");
            return;
        }

        // Sprawdzenie powodzenia zapisu sekwencji do pliku
        if (!wirteSeq()) {
            System.out.println("!Write to the file: "
                    + fileName + " FAILED");
            return;
        }

        // Informacja o pomyślnym zapisie sekwencji do pliku
        System.out.println("Results write to " + fileName);
    }
}
