package marketplace;

import javax.swing.JOptionPane;

/**
 * @author ESkopp
 */
public class Marketplace {

    public static final double[] price = {1.5, 2, 2.5, 2.2}; // Grundpreis
    public static final String[] name = {"Wasser", "Tee", "Kakao", "Kaffe"}; // Namen
    public static double[] sold = {0, 0, 0, 0}; // Anzahl der Verkaufter Sachen
    public static double cost = 0.0; // kosten des Nutzers
    public static int k = 0; // Anzahl der Kunden

    public static int level_menue() {
        Object[] options = {"Wasser", "Tee", "Kakao", "Kaffe", "Beenden", "Fertig"};
        int selected = JOptionPane.showOptionDialog(null,
                "Treffen Sie eine Auswahl",
                "Alternativen",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        return selected;
    }

    public static double eingabe() {
        return Double.parseDouble(JOptionPane.showInputDialog(null, "Wie viele möchten Sie?", "Anzahl", JOptionPane.PLAIN_MESSAGE));
    }

    public static void ausgabe() {
        System.out.println("Anzahl der Kunden" + k + "\n Stückzahl: ");
        double gesamt = 0.0;
        for (int c = 0; c <= 3; c++) {
            System.out.print(name[c] + sold[c] + "\n");
            gesamt += sold[c] * price[c];
        };

        System.out.println("Gesamteinnahmen: " + gesamt);
    }

    public static void end_kunde(Double a) {

        JOptionPane.showMessageDialog(null,
                "Bitte Bezahlen Sie: " + a + "€",
                "Bezahlen",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        // löschen der Steuerargumente
        if (args.length != 0) {
            args = null;
        }

        // Schleife
        do {

            // Erstellung des Menüs
            int user = level_menue();

            switch (user) {
                case 4:
                    // fertig ?!
                    ausgabe();
                    System.exit(0);

                case 5:
                    // Kunde abbrechnen
                    end_kunde(cost);
                    break;

                default:
                    // Wie viele möchten Sie kaufen
                    double y = eingabe();

                    // Bedingungen
                    sold[user] += y; // rechnet den Verkauf hoch
                    cost += price[user] * y; // berechnet den neuen Preis  
                    break;
            }

        } while (true); // Dauerschleife

    }

}
