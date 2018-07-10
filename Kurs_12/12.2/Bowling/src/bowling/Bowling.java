
package bowling;

import java.io.*;
import javax.swing.*;

/**
 * @author ESkopp
 * Menü und UI für User
 */

public class Bowling {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
     game game = new game();
     
     do{
     Object[] options = {"Neue Runde", "Installieren", "Deinstallieren", "Beenden"};

                int selected = JOptionPane.showOptionDialog(null,
                                                            "Treffen Sie eine Auswahl",
                                                            "Alternativen",
							    JOptionPane.DEFAULT_OPTION, 
                                                            JOptionPane.INFORMATION_MESSAGE, 
							    null, options, options[0]);

                
        switch (selected) {
            case 0:
                game.create_new_game();
                break;
            case 1:
                game.install();
                break;
            case 2:
                game.uninstall();
                break;
            case 3: default:
                System.exit(0);
            
        }
        
     }while(true);
     
          
}
    
}

