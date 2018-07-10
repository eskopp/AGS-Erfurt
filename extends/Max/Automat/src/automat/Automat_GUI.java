package automat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ESkopp
 */
public class Automat_GUI extends javax.swing.JFrame {

    // erstelle Objekte
    public database db = new database();
    public core c = new core();
    public price p = new price();

    /**
     * new Form
     */
    public Automat_GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new java.awt.Label();
        load_picker = new javax.swing.JButton();
        save = new java.awt.Button();
        Bier = new java.awt.TextField();
        Cola = new java.awt.TextField();
        Kaffee = new java.awt.TextField();
        Bier_text = new java.awt.Label();
        Cola_text = new java.awt.Label();
        Kaffe_text = new java.awt.Label();
        price = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        header.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        header.setName("Automat"); // NOI18N
        header.setText("Getränkeautomat");

        load_picker.setText("Laden");
        load_picker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_pickerActionPerformed(evt);
            }
        });

        save.setLabel("Speichern");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        Bier_text.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Bier_text.setText("Bier");

        Cola_text.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cola_text.setText("Cola");

        Kaffe_text.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Kaffe_text.setText("Kaffee");

        price.setLabel("Preis");
        price.setName("Preis"); // NOI18N
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 214, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Bier, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(Cola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Kaffee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Bier_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(188, 188, 188))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Kaffe_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cola_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(load_picker)
                .addGap(178, 178, 178))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(Bier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(load_picker)
                                .addGap(21, 21, 21)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))
                    .addComponent(Bier_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cola_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kaffee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kaffe_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void load_pickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_pickerActionPerformed
        try {
            // load_picker
            String load_path = FilePicker.picker();

            // reladen der Daten
            Integer Bier_reload = db.lesen(load_path, 1);
            Integer Cola_reload = db.lesen(load_path, 2);
            Integer Kaffee_reload = db.lesen(load_path, 3);

            // überschreiben der Anzeige
            Bier.setText(String.valueOf(Bier_reload));
            Cola.setText(String.valueOf(Cola_reload));
            Kaffee.setText(String.valueOf(Kaffee_reload));

            // Ende der Funktion. Start des Catch-Blocks
        } catch (Exception ex) {
            System.err.print("Fehler: Datei nicht gefunden");
            System.exit(0);
        }
    }//GEN-LAST:event_load_pickerActionPerformed


    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // load data to save
        Integer Kaffee_anz = Integer.parseInt(Kaffee.getText());
        Integer Cola_anz = Integer.parseInt(Cola.getText());
        Integer Bier_anz = Integer.parseInt(Bier.getText());
        String data = Kaffee_anz + ";" + Cola_anz + ";" + Bier_anz;

        // save_picker
        String load_path = FilePicker.picker();
        // check if data exist
        if (db.test_if_exist(load_path)) {
            // wenn Datei existiert erst dann speichern
            db.schreiben(load_path, data);
        } else {
            // Fehler: Kann zu speichernde Datei nicht finden.
            System.exit(0);
        }

    }//GEN-LAST:event_saveActionPerformed


    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // schreiben der Anzahl in die var
        double kosten = c.price[0] * (Integer.parseInt(Bier.getText()))
                + c.price[1] * (Integer.parseInt(Cola.getText()))
                + c.price[2] * (Integer.parseInt(Kaffee.getText()));

        // Datei schreiben
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("kosten.txt"));
            bw.write(String.valueOf(kosten));
            bw.close();
        } catch (IOException ex) {
        }

// neue GUI laden
        java.awt.EventQueue.invokeLater(() -> {
            new price().setVisible(true);
        });
    }//GEN-LAST:event_priceActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField Bier;
    private java.awt.Label Bier_text;
    private java.awt.TextField Cola;
    private java.awt.Label Cola_text;
    private java.awt.Label Kaffe_text;
    private java.awt.TextField Kaffee;
    private java.awt.Label header;
    private javax.swing.JButton load_picker;
    private java.awt.Button price;
    public java.awt.Button save;
    // End of variables declaration//GEN-END:variables
}
