package pwo.app;

/**
 * Główna klasa programu odpowiedzialna za uruchamianie aplikacji w zależności
 * od liczby przekazanych argumentów.
 *
 * @author: Łukasz
 * @version 1.0.0
 */
public class Sequence {

    /**
     * Metoda główna programu, uruchamiająca odpowiednią aplikację na podstawie
     * liczby argumentów.
     *
     * @param args Argumenty przekazane przy uruchamianiu programu.
     */
    public static void main(String[] args) {

        // Sprawdzenie liczby przekazanych argumentów i uruchomienie odpowiedniej aplikacji
        switch (args.length) {
            case 3 ->
                (new SeqToOutApp()).run(args);
            case 4 ->
                (new SeqToFileApp()).run(args);
            default ->
                // Wypisanie informacji o błędnych argumentach
                System.out.println("""
                             !Illegal arguments
                             Legal usage: seqName from to [fileName]""");
        }
    }
}
