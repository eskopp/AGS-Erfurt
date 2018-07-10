package automat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ESkopp
 */
public class database {

    public void schreiben(String path, String save) {
        BufferedWriter i = null;
        try {
            // Datei schreiben
            i = new BufferedWriter(new FileWriter(path));
            i.write(save + "\n\r");
            i.close();
        } catch (IOException ex) {
            //  wenn IOException dann brich ab;
            System.exit(0);
        } finally {
            try {
                i.close();
            } catch (IOException ex) {
                //  wenn IOException dann brich ab;
                System.exit(0);
            }
        }

    }

    public Integer lesen(String path, Integer i) throws Exception {
        String zeile = "";
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            while (zeile.endsWith(String.valueOf(i)) != true) {
                zeile = read.readLine();
            }
        }
        return Integer.parseInt(zeile);
    }

    public boolean test_if_exist(String path) {
        File f = new File(path);
        return f.exists() && !f.isDirectory();
    }

}
