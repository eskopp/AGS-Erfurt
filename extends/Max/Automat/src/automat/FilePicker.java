package automat;

import java.io.File;
import javax.swing.JFileChooser;

/**
 * @author ESkopp
 */
public class FilePicker {

    public static String picker() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        } else {
            return "null";
        }
    }
}
