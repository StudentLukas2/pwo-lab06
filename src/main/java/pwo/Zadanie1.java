

public class Zadanie1 {

    public static final int FROM = 0, TO = 100;
    public static final String FILE_NAME = "fibseq100.txt";
    public static final String FILE_NAME_LUCAS = "lucasseq100.txt";

    public static void main(String[] args) {

        System.out.println("Fibonacci wersja 2, Lucas");

        boolean ok = SequenceTools.writeToFile(
                new FibonacciGenerator(), FROM, TO, FILE_NAME);
        boolean oklucas = SequenceTools.writeToFileLucas(
                new LucasGenerator(), FROM, TO, FILE_NAME_LUCAS);

        if (ok) {
            System.out.println("Wynik zapisany do pliku: "
                    + FILE_NAME);
        } else {
            System.out.println("Błąd");
        }
        if (oklucas) {
            System.out.println("Wynik zapisany do pliku: "
                    + FILE_NAME_LUCAS);
        } else {
            System.out.println("Błąd");
        }
    }
}
