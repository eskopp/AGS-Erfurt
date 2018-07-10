package cbit;

import javax.swing.DefaultListModel;

/**
 *
 * @author Florian Draeger
 * 
 * Das Programm wird beim Start zentriert.
 * Das Programm benoetigt nur sieben Reihen, weshalb diese manuell implementiert wurden.
 * Die Schuelerliste wurde bereits sortiert.
 * Es handelt sich um eine Rohfassung. Das Programm kann noch um einiges optimiert werden.
 * 
 * Die Klasse TAnmelden ist notwendig fuer die ArrayList, welche deren Objekte speichert.
 * Die Verwaltung, sowie die Berechnung des Gesamtpreises wird in der Klasse "TCeBit" ausgefuehrt.
 * Statt einem Listener wurde zu allen Checkboxen eine separate Ueberpruefung programmiert.
 * 
 */
public class main extends javax.swing.JFrame {
   
    //Implementierung der Klassen
    TAnmelden a;
    TCeBit c;
    
    //Implementierung der Hilfsvariablen
    private int countSchueler, countFahrt, countEintritt;
    private DefaultListModel dlm;

    public main() {
        initComponents();
        
    //Initialisierung der Klassen und Variablen
        c = new TCeBit();
        dlm = new DefaultListModel();
        countSchueler = 1;
        countFahrt = 0;
        countEintritt = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anmelden = new javax.swing.JButton();
        schueler = new javax.swing.JPanel();
        laden = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        liste = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        s1 = new javax.swing.JTextField();
        f1 = new javax.swing.JCheckBox();
        e1 = new javax.swing.JCheckBox();
        s3 = new javax.swing.JTextField();
        s4 = new javax.swing.JTextField();
        s2 = new javax.swing.JTextField();
        s5 = new javax.swing.JTextField();
        s6 = new javax.swing.JTextField();
        s7 = new javax.swing.JTextField();
        e2 = new javax.swing.JCheckBox();
        f2 = new javax.swing.JCheckBox();
        e3 = new javax.swing.JCheckBox();
        f3 = new javax.swing.JCheckBox();
        e4 = new javax.swing.JCheckBox();
        f4 = new javax.swing.JCheckBox();
        e5 = new javax.swing.JCheckBox();
        f5 = new javax.swing.JCheckBox();
        e6 = new javax.swing.JCheckBox();
        f6 = new javax.swing.JCheckBox();
        e7 = new javax.swing.JCheckBox();
        f7 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        gesamt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Anmeldung zur CeBIT-Fahrt");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        anmelden.setText("Anmelden");
        anmelden.setEnabled(false);
        anmelden.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        anmelden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anmeldenActionPerformed(evt);
            }
        });

        schueler.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Schüler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        laden.setText("Schülerliste laden");
        laden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ladenActionPerformed(evt);
            }
        });

        liste.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        liste.setToolTipText("");
        jScrollPane1.setViewportView(liste);

        javax.swing.GroupLayout schuelerLayout = new javax.swing.GroupLayout(schueler);
        schueler.setLayout(schuelerLayout);
        schuelerLayout.setHorizontalGroup(
            schuelerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schuelerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(schuelerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(laden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addContainerGap())
        );
        schuelerLayout.setVerticalGroup(
            schuelerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schuelerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(laden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Anmeldung", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Fahrt");

        jLabel2.setText("Eintritt");

        s1.setEditable(false);
        s1.setFocusable(false);

        f1.setSelected(true);
        f1.setText(" ");
        f1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f1ActionPerformed(evt);
            }
        });

        e1.setText(" ");
        e1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e1ActionPerformed(evt);
            }
        });

        s3.setEditable(false);
        s3.setFocusable(false);

        s4.setEditable(false);
        s4.setFocusable(false);

        s2.setEditable(false);
        s2.setFocusable(false);

        s5.setEditable(false);
        s5.setToolTipText("");
        s5.setFocusable(false);

        s6.setEditable(false);
        s6.setFocusable(false);

        s7.setEditable(false);
        s7.setFocusable(false);

        e2.setText(" ");
        e2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e2ActionPerformed(evt);
            }
        });

        f2.setSelected(true);
        f2.setText(" ");
        f2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f2ActionPerformed(evt);
            }
        });

        e3.setText(" ");
        e3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e3ActionPerformed(evt);
            }
        });

        f3.setSelected(true);
        f3.setText(" ");
        f3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f3ActionPerformed(evt);
            }
        });

        e4.setText(" ");
        e4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e4ActionPerformed(evt);
            }
        });

        f4.setSelected(true);
        f4.setText(" ");
        f4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f4ActionPerformed(evt);
            }
        });

        e5.setText(" ");
        e5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e5ActionPerformed(evt);
            }
        });

        f5.setSelected(true);
        f5.setText(" ");
        f5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f5ActionPerformed(evt);
            }
        });

        e6.setText(" ");
        e6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e6ActionPerformed(evt);
            }
        });

        f6.setSelected(true);
        f6.setText(" ");
        f6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f6ActionPerformed(evt);
            }
        });

        e7.setText(" ");
        e7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e7ActionPerformed(evt);
            }
        });

        f7.setSelected(true);
        f7.setText(" ");
        f7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(e7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(e6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(e5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(e4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(e3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(e2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(e1))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f1)
                    .addComponent(e1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(f2)
                        .addComponent(e2))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(f3)
                        .addComponent(e3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(f4)
                        .addComponent(e4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(f5)
                        .addComponent(e5))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(f6)
                        .addComponent(e6))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(f7)
                        .addComponent(e7))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Gesamt:");

        gesamt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gesamt.setText("0€");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(schueler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(anmelden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gesamt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(anmelden, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(gesamt))))
                    .addComponent(schueler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ladenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ladenActionPerformed
        //Methode wird aufgerufen
        c.lesen();
        
        //Die ersten 7 Elemente der Datei werden eingelesen 
        for (int i = 0; i < 7; i++) {
            dlm.addElement(c.getSchüler().get(i));
        }

        //neues Listenmodel wird gesetzt, Lade-Button wird deaktiviert, Anmelde-Button wird aktiviert
        liste.setModel(dlm);
        laden.setEnabled(false);
        anmelden.setEnabled(true);
    }//GEN-LAST:event_ladenActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Alle Checkboxen und Textfelder (ausser die erste Reihe) wird versteckt
        s2.setVisible(false);        f2.setVisible(false);        e2.setVisible(false);
        s3.setVisible(false);        f3.setVisible(false);        e3.setVisible(false);
        s4.setVisible(false);        f4.setVisible(false);        e4.setVisible(false);
        s5.setVisible(false);        f5.setVisible(false);        e5.setVisible(false);
        s6.setVisible(false);        f6.setVisible(false);        e6.setVisible(false);
        s7.setVisible(false);        f7.setVisible(false);        e7.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void anmeldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anmeldenActionPerformed
       //aktueller Index wird zwischengespeichert
        int index = liste.getSelectedIndex();

        //Auswahl je nach Schueleranzahl
        switch (countSchueler) {
            case 1:
                //Schuelername wird in Textfeld gesetzt
                s1.setText(liste.getSelectedValue());
                
                //Schuelername wird aus dem Model geloescht
                dlm.removeElementAt(index);
                
                //Counter werden erhoeht
                countFahrt++;
                countSchueler++;
                
                //Schueler wird in Liste aufgenommen
                c.addAnmeldung(liste.getSelectedValue(), true, false);
                break;

            case 2:
                s2.setText(liste.getSelectedValue());
                dlm.removeElementAt(index);
                
                //naechste Reihe wird sichtbar
                s2.setVisible(true);
                f2.setVisible(true);
                e2.setVisible(true);
                
                countSchueler++;
                countFahrt++;
                c.addAnmeldung(liste.getSelectedValue(), true, false);
                break;

            case 3:
                s3.setText(liste.getSelectedValue());
                dlm.removeElementAt(index);
                s3.setVisible(true);
                f3.setVisible(true);
                e3.setVisible(true);
                countSchueler++;
                countFahrt++;
                c.addAnmeldung(liste.getSelectedValue(), true, false);
                break;

            case 4:
                s4.setText(liste.getSelectedValue());
                dlm.removeElementAt(index);
                s4.setVisible(true);
                f4.setVisible(true);
                e4.setVisible(true);
                countSchueler++;
                countFahrt++;
                c.addAnmeldung(liste.getSelectedValue(), true, false);
                break;

            case 5:
                s5.setText(liste.getSelectedValue());
                dlm.removeElementAt(index);
                s5.setVisible(true);
                f5.setVisible(true);
                e5.setVisible(true);
                countSchueler++;
                countFahrt++;
                c.addAnmeldung(liste.getSelectedValue(), true, false);
                break;

            case 6:
                s6.setText(liste.getSelectedValue());
                dlm.removeElementAt(index);
                s6.setVisible(true);
                f6.setVisible(true);
                e6.setVisible(true);
                countSchueler++;
                countFahrt++;
                c.addAnmeldung(liste.getSelectedValue(), true, false);
                break;

            case 7:
                s7.setText(liste.getSelectedValue());
                dlm.removeElementAt(index);
                s7.setVisible(true);
                f7.setVisible(true);
                e7.setVisible(true);
                countSchueler++;
                countFahrt++;
                c.addAnmeldung(liste.getSelectedValue(), true, false);
                break;

        }
        
        //Fehlervermeidung
        if (liste.getModel().getSize() == 1) {
            liste.setSelectedIndex(0);
        } else {
            liste.setSelectedIndex(index);
            if (liste.getModel().getSize() == 0) {
                anmelden.setEnabled(false);
            }
        }
        
        //Gesamtbetrag wird berechnet
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_anmeldenActionPerformed

    //Ereignisse fuer Gesamtberechnung
    private void e1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e1ActionPerformed
        //Ueberpruefung, ob Checkbox selektiert ist
        if (e1.isSelected()) {
            countEintritt++;
        } else {
            countEintritt--;
        }
        
        //Berechnung und Wertesetzung
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_e1ActionPerformed

    private void e2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e2ActionPerformed
        if (e2.isSelected()) {
            countEintritt++;
        } else {
            countEintritt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_e2ActionPerformed

    private void e3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e3ActionPerformed
        if (e3.isSelected()) {
            countEintritt++;
        } else {
            countEintritt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_e3ActionPerformed

    private void e4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e4ActionPerformed
        if (e4.isSelected()) {
            countEintritt++;
        } else {
            countEintritt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_e4ActionPerformed

    private void e5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e5ActionPerformed
        if (e5.isSelected()) {
            countEintritt++;
        } else {
            countEintritt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_e5ActionPerformed

    private void e6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e6ActionPerformed
        if (e6.isSelected()) {
            countEintritt++;
        } else {
            countEintritt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_e6ActionPerformed

    private void e7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e7ActionPerformed
        if (e7.isSelected()) {
            countEintritt++;
        } else {
            countEintritt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_e7ActionPerformed

    private void f1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f1ActionPerformed
        if (f1.isSelected()) {
            countFahrt++;
        } else {
            countFahrt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_f1ActionPerformed

    private void f2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f2ActionPerformed
        if (f2.isSelected()) {
            countFahrt++;
        } else {
            countFahrt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_f2ActionPerformed

    private void f3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f3ActionPerformed
        if (f3.isSelected()) {
            countFahrt++;
        } else {
            countFahrt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_f3ActionPerformed

    private void f4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f4ActionPerformed
        if (f4.isSelected()) {
            countFahrt++;
        } else {
            countFahrt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_f4ActionPerformed

    private void f5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f5ActionPerformed
        if (f5.isSelected()) {
            countFahrt++;
        } else {
            countFahrt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_f5ActionPerformed

    private void f6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f6ActionPerformed
        if (f6.isSelected()) {
            countFahrt++;
        } else {
            countFahrt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_f6ActionPerformed

    private void f7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f7ActionPerformed
        if (f7.isSelected()) {
            countFahrt++;
        } else {
            countFahrt--;
        }
        gesamt.setText(String.valueOf(c.Berechnung(countFahrt, countEintritt)) + "€");
    }//GEN-LAST:event_f7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anmelden;
    private javax.swing.JCheckBox e1;
    private javax.swing.JCheckBox e2;
    private javax.swing.JCheckBox e3;
    private javax.swing.JCheckBox e4;
    private javax.swing.JCheckBox e5;
    private javax.swing.JCheckBox e6;
    private javax.swing.JCheckBox e7;
    private javax.swing.JCheckBox f1;
    private javax.swing.JCheckBox f2;
    private javax.swing.JCheckBox f3;
    private javax.swing.JCheckBox f4;
    private javax.swing.JCheckBox f5;
    private javax.swing.JCheckBox f6;
    private javax.swing.JCheckBox f7;
    private javax.swing.JLabel gesamt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton laden;
    private javax.swing.JList<String> liste;
    private javax.swing.JTextField s1;
    private javax.swing.JTextField s2;
    private javax.swing.JTextField s3;
    private javax.swing.JTextField s4;
    private javax.swing.JTextField s5;
    private javax.swing.JTextField s6;
    private javax.swing.JTextField s7;
    private javax.swing.JPanel schueler;
    // End of variables declaration//GEN-END:variables
}
