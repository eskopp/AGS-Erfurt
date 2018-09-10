package numberconverter;

import java.util.Scanner;

/**
 *
 * @author ESkopp
 */
public class NumberConverter {

    Scanner sc = new Scanner(System.in);
    private final static char[] hexTabelle = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String dezimalNachBinaer(int dezimal) {
        String binaer = "";
        while (dezimal > 0) {
            if (dezimal % 2 == 0) {
                binaer = "0" + binaer;
            }
            if (dezimal % 2 == 1) {
                binaer = "1" + binaer;
            }
            dezimal = dezimal / 2;
        }
        return binaer;
    }

    /*
	 * Diese Funktion ist bestimmt auch noch schöner zu lösen
     */
    public static String dezimalNachHexadezimal(int dezimal) {
        String hex = "";
        while (dezimal > 0) {
            hex = hexTabelle[dezimal % 16] + hex;
            dezimal = dezimal / 16;
        }
        return hex;
    }

    public static int binaerNachDezimal(String binaer) {
        int dezimal = 0;
        char[] tokens = binaer.toCharArray();
        // vorsicht wir muessen von hinten anfangen 2^0 usw.
        double pow = 0;
        for (int i = (tokens.length - 1); i >= 0; i--) {
            dezimal = dezimal
                    + (Integer.parseInt(String.valueOf(tokens[i])) * (int) Math
                    .pow(2, pow));
            pow++;
        }
        return dezimal;
    }

    public static int HexadezimalNachDezimal(String hex) {
        int dezimal = 0;
        char[] tokens = hex.toCharArray();
        // vorsicht wir muessen von hinten anfangen 16^0 usw.
        double pow = 0;
        for (int i = (tokens.length - 1); i >= 0; i--) {
            int mul = 0;
            for (int j = 0; j < hexTabelle.length; j++) {
                if (hexTabelle[j] == tokens[i]) {
                    mul = j;
                    break; // das break ist hier nicht schön aber somit
                    // vermeidet man dass das gesammte array durchlaufen
                    // wird da ja hier etwas passendes gefunden wurde
                }
            }
            dezimal = dezimal + (mul * (int) Math.pow(16, pow));
            pow++;
        }
        return dezimal;
    }

    public void main() {
        while (true) {
            System.out.println("----- Menu -----");
            System.out.println("Options:");
            System.out.println("\t[1] Dezimal zu Binär");
            System.out.println("\t[2] Dezimal zu Hexadezimal");
            System.out.println("\t[3] Binär zu Dezimal");
            System.out.println("\t[4] Hexadezimal zu Dezimal");
            System.out.println("\t[5] Ende");
            System.out.println("Wählen Sie eine Option: ");
            int option = sc.nextInt();
            String value = "";
            switch (option) {
                case 1:
                    System.out.println("Geben Sie eine Dezimalzahl ein: ");
                    value = sc.next();
                    System.out.println("Result: " + dezimalNachBinaer(Integer.valueOf(value)));
                    break;
                case 2:
                    System.out.println("Geben Sie eine Dezimalzahl ein: ");
                    value = sc.next(); // ggf. Dek einfügen
                    System.out.println("Result: " + dezimalNachHexadezimal(Integer.valueOf(value)));
                    break;
                case 3:
                    value = "";
                    for (int x = 0; x == 4; x++) {
                        System.out.println("Bitte geben Sie den " + x + ". Wert ein:");
                        value += sc.next();
                    }
                    value = new StringBuilder(value).reverse().toString();
                    System.out.println("Result: " + binaerNachDezimal(value));
                    break;
                case 4:
                    value = "";
                    for (int x = 0; x == 4; x++) {
                        System.out.println("Bitte geben Sie den " + x + ". Wert ein:");
                        value += sc.next();
                    }
                    value = new StringBuilder(value).reverse().toString();
                    System.out.println("Result: " + HexadezimalNachDezimal(value));
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Keine Gültige Operation");
            }
        }
    }
// Projekt angelehnt an: https://wiki.freitagsrunde.org/Javakurs/%C3%9Cbungsaufgaben/Zahlenumrechner/Musterloesung
}
