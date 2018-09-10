package automat;

import java.io.File;

/**
 * @author ESkopp
 */
public class core {

    // Variabeln 
    protected final String[] Getränke = {"Bier", "Cola", "Kaffe"};
    protected final Double[] price = {1.5, 0.8, 1.0};
    public double kosten;

    // Methoden
    public void if_dir() {
        // ist schon groß und kann das ganz allein ^^
        String path = "/db"; // fragt den User nicht :D
        File dir = new File(path);
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdir();
        }
    }


    

}
