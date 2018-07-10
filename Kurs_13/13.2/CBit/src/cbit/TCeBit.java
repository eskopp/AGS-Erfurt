package cbit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Florian Draeger
 */
public class TCeBit {

    //Variablen werden implementiert und initialisiert
    private ArrayList<String> Schüler = new ArrayList<>();
    private ArrayList<TAnmelden> Anmeldungen = new ArrayList<>();
    private int Gesamt, Fahrt = 20, Eintritt = 34;

    //Berechnung des Gesamtwertes
    public int Berechnung(int cFahrt, int cEintritt) {
        Gesamt = (Fahrt * cFahrt) + (Eintritt * cEintritt);
        return Gesamt;
    }

    //Methode Lesen
    public void lesen()  {
        //Try-Catch wird benoetigt
        try {
            //Datei wird im Projektpfad gesucht
            InputStream in = getClass().getResourceAsStream("/Schülerliste.txt");
            BufferedReader input = new BufferedReader(new InputStreamReader(in));
            
            
            while (input.readLine() != null) {
                Schüler.add(input.readLine());
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Datei wurde nicht gefunden.","Fehler",JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten.","Fehler",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addAnmeldung(String Name, boolean Fahrt, boolean Eintritt) {
        //Neues Objekt wird erzeugt
        Anmeldungen.add(new TAnmelden(Name, Fahrt, Eintritt));
    }

    public ArrayList<String> getSchüler() {
        return Schüler;
    }

    public void setSchüler(ArrayList<String> Schüler) {
        this.Schüler = Schüler;
    }

    public ArrayList<TAnmelden> getAnmeldungen() {
        return Anmeldungen;
    }

}
