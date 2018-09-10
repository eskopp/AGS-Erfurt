package zahlen;

import javax.swing.JOptionPane;

/**
 * @author ESkopp
 */
public class core {

    /* Funktionen */
    public String Double_to_String(Double input) {
        // macht aus dem Double einen String.
        return String.valueOf(input);
    }

    public double String_to_Double(String input) {
        // macht aus dem String einen Double
        return Double.parseDouble(input);
    }

    public String runden(Double input) {
        // rundet einen double Wert in einen String Wert
        return String.valueOf((double) Math.round(input * 100) / 100);
    }

    public String runden(String input) {
        // rundet einen double Wert in einen String Wert
        double a = Double.parseDouble(input);
        return String.format("%.2f", Double.parseDouble(input));
    }

    // Für die Fehlermeldung
    public void error() {
        // Fehler beschreiben
        String e = "Bitte geben Sie die Zahl richtig ein.\n"
                + "Beispiel:\n"
                + "Falsch:  3.14159265359 \n"
                + "Richtig: 3,14159265359 ";
        // Fehler ausgeben
        JOptionPane.showMessageDialog(null,
                e,
                "Achtung",
                JOptionPane.WARNING_MESSAGE);

    }

}
