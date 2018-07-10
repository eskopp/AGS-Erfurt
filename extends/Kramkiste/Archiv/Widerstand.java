package widerstand;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @version 1.0
 * @author ESkopp // hier deinen Namen einschreiben ^^
 */
public class Widerstand {

    //Variabeln 
    private static String eingabe;
    private static double r1;
    private static double r2;
    private static double ges;
    public final static String ws = "\n"; //Zeilenumbruch 

    // Konstruktor (am besten gleich immer mitmachen)
    public Widerstand() {
        eingabe = "";
        r1 = 0.0;
        r2 = 0.0;
        ges = 0.0;
    }

    public static void main(String[] args) {
        // Scanner Object erzeugen
        Scanner sc = new Scanner(System.in);

        // Dezimal Format erzeugen.
        DecimalFormat df = new DecimalFormat("#####0.00");

        // Obere Ausgabe 
        System.out.print("Widerstandsberechnung" + ws);
        
         // Wahl der Schaltung
        System.out.print("(P)arallel- oder (R)eihenschaltung?: ");
        /* Laut der Aufgabenstellung sollte hier ein char stehen. 
            * Das geht aber für den Anfgang etwas zu weit. 
            * Das Programm ist auch so lauffähig */
        eingabe = sc.next();

        // Eingabe
        System.out.print("R1 (in Ohm): ");
        r1 = sc.nextDouble();
        System.out.print("R2 (in Ohm): ");
        r2 = sc.nextDouble();
        
       
        // Verzweigung Block (switch / case) 
        switch (eingabe) {
            case "R":
            case "r":
                ges = r1 + r2;
                break;
            case "P":
            case "p":
                ges = (r1 * r2) / (r1 + r2);
                break;
            default:
                System.err.print("Nöö. So nicht!"+ws);
                System.exit(0); // Bricht ab
        }
        
        System.out.print("Der Gesamtwiderstand betraegt "+df.format(ges)+" Ohm"+ws);
    }
}
