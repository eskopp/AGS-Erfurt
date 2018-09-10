package automat;

/**
 * @author ESkopp
 */
public class Automat {

    static core c = new core();

    /**
     * @param args
     */
    public static void main(String[] args) {
        // löschen der Steuerargumente
        if (args.length != 0) {
            args = null;
        }

        // checkt und erstellt die Ordnerstruktur
        c.if_dir();

        // starten der GUI
        java.awt.EventQueue.invokeLater(() -> {
            new Automat_GUI().setVisible(true);
        });
    }
}
