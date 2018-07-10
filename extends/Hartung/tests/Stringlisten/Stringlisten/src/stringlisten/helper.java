package stringlisten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * @author ESkopp
 */
public class helper {

    public helper() {
    }

    public String path() {
        String a = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            a = selectedFile.getAbsolutePath();
        } else {
            a = "null";
        }
        System.out.println(a);
        return a;

    }

    public String[] inhalt() throws Exception {
        String path = path();
        BufferedReader input = new BufferedReader(new FileReader(path));
        ArrayList<String> strings = new ArrayList<>();

        try {
            String line = null;
            while ((line = input.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error, Datei " + path + " existiert nicht.");
        } finally {
            input.close();
        }

        String[] ausgabe = strings.toArray(new String[]{});
        return ausgabe;
    }
}
