package zahlen;

import java.util.Scanner;

/**
 * @author ESkopp
 */
public class Zahlen {

    static core func = new core();
    public static double new_eingabe = 0.0;

    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);

        // Ausgeben der Warnung
        func.error();

        // Eingabe
        System.out.print("Bitte geben Sie eine Zahl ein: \n");

        // Der try Block schützt vor einer falschen eingabe
        try {
            new_eingabe = eingabe.nextDouble();
        } catch (Exception ex) {
            func.error();
        }
        System.out.print("\n");

        // Ausgabe als Zahl
        System.out.print(new_eingabe + " <Double>\n");

        // Ausgabe als String
        System.out.print(func.Double_to_String(new_eingabe) + " <String>\n");

        // Runden
        System.out.print(func.runden(new_eingabe) + " <String>\n");

        // Programm beenden
        System.exit(0);

    }

}
