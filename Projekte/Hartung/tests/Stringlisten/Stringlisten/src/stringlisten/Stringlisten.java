package stringlisten;

/**
 * @author ESkopp
 */
public class Stringlisten {

    public static void main(String[] args) {

        /* löschen der Steuerargumente */
        if (args.length != 0) {
            args = null;
        }

        /* laden der GUI */
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });

    }

}
