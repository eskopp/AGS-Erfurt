package semi;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
        start();
    }   // Anwendung startet hier

    private static void start() {
        setSysFolder();
        createGUI();
        try {
            loadS();
        } catch (IOException ex) {
            jTextArea1.setText("Die Einstellungen konnten nicht geladen werden.");
        }
        try {
            checkPrList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // Ruft alle Methoden auf, die für den Start wichtig sind

    private static void createGUI() {
        Dimension dS = new Dimension(350, 50);
        Font fS = new java.awt.Font("Tahoma", 0, 20);
        Color cGre = new java.awt.Color(150, 150, 150);
        Color cWh = new java.awt.Color(250, 250, 250);
        Color cBg = new java.awt.Color(238, 238, 238);
        java.awt.LayoutManager2 GBL = new GridBagLayout();

        jFrame.setSize(1250, 800);
        jFrame.setMinimumSize(new Dimension(1250, 800));
        jFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame.setTitle("SWAP");
        jFrame.add(jSplitPane1);
        gIcon = new ImageIcon(gSysDir + "/icon.png").getImage();
        jFrame.setIconImage(gIcon);

        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 30));
        jTextArea1.setText("Herzlich Willkommen");

        JScrollPane sp = new JScrollPane(jTextArea1);

        jSplitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane1.setLeftComponent(jTabbedPane1);
        jSplitPane1.setRightComponent(sp);

        jTabbedPane1.setPreferredSize(new Dimension(600, 800));
        jTabbedPane1.setMinimumSize(new Dimension(600, 800));
        jTabbedPane1.setFont(fS);

        jButton1.setPreferredSize(dS);
        jButton1.setBackground(new Color(225, 225, 225));
        jButton1.setFont(fS);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton1ActionPerformed();
        });

        jButton2.setPreferredSize(new Dimension(400, 50));
        jButton2.setBackground(new Color(225, 225, 225));
        jButton2.setFont(fS);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton2ActionPerformed();
        });

        jButton2c.setPreferredSize(new Dimension(400, 50));
        jButton2c.setBackground(new Color(225, 225, 225));
        jButton2c.setFont(fS);
        jButton2c.setFocusPainted(false);
        jButton2c.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton2ActionPerformed();
        });

        jButton3.setPreferredSize(new Dimension(400, 50));
        jButton3.setBackground(new Color(225, 225, 225));
        jButton3.setFont(fS);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton3ActionPerformed();
        });

        jButton3c.setPreferredSize(new Dimension(400, 50));
        jButton3c.setBackground(new Color(225, 225, 225));
        jButton3c.setFont(fS);
        jButton3c.setFocusPainted(false);
        jButton3c.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton3ActionPerformed();
        });

        jButton4.setPreferredSize(new Dimension(400, 50));
        jButton4.setBackground(new Color(225, 225, 225));
        jButton4.setFont(fS);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed();
        });

        jButton5.setPreferredSize(new Dimension(400, 50));
        jButton5.setBackground(new Color(225, 225, 225));
        jButton5.setFont(fS);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton5ActionPerformed();
        });

        jButton6.setPreferredSize(new Dimension(400, 50));
        jButton6.setBackground(new Color(225, 225, 225));
        jButton6.setFont(fS);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton6ActionPerformed();
        });

        jButton7.setPreferredSize(new Dimension(400, 50));
        jButton7.setBackground(new Color(225, 225, 225));
        jButton7.setFont(fS);
        jButton7.setFocusPainted(false);
        jButton7.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton7ActionPerformed();
        });

        jButton8.setPreferredSize(new Dimension(400, 50));
        jButton8.setBackground(new Color(225, 225, 225));
        jButton8.setFont(fS);
        jButton8.setFocusPainted(false);
        jButton8.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton8ActionPerformed();
        });

        jButton9.setPreferredSize(new Dimension(400, 50));
        jButton9.setBackground(new Color(225, 225, 225));
        jButton9.setFont(fS);
        jButton9.setFocusPainted(false);
        jButton9.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton9ActionPerformed();
        });

        jButton10.setPreferredSize(new Dimension(400, 50));
        jButton10.setBackground(new Color(225, 225, 225));
        jButton10.setFont(fS);
        jButton10.setFocusPainted(false);
        jButton10.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton10ActionPerformed();
        });

        jButton11.setPreferredSize(new Dimension(400, 50));
        jButton11.setBackground(new Color(225, 225, 225));
        jButton11.setFont(fS);
        jButton11.setFocusPainted(false);
        jButton11.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton11ActionPerformed();
        });

        jButton12.setPreferredSize(new Dimension(400, 50));
        jButton12.setBackground(new Color(225, 225, 225));
        jButton12.setFont(fS);
        jButton12.setFocusPainted(false);
        jButton12.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton12ActionPerformed();
        });
        
        jButton13.setPreferredSize(new Dimension(400, 50));
        jButton13.setBackground(new Color(225, 225, 225));
        jButton13.setFont(fS);
        jButton13.setFocusPainted(false);
        jButton13.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton13ActionPerformed();
        });

        jButtonSChDir.setBackground(new Color(225, 225, 225));
        jButtonSChDir.setFont(fS);
        jButtonSChDir.setFocusPainted(false);
        jButtonSChDir.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButtonSChDirActionPerformed();
        });
        
        jButtonSChCol.setBackground(new Color(225, 225, 225));
        jButtonSChCol.setFont(fS);
        jButtonSChCol.setFocusPainted(false);
        jButtonSChCol.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButtonSChColActionPerformed();
        });
        
        jButtonSSetCol.setBackground(new Color(225, 225, 225));
        jButtonSSetCol.setFont(fS);
        jButtonSSetCol.setFocusPainted(false);
        jButtonSSetCol.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButtonSSetColActionPerformed();
        });

        jButtonH1.setBackground(new Color(225, 225, 225));
        jButtonH1.setFont(fS);
        jButtonH1.setFocusPainted(false);
        jButtonH1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButtonH1ActionPerformed();
        });

        jButtonH2.setBackground(new Color(225, 225, 225));
        jButtonH2.setFont(fS);
        jButtonH2.setFocusPainted(false);
        jButtonH2.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButtonH2ActionPerformed();
        });
        
        jButtonH3.setBackground(new Color(225, 225, 225));
        jButtonH3.setFont(fS);
        jButtonH3.setFocusPainted(false);
        jButtonH3.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButtonH3ActionPerformed();
        });
        
        jButtonH.setBackground(new Color(225, 225, 225));
        jButtonH.setFont(fS);
        jButtonH.setFocusPainted(false);
        jButtonH.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButtonHActionPerformed();
        });

        jComboBox1.setPreferredSize(dS);
        jComboBox1.setFont(fS);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"  Scannen nach Gelb",
                "  Scannen nach Schwarz", "  Benutzerdefinierte Farbe"}));
        jComboBox1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jComboBox1ActionPerformed(evt);
        });

        jComboBox2.setPreferredSize(dS);
        jComboBox2.setFont(fS);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"  Absolute Größe",
            "  Relative Größe", "  Wachstumsgeschwindigkeit", "  Relativer Wachstumszuwachs"}));
        jComboBox2.addActionListener((java.awt.event.ActionEvent evt) -> {
            jComboBox2ActionPerformed(evt);
        });

        jLabel1.setFont(fS);
        jLabel2.setFont(fS);
        jLabel3.setFont(fS);
        jLabel4.setFont(fS);
        jLabel5.setFont(fS);
        jLabel6.setFont(fS);
        jLabel7.setFont(fS);

        jProgressBar1.setPreferredSize(dS);
        jProgressBar1.setFont(fS);
        jProgressBar1.setMinimum(0);
        jProgressBar1.setStringPainted(true);

        jRadioButton1.setFont(fS);
        jRadioButton1.setFocusPainted(false);
        
        jRadioButton2.setFont(fS);
        jRadioButton2.setFocusPainted(false);
        
        jRadioButtonR1.setFont(fS);
        jRadioButtonR1.setFocusPainted(false);
        jRadioButtonR2.setFont(fS);
        jRadioButtonR2.setFocusPainted(false);
        
        jRadioButtonR3.setFont(fS);
        jRadioButtonR3.setFocusPainted(false);
        
        jRadioButtonG1.setFont(fS);
        jRadioButtonG1.setFocusPainted(false);
        
        jRadioButtonG2.setFont(fS);
        jRadioButtonG2.setFocusPainted(false);
        
        jRadioButtonG3.setFont(fS);
        jRadioButtonG3.setFocusPainted(false);
        
        jRadioButtonB1.setFont(fS);
        jRadioButtonB1.setFocusPainted(false);
        
        jRadioButtonB2.setFont(fS);
        jRadioButtonB2.setFocusPainted(false);
        
        jRadioButtonB3.setFont(fS);
        jRadioButtonB3.setFocusPainted(false);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(jRadioButton1);
        group1.add(jRadioButton2);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(jRadioButtonR1);
        group2.add(jRadioButtonR2);
        group2.add(jRadioButtonR3);
        
        ButtonGroup group3 = new ButtonGroup();
        group3.add(jRadioButtonG1);
        group3.add(jRadioButtonG2);
        group3.add(jRadioButtonG3);
        
        ButtonGroup group4 = new ButtonGroup();
        group4.add(jRadioButtonB1);
        group4.add(jRadioButtonB2);
        group4.add(jRadioButtonB3);
        

        jTextField1.setEditable(false);
        jTextField1.setBackground(new Color(240, 240, 240));
        jTextField1.setPreferredSize(dS);
        jTextField1.setFont(fS);

        jTextField1c.setEditable(false);
        jTextField1c.setBackground(new Color(240, 240, 240));
        jTextField1c.setPreferredSize(dS);
        jTextField1c.setFont(fS);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new Color(240, 240, 240));
        jTextField2.setPreferredSize(dS);
        jTextField2.setFont(fS);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new Color(240, 240, 240));
        jTextField3.setPreferredSize(dS);
        jTextField3.setFont(fS);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new Color(240, 240, 240));
        jTextField4.setPreferredSize(dS);
        jTextField4.setFont(fS);

        jTextField4c.setEditable(false);
        jTextField4c.setBackground(new Color(240, 240, 240));
        jTextField4c.setPreferredSize(dS);
        jTextField4c.setFont(fS);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new Color(240, 240, 240));
        jTextField5.setPreferredSize(dS);
        jTextField5.setFont(fS);

        jTextField5c.setEditable(false);
        jTextField5c.setBackground(new Color(240, 240, 240));
        jTextField5c.setPreferredSize(dS);
        jTextField5c.setFont(fS);

        jTextField6.setBackground(cWh);
        jTextField6.setPreferredSize(dS);
        jTextField6.setFont(fS);
        jTextField6.setText("Tag");
        jTextField6.setForeground(cGre);
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained();
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost();
            }
        });

        jTextField7.setBackground(cWh);
        jTextField7.setPreferredSize(dS);
        jTextField7.setFont(fS);
        jTextField7.setForeground(cGre);
        jTextField7.setText("Monat");
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained();
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost();
            }
        });

        jTextField8.setBackground(cWh);
        jTextField8.setPreferredSize(dS);
        jTextField8.setFont(fS);
        jTextField8.setForeground(cGre);
        jTextField8.setText("Jahr");
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField8FocusGained();
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost();
            }
        });

        jTextField9.setBackground(cWh);
        jTextField9.setPreferredSize(dS);
        jTextField9.setFont(fS);
        jTextField9.setForeground(cGre);
        jTextField9.setText("Uhrzeit");
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained();
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost();
            }
        });

        jTextField10.setEditable(false);
        jTextField10.setBackground(cWh);
        jTextField10.setPreferredSize(dS);
        jTextField10.setFont(fS);
        jTextField10.setForeground(cGre);
        jTextField10.setText("Dateiname");
        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField10FocusGained();
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField10FocusLost();
            }
        });

        jTextField11.setBackground(cWh);
        jTextField11.setPreferredSize(dS);
        jTextField11.setFont(fS);
        jTextField11.setForeground(cGre);
        jTextField11.setText("Dateiname");
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained();
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost();
            }
        });

        jTextField12.setBackground(cWh);
        jTextField12.setPreferredSize(dS);
        jTextField12.setFont(fS);
        jTextField12.setForeground(cGre);
        jTextField12.setText("Dateiname");
        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField12FocusGained();
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField12FocusLost();
            }
        });

        jTextFieldSDir.setBackground(cBg);
        jTextFieldSDir.setPreferredSize(dS);
        jTextFieldSDir.setFont(fS);
        jTextFieldSDir.setEditable(false);
        jTextFieldSDir.setText("C/blabliblu/test1");
        
        jTextFieldSR1.setPreferredSize(new Dimension(50, 50));
        jTextFieldSR1.setFont(fS);
        jTextFieldSR1.setText("0");
        
        jTextFieldSR2.setPreferredSize(new Dimension(50, 50));
        jTextFieldSR2.setFont(fS);
        jTextFieldSR2.setText("0");
        
        jTextFieldSG1.setPreferredSize(new Dimension(50, 50));
        jTextFieldSG1.setFont(fS);
        jTextFieldSG1.setText("0");
        
        jTextFieldSG2.setPreferredSize(new Dimension(50, 50));
        jTextFieldSG2.setFont(fS);
        jTextFieldSG2.setText("0");
        
        jTextFieldSB1.setPreferredSize(new Dimension(50, 50));
        jTextFieldSB1.setFont(fS);
        jTextFieldSB1.setText("0");
        
        jTextFieldSB2.setPreferredSize(new Dimension(50, 50));
        jTextFieldSB2.setFont(fS);
        jTextFieldSB2.setText("0");

        JLabel jLabelS1 = new JLabel("Ergebnisse speichern");
        JLabel jLabelS2 = new JLabel("Dateipfad");
        JLabel jLabelS3 = new JLabel("Flexible Farbe");
        JLabel jLabelSR = new JLabel("R");
        JLabel jLabelSG = new JLabel("G");
        JLabel jLabelSB = new JLabel("B");

        jTabbedPane1.addTab("Scannen", jPanel1);
        jTabbedPane1.addTab("Speichern", jPanel2);
        jTabbedPane1.addTab("Öffnen", jPanel3);
        jTabbedPane1.addTab("Auswerten", jPanel4);
        jTabbedPane1.addTab("Einstellungen", jPanel5);

        jTabbedPane1.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeFont();
            }
            @Override
            public void componentMoved(ComponentEvent e) {
            }
            @Override
            public void componentShown(ComponentEvent e) {
            }
            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
        
        jTabbedPane1.addChangeListener((ChangeEvent e) -> {
            if(jTabbedPane1.getSelectedIndex() == 4){
                gSaveS = true;
            }else{
                if(gSaveS){
                    try {
                        saveS();
                        gSaveS = false;
                    } catch (IOException ex) {
                        jTextArea1.setText("Die Einstellungen konnten nicht übernommen werden.");
                    }
                }
            }
        });

        jPanel1.setLayout(GBL);
        c.insets = new Insets(20, 20, 5, 20);
        c.gridheight = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.weightx = 0.9;
        c.weighty = 0.9;
        jPanel1.add(jButton1, c);
        c.insets = new Insets(5, 20, 5, 20);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        jPanel1.add(jButton11, c);
        c.gridx = 1;
        c.gridy = 2;
        jPanel1.add(jComboBox1, c);
        c.insets = new Insets(15, 15, 15, 15);
        c.gridx = 0;
        c.gridy = 3;
        jPanel1.add(jLabel1, c);
        c.gridx = 1;
        jPanel1.add(jTextField1, c);
        c.gridx = 0;
        c.gridy = 4;
        jPanel1.add(jLabel2, c);
        c.gridx = 1;
        jPanel1.add(jTextField2, c);
        c.gridx = 0;
        c.gridy = 5;
        jPanel1.add(jLabel3, c);
        c.gridx = 1;
        jPanel1.add(jTextField3, c);
        c.gridx = 0;
        c.gridy = 6;
        jPanel1.add(jLabel4, c);
        c.gridx = 1;
        jPanel1.add(jTextField4, c);
        c.gridx = 0;
        c.gridy = 7;
        jPanel1.add(jLabel5, c);
        c.gridx = 1;
        jPanel1.add(jTextField5, c);
        c.gridx = 0;
        c.gridy = 8;
        jPanel1.add(jButton2, c);
        c.gridx = 1;
        jPanel1.add(jButton3, c);

        jPanel2.setLayout(GBL);
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 1;
        jPanel2.add(jLabel6, c);
        c.gridx = 1;
        c.gridwidth = 3;
        jPanel2.add(jTextField1c, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        jPanel2.add(jLabel7, c);
        c.gridwidth = 3;
        c.gridx = 1;
        jPanel2.add(jTextField5c, c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 4;
        jPanel2.add(jButton2c, c);
        c.gridy = 4;
        jPanel2.add(jButton3c, c);
        c.gridy = 5;
        c.gridwidth = 1;
        jPanel2.add(jTextField6, c);
        c.gridx = 1;
        jPanel2.add(jTextField7, c);
        c.gridx = 2;
        jPanel2.add(jTextField8, c);
        c.gridx = 3;
        jPanel2.add(jTextField9, c);
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 4;
        jPanel2.add(jTextField10, c);
        c.gridy = 7;
        c.insets = new Insets(15, 15, 72, 15);
        jPanel2.add(jButton4, c);

        jPanel3.setLayout(GBL);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(15, 15, 15, 15);
        jPanel3.add(jTextField11, c);
        c.gridy = 1;
        c.insets = new Insets(5, 15, 5, 15);
        jPanel3.add(jButton5, c);
        c.gridy = 2;
        c.insets = new Insets(35, 15, 425, 15);
        jPanel3.add(jButton6, c);

        jPanel4.setLayout(GBL);
        c.insets = new Insets(15, 15, 15, 15);
        c.gridy = 0;
        c.gridwidth = 2;
        jPanel4.add(jTextField12, c);
        c.gridy = 1;
        jPanel4.add(jComboBox2, c);
        c.gridy = 2;
        jPanel4.add(jButton7, c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        jPanel4.add(jButton12, c);
        c.gridx = 1;
        jPanel4.add(jButton8, c);
        c.gridx = 0;
        c.gridy = 4;
        jPanel4.add(jButton9, c);
        c.gridx = 1;
        jPanel4.add(jButton10, c);
        c.gridx = 0;
        c.gridy = 5;
        jPanel4.add(jButton13, c);

        jPanel5.setLayout(GBL);
        c.insets = new Insets(15, 15, 15, 15);
        c.gridx = 0;
        c.gridy = 0;
        jPanel5.add(jLabelS1, c);
        c.gridx = 1;
        jPanel5.add(jRadioButton1, c);
        c.gridx = 2;
        jPanel5.add(jRadioButton2, c);
        c.gridx = 6;
        jPanel5.add(jButtonH1, c);
        c.gridx = 0;
        c.gridy = 1;
        jPanel5.add(jLabelS2, c);
        c.gridx = 1;
        c.gridwidth = 4;
        jPanel5.add(jTextFieldSDir, c);
        c.gridx = 5;
        c.gridwidth = 1;
        jPanel5.add(jButtonSChDir, c);
        c.gridx = 6;
        jPanel5.add(jButtonH2, c);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(5, 15, 5, 15);
        jPanel5.add(jLabelS3, c);
        c.gridx = 1;
        jPanel5.add(jLabelSR, c);
        c.gridx = 2;
        jPanel5.add(jTextFieldSR1, c);       
        c.gridx = 3;
        jPanel5.add(jRadioButtonR1, c);
        c.gridx = 4;
        jPanel5.add(jTextFieldSR2, c);
        c.gridx = 5;
        jPanel5.add(jRadioButtonR2, c);
        c.gridx = 6;
        jPanel5.add(jRadioButtonR3, c);
        c.gridx = 1;
        c.gridy = 3;
        jPanel5.add(jLabelSG, c);
        c.gridx = 2;
        jPanel5.add(jTextFieldSG1, c);
        c.gridx = 3;
        jPanel5.add(jRadioButtonG1, c);
        c.gridx = 4;
        jPanel5.add(jTextFieldSG2, c);
        c.gridx = 5;
        jPanel5.add(jRadioButtonG2, c);
        c.gridx = 6;
        jPanel5.add(jRadioButtonG3, c);
        c.gridx = 1;
        c.gridy = 4;
        jPanel5.add(jLabelSB, c);
        c.gridx = 2;
        jPanel5.add(jTextFieldSB1, c);
        c.gridx = 3;
        jPanel5.add(jRadioButtonB1, c);
        c.gridx = 4;
        jPanel5.add(jTextFieldSB2, c);
        c.gridx = 5;
        jPanel5.add(jRadioButtonB2, c);
        c.gridx = 6;
        jPanel5.add(jRadioButtonB3, c);
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 5;
        jPanel5.add(jButtonSChCol, c);
        c.gridx = 6;
        c.gridwidth = 1;
        jPanel5.add(jButtonH3, c);
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 7;
        c.insets = new Insets(45, 15, 15, 15);
        jPanel5.add(jButtonH, c);

        jFrame.setVisible(true);
    }   // erstellt das GUI

    private static void jButton1ActionPerformed() {
        if (!gBusy) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Bilder: *.jpg, *.jpeg, *.png, *.gif", "gif", "png", "jpg", "jpeg");
            chooser.setFileFilter(filter);
            chooser.setPreferredSize(new Dimension(1000, jPanel1.getHeight()));
            if (chooser.showOpenDialog(jFrame) == JFileChooser.APPROVE_OPTION) {
                gImgPath = chooser.getSelectedFile().getAbsolutePath().replace("\\", "/");
                jTextField1.setText(chooser.getSelectedFile().getName());
                jTextField1c.setText(chooser.getSelectedFile().getName());
                new Thread(scan).start();
            }
        } else {
            jTextArea1.setText("Das Programm scannt gerade schon eine Datei.");
        }
    }   //ActionPerformed Methoden, die von ActionListener aufgerufen werden | Methoden für Drücken der Buttons

    private static void jButton2ActionPerformed() {
        if (gScan) {
            JFrame jFrame2 = new JFrame();
            jFrame2.setTitle("Original Bild");
            jFrame2.setIconImage(gIcon);

            JLabel jLabel = new JLabel();
            jLabel.setVerticalAlignment(JLabel.TOP);
            jLabel.setHorizontalAlignment(JLabel.LEFT);
            if (gMaxY >= gMaxX) {
                gFactor = jTextArea1.getHeight() * 1.0 / gMaxY;
            } else {
                gFactor = jTextArea1.getHeight() * 1.0 / gMaxX;
            }
            gFactor = 800.0 / gMaxY;
            jFrame2.add(jLabel);
            jFrame2.setVisible(true);

            try {
                BufferedImage sImage = scale(gBuImg, gFactor);
                ImageIcon imgIc = new ImageIcon(sImage);
                jLabel.setIcon(imgIc);
                jFrame2.pack();
            } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jTextArea1.setText("Es wurde noch keine Datei gescannt.");
        }
    }

    private static void jButton3ActionPerformed() {
        if (gScan) {
            JFrame jFrame3 = new JFrame();
            jFrame3.setTitle("Gescanntes Bild");
            jFrame3.setIconImage(gIcon);

            JLabel jLabel3 = new JLabel();
            jLabel3.setVerticalAlignment(JLabel.TOP);
            jLabel3.setHorizontalAlignment(JLabel.LEFT);

            jFrame3.add(jLabel3);
            jFrame3.setVisible(true);

            try {
                if (gMaxY <= gMaxX) {
                    gFactor = jTextArea1.getHeight() * 1.0 / gMaxY;
                } else {
                    gFactor = jTextArea1.getHeight() * 1.0 / gMaxX;
                }
                gFactor = 1000.0 / gMaxY; 
                BufferedImage sImage = scale(gBuImg2, gFactor);
                ImageIcon imgIc = new ImageIcon(sImage);
                jLabel3.setIcon(imgIc);
                jFrame3.pack();
            } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jTextArea1.setText("Es wurde noch keine Datei gescannt.");
        }
    }

    private static void jButton4ActionPerformed() {
        if (gScan) {
            String name = jTextField10.getText();
            if ("".equals(name) || "projects.txt".equals(name) || "projects2.txt".equals(name) || "average".equals(name)) {
                jTextArea1.setText("Ungültiger Dateiname!");
            } else {
                try {
                    addPrToList(gSysDir + "/projects.txt", name);
                    save(name, jTextField6.getText(), jTextField7.getText(), jTextField8.getText(), jTextField9.getText(), gMaxX, gMaxY, gPix);
                    jTextArea1.setText("Scann in Datei " + jTextField10.getText() + " gespeichert.");
                } catch (IOException ex) {
                    Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            jTextArea1.setText("Es wurde noch keine Datei gescannt.");
        }
    }

    private static void jButton5ActionPerformed() {
        if ("projects.txt".equals(jTextField11.getText()) || "".equals(jTextField11.getText())) {
            jTextArea1.setText("Ungültiger Dateiname!");
        } else {
            try {
                if (!inList(gSysDir + "/projects.txt", jTextField11.getText())) {
                    jTextArea1.setText("Lokale Datei nicht gefunden. \nGegebenenfalls die Datei manuell öffnen.");
                } else {
                    try {
                        showPr(gDir + "/" + jTextField11.getText(), jTextField11.getText());
                    } catch (IOException ex) {
                        jTextArea1.setText("Die Datei konnte nicht geöffnet werden.");
                    }
                }
            } catch (IOException ex) {
                jTextArea1.setText("Die Datei konnte nicht geöffnet werden.");
            }
        }
    }

    private static void jButton6ActionPerformed() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Textdatei",
                "txt");
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setPreferredSize(new Dimension(900, 900));

        if (chooser.showOpenDialog(jFrame) == JFileChooser.APPROVE_OPTION) {
            try {
                showPr(chooser.getSelectedFile().getAbsolutePath(), chooser.getSelectedFile().getName());
                try{
                    writePr(chooser.getSelectedFile().getAbsolutePath());
                }catch (IOException ex){
                    System.out.println(ex);
                }

            } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void jButton7ActionPerformed() {
        try {
            gAvPr[gSerie] = jTextField12.getText();
            switch (gSerie) {
                case 0:
                    Chart.add(jTextField12.getText(), gSeries1);
                    gSerie++;
                    break;
                case 1:
                    Chart.add(jTextField12.getText(), gSeries2);
                    gSerie++;
                    break;
                case 2:
                    Chart.add(jTextField12.getText(), gSeries3);
                    gSerie++;
                    break;
                case 3:
                    Chart.add(jTextField12.getText(), gSeries4);
                    gSerie++;
                    break;
                case 4:
                    Chart.add(jTextField12.getText(), gSeries5);
                    gSerie++;
                    break;
                case 5:
                    Chart.add(jTextField12.getText(), gSeries6);
                    gSerie++;
                    break;
                case 6:
                    Chart.add(jTextField12.getText(), gSeries7);
                    gSerie++;
                    break;
                case 7:
                    Chart.add(jTextField12.getText(), gSeries8);
                    gSerie++;
                    break;
                case 8:
                    Chart.add(jTextField12.getText(), gSeries9);
                    gSerie++;
                    break;
                case 9:
                    Chart.add(jTextField12.getText(), gSeries10);
                    gSerie++;
                    break;
                default:
                    jTextArea1.setText("Maximale Anzahl an Schleimpilzen erreicht.");
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void jButton8ActionPerformed() {
        Chart.delete();
        Chart.deleteAv();
        jTextArea1.setText("Das Chart wurde gelöscht.");
    }

    private static void jButton9ActionPerformed() {
        Chart.create();
    }

    private static void jButton10ActionPerformed() {
        Chart.saveD();
    }

    private static void jButton11ActionPerformed() {
        if (gBusy) {
            jTextArea1.setText("Das Programm scannt gerade schon eine Datei.");
        } else if (gScan) {
            new Thread(scan).start();
        } else {
            jTextArea1.setText("Es wurde noch keine Datei gescannt.");
        }
    }

    private static void jButton12ActionPerformed() {
        Chart.deleteL();
    }
    
    private static void jButton13ActionPerformed() {
        try {
            String name = jTextField12.getText();
            Chart.average(gAvPr, name);
            if(!inList(gSysDir + "/projects.txt", name)) {
                addPrToList(gSysDir + "/projects.txt", name);
            }
            jTextArea1.setText("Der Durchschnitt wurde erfolgreich erstellt und in der Datei " + name + " gespeichert.");
        } catch (IOException ex) {
            jTextArea1.setText("Es konnte kein Durchschnitt erstellt werden.");
        }
    }

    private static void jButtonSChDirActionPerformed() {
        JFileChooser cf = new JFileChooser();
        cf.setDialogTitle("Dateipfad auswählen");
        cf.setPreferredSize(new Dimension(1000, jPanel1.getHeight()));
        cf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (cf.showOpenDialog(jFrame) == JFileChooser.APPROVE_OPTION) {
            gDir = cf.getSelectedFile().getAbsolutePath().replace("\\", "/");
            jTextFieldSDir.setText(gDir);
        }

    }
    
    private static void jButtonSChColActionPerformed() {
        jFrameCol = new JFrame();
        Dimension d = new Dimension(800, 800);
        jFrameCol.setSize(d);
        jFrameCol.setMinimumSize(d);
        jFrameCol.setIconImage(gIcon);
        
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        jCC.setColor(gC);
        AbstractColorChooserPanel[] panels = jCC.getChooserPanels();
        for(AbstractColorChooserPanel p:panels){
            String displayName=p.getDisplayName();
            switch (displayName) {
                case "HSV":
                    jCC.removeChooserPanel(p);
                    break;
                case "CMYK":
                    jCC.removeChooserPanel(p);
                    break;
                case "Swatches":
                    jCC.removeChooserPanel(p);
                    break;
            }
        }
        
        c.gridx = 0;
        c.gridy = 0;
        jPanel.add(jCC, c);
        c.gridy = 1;
        jPanel.add(jButtonSSetCol, c);
        jFrameCol.add(jPanel);
        
        jFrameCol.setVisible(true);
    }
    
    private static void jButtonSSetColActionPerformed() {
        gC = jCC.getColor();
        jTextFieldSR1.setText(String.valueOf(gC.getRed()));
        jTextFieldSG1.setText(String.valueOf(gC.getGreen()));
        jTextFieldSB1.setText(String.valueOf(gC.getBlue()));
        jFrameCol.dispose();
    }
    
    private static void jButtonHActionPerformed() {
        jTextArea1.setText("Hier ist die Hilfe zur Benutzung des Programmes.");
    }

    private static void jButtonH1ActionPerformed() {
        jTextArea1.setText("Hier ist die Hilfe der 1. Einstellung.");
    }

    private static void jButtonH2ActionPerformed() {
        jTextArea1.setText("Hier ist die Hilfe der 2. Einstellung.");
    }
    
    private static void jButtonH3ActionPerformed() {
        jTextArea1.setText("Hier ist die Hilfe der 3. Einstellung.");
    }

    private static void jTextField6FocusGained() {
        jTextField6.setText("");
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));
    } //ActionMethoden für Textfelder, die Fokus erlangen / verlieren

    private static void jTextField6FocusLost() {
        if ("".equals(jTextField6.getText())) {
            jTextField6.setForeground(new java.awt.Color(150, 150, 150));
            jTextField6.setText("Tag");
        }
    }

    private static void jTextField7FocusGained() {
        jTextField7.setText("");
        jTextField7.setForeground(new java.awt.Color(0, 0, 0));
    }

    private static void jTextField7FocusLost() {
        if ("".equals(jTextField7.getText())) {
            jTextField7.setForeground(new java.awt.Color(150, 150, 150));
            jTextField7.setText("Monat");
        }
    }

    private static void jTextField8FocusGained() {
        jTextField8.setText("");
        jTextField8.setForeground(new java.awt.Color(0, 0, 0));
    }

    private static void jTextField8FocusLost() {
        if ("".equals(jTextField8.getText())) {
            jTextField8.setForeground(new java.awt.Color(150, 150, 150));
            jTextField8.setText("Jahr");
        }
    }

    private static void jTextField9FocusGained() {
        jTextField9.setText("");
        jTextField9.setForeground(new java.awt.Color(0, 0, 0));
    }

    private static void jTextField9FocusLost() {
        if ("".equals(jTextField9.getText())) {
            jTextField9.setForeground(new java.awt.Color(150, 150, 150));
            jTextField9.setText("Uhrzeit");
        }
    }

    private static void jTextField10FocusGained() {
        if (gScan) {
            jTextField10.setText("");
            jTextField10.setForeground(new java.awt.Color(0, 0, 0));
            try {
                showPrList();
            } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jTextArea1.setText("Es wurde noch kein Datei gescannt.");
        }
    }

    private static void jTextField10FocusLost() {
        if ("".equals(jTextField10.getText())) {
            jTextField10.setForeground(new java.awt.Color(150, 150, 150));
            jTextField10.setText("Vollständiger Dateiname");
        }
    }

    private static void jTextField11FocusGained() {
        jTextField11.setText("");
        jTextField11.setForeground(new java.awt.Color(0, 0, 0));
        try {
            showPrList();
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void jTextField11FocusLost() {
        if ("".equals(jTextField11.getText())) {
            jTextField11.setForeground(new java.awt.Color(150, 150, 150));
            jTextField11.setText("Vollständiger Dateiname");
        }
    }

    private static void jTextField12FocusGained() {
        jTextField12.setText("");
        jTextField12.setForeground(new java.awt.Color(0, 0, 0));
        try {
            showPrList();
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void jTextField12FocusLost() {
        if ("".equals(jTextField12.getText())) {
            jTextField12.setForeground(new java.awt.Color(150, 150, 150));
            jTextField12.setText("Vollständiger Dateiname");
        }
    }

    private static void jComboBox1ActionPerformed(ActionEvent evt) {
        javax.swing.JComboBox cb = (javax.swing.JComboBox) evt.getSource();
        gScCol = cb.getSelectedIndex();
    }   // Auswahl an den jComboBoxen

    private static void jComboBox2ActionPerformed(ActionEvent evt) {
        javax.swing.JComboBox cb = (javax.swing.JComboBox) evt.getSource();
        if (gSerie == 0) {
            gDia = cb.getSelectedIndex();
        } else {
            jComboBox2.setSelectedIndex(gDia);
            jTextArea1.setText("Die Änderung konnte nicht übernommen werden, da bereits Projekte zum Chart hinzugefügt wurden. "
                    + "Nachdem Sie das Chart gelöscht haben, versuchen Sie es erneut.");
        }
    }

    private static void scan() throws IOException {                // Kopf der Methode
        gBusy = true;       // Variable gibt an, ob Programm beschäftigt ist, verhindert gleichzeitiges Laden von unterschiedlichen Bildern
        gBuImg = ImageIO.read(new File(gImgPath));  // Bild wird mit der Methode aus dem Paket ImageIO gelesen
        try {   // Testet ob die Datei gescannt werden kann
            gBuImg.getHeight();
            gBuImg.getRGB(0, 0);
        } catch (java.lang.NullPointerException ex) {   // Bricht ggf. die Methode ab und gibt Fehlermeldung
            jTextArea1.setText("Der Dateityp der ausgewählten Datei wird nicht unterstützt.");
            gBusy = false;
            return;
        }
        jTextArea1.setText("Die ausgewählte Datei wird gescannt."); // Status wird für Nutzer ausgegeben
        gMaxX = gBuImg.getWidth();  // Breite / Höhe und Auflösung des Bildes wird bestimmt
        gMaxY = gBuImg.getHeight();
        gReso = gMaxX * gMaxY;
        jTextField2.setText(gMaxX + "x" + gMaxY);   // Informationen werden ausgegeben
        jTextField3.setText("" + gMaxX * gMaxY);
        gPix = 0;       // Anzahl der positiven Pixel wird auf 0 gesetzt
        gBuImg2 = new BufferedImage(gMaxX, gMaxY, 1);   // Neues Bild mit identischen Maßen wird erstellt
        c.gridx = 0;    // jProgressBar wird an Postion 0|0 hinzugefügt
        c.gridy = 0;
        c.gridwidth = 2;
        jProgressBar1.setMaximum(gMaxX);    // Maximalwert des Balkens ist die Breite des Bildes
        c.insets = new Insets(10, 20, 0, 20);
        jPanel1.add(jProgressBar1, c);
        jPanel1.updateUI();
        for (int x = 0; x < gMaxX; x++) {   // For-Schleife für alle Pixel der X-Achse bzw. Y-Achse
            for (int y = 0; y < gMaxY; y++) {
                switch (gScCol) {   // Pixel wird auf vorher festgelegten Farbton untersucht
                    case 0:
                        if (testYe2(new Color(gBuImg.getRGB(x, y)))) { // Falls Pixel im Farbton liegt:
                            gPix++;     // Anzahl der postiveb Pixel wird erhöht
                            gBuImg2.setRGB(x, y, -1);   // Pixel des 2. Bild wird an dieser Position weiß gefärbt
                        } else {
                            gBuImg2.setRGB(x, y, 0);    // sonst: Pixel des 2. Bild wird an dieser Position schwarz gefärbt
                        }
                        break;
                    case 1:
                        if (testBl(new Color(gBuImg.getRGB(x, y)))) {
                            gPix++;
                            gBuImg2.setRGB(x, y, -1);
                        } else {
                            gBuImg2.setRGB(x, y, 0);
                        }
                        break;
                    case 2:
                        if (testCus(new Color(gBuImg.getRGB(x, y)))) {
                            gPix++;
                            gBuImg2.setRGB(x, y, -1);
                        } else {
                            gBuImg2.setRGB(x, y, 0);
                        }
                        break;
                }
            }
            jProgressBar1.setValue(x + 1); // ProgressBar bekommt nachdem y Höhe des Bildes erreicht Wert von x + 1 und wird somit gefüllt
        }
        jPanel1.remove(jProgressBar1); // jPB wird entfernt
        jPanel1.updateUI();
        double percent = gPix * 1.0 / gReso * 100;  //Prozentualer Anteil der positiven Pixel wird bestimmt
        jTextArea1.setText("Die Datei wurde erfolgreich gescannt.");    // Statusmeldung für Benutzer
        jTextField4.setText("" + gPix); // Ergebnisse werden ausgegeben
        jTextField4c.setText("" + gPix);
        jTextField5.setText(Math.round(percent * 100D) / 100D + "%");
        jTextField5c.setText(Math.round(percent * 100D) / 100D + "%");
        jTextField10.setEditable(true); // Dateiname für Speichern kann nun eingegeben werden
        gScan = true;   // Gibt an, ob schon eine Datei gescannt wurde (wichtig für jButton 11)
        gBusy = false; // Programm ist nicht mehr beschäftigt
    }   // Ausgewähltes Bild wird gescannt, Ergebnisse werden ausgegeben

    private static boolean inList(String list, String string) throws IOException {
        FileReader fr = new FileReader(list);
        BufferedReader br = new BufferedReader(fr);

        String line;
        boolean inList = false;
        while ((line = br.readLine()) != null) {
            if (string.equals(line)) {
                inList = true;
                break;
            }
        }
        return inList;
    }   // Prüft ob angegebener Name in Liste vorhanden ist

    private static boolean testYe(Color co) {
        if (co.getRed() > 210 && co.getGreen() > 210 && co.getBlue() < 100) {
            return true;
        } else if (co.getRed() > 245 && co.getGreen() > 240 && co.getBlue() < 150) {
            return true;
        } else if (co.getRed() > 200 && co.getGreen() > 200 && co.getBlue() < 100) {
            return true;
        } else if (co.getRed() > 180 && co.getGreen() > 180 && co.getBlue() < 50) {
            return true;
        } else if (co.getRed() > 150 && co.getGreen() > 150 && co.getBlue() < 11) {
            return true;
        } else if (co.getRed() > 230 && co.getGreen() > 230 && co.getBlue() < 170) {
            return true;
        } else if (co.getRed() > 240 && co.getGreen() > 240 && co.getBlue() < 180) {
            return true;
        } else if (co.getRed() > 250 && co.getGreen() > 250 && co.getBlue() < 200) {
            return true;
        } else if (co.getRed() < 185 && co.getRed() > 90 && co.getGreen() < 185 && co.getGreen() > 90 && co.getBlue() < 75) {
            return true;
        }

        return false;
    }   // Prüft ob übergebene Farbe in Farbton gelb liegt

    private static boolean testYe2(Color co) {
        int R = co.getRed();
        int G = co.getGreen();
        int B = co.getBlue();

        return (between(90, R, 186) && between(90, G, 186) && B <= 75);
    }   // Prüft ob übergebene Farbe in Farbton gelb liegt

    private static boolean testBl(Color co) {
        int R = co.getRed();
        int G = co.getGreen();
        int B = co.getBlue();

        if (between(90, R, 185) && between(90, G, 185) && B <= 75) {
            return true;
        } else if (between(20, R, G, B, 90)) {
            return true;
        }
        return false;
    }   // Prüft ob übergebene Farbe in Farbton schwarz liegt

    private static boolean testCus(Color co) {
        int R = co.getRed();
        int G = co.getGreen();
        int B = co.getBlue();   
        int r1 = Integer.valueOf(jTextFieldSR1.getText());
        int g1 = Integer.valueOf(jTextFieldSG1.getText());
        int b1 = Integer.valueOf(jTextFieldSB1.getText());
        int r2, g2, b2;
        boolean r = false;
        boolean g = false;
        boolean b = false;
        
        if(jRadioButtonR1.isSelected()){
            r2 =  Integer.valueOf(jTextFieldSR2.getText());
            r = divergence(R, r1, r2);
        }else if(jRadioButtonR2.isSelected()){
            r = R < r1;
        }else{
            r = R > r1;
        }
        
        if(!r){
            return false;
        }
        
        if(jRadioButtonG1.isSelected()){
            g2 =  Integer.valueOf(jTextFieldSG2.getText());
            g = divergence(G, g1, g2);
        }else if(jRadioButtonG2.isSelected()){
            g = G < g1;
        }else{
            g = G > g1;
        }
        
        if(!g){
            return false;
        }
        
        if(jRadioButtonB1.isSelected()){
            b2 =  Integer.valueOf(jTextFieldSB2.getText());
            b = divergence(B, b1, b2);
        }else if(jRadioButtonB2.isSelected()){
            b = B < b1;
        }else{
            b = B > b1;
        }
        return b;
    }   // Prüft ob übergebene Farbe in benutzerdefinierten Farbton liegt

    private static boolean divergence(int num, int mid, int div){
        return between(mid - div, num, mid + div);
    } // Prüft ob Nummer in Bereich des Mittelwert +/- Abweichung liegt

    private static boolean between(int low, int num, int high) {
        return num >= low && num <= high;
    } // Prüft ob Zahl größer/gleich dem kleineren Wert und kleiner/gleich größeren Wert liegt

    private static boolean between(int low, int num, int num2, int high) {
        return num >= low && num <= high && num2 >= low && num2 <= high;
    } // Prüft ob zwei Zahlen größer/gleich dem kleineren Wert und kleiner/gleich größeren Wert liegen

    private static boolean between(int low, int num, int num2, int num3, int high) {
        return num >= low && num <= high && num2 >= low && num2 <= high && num3 >= low && num3 <= high;
    } // Prüft ob drei Zahlen größer/gleich dem kleineren Wert und kleiner/gleich größeren Wert liegen

    private static BufferedImage scale(BufferedImage img, double factor) throws IOException {
        int scaledWidth = (int) (img.getWidth() * factor);
        int scaledHeight = (int) (img.getHeight() * factor);
        return (scale(img, scaledWidth, scaledHeight));
    } // Skaliert ein Bild um den Angegebenen Faktor

    private static BufferedImage scale(BufferedImage img, int scaledWidth, int scaledHeight) throws IOException {
        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, img.getType());
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(img, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
        return (outputImage);
    } // Skaliert ein Bild auf angegebene Werte

    private static void save(String project, String day, String month, String year, String time, int maxX, int maxY, int pix) throws IOException {
        FileWriter fw = new FileWriter(project, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(day);
        bw.newLine();
        bw.write(month);
        bw.newLine();
        bw.write(year);
        bw.newLine();
        bw.write(time);
        bw.newLine();
        bw.write(String.valueOf(maxX));
        bw.newLine();
        bw.write(String.valueOf(maxY));
        bw.newLine();
        bw.write(String.valueOf(pix));
        bw.newLine();
        bw.write(Math.round(pix * 1.0 / (maxX * maxY) * 100 * 100D) / 100D + "");
        bw.newLine();
        bw.close();
    }   // Speichert Ergebnisse in angegebener Datei

    private static void showPr(String dir, String prName) throws IOException {
        FileReader fr = new FileReader(dir);
        BufferedReader br = new BufferedReader(fr);

        jTextArea1.setText("Projekt " + prName + "\n");
        jTextArea1.append("-------------------------------\n");
        String line;
        while ((line = br.readLine()) != null) {
            jTextArea1.append("Datum: " + line + "." + br.readLine() + "." + br.readLine() + "\n");
            jTextArea1.append("Uhrzeit: " + br.readLine() + "\n");
            jTextArea1.append("Auflösung: " + br.readLine() + "x" + br.readLine() + "\n");
            jTextArea1.append("Markierte Pixel absolut: " + br.readLine() + "\n");
            jTextArea1.append("Markierte Pixel relativ: " + br.readLine() + "%\n");
            jTextArea1.append("-------------------------------\n");
        }
    } // Gibt angegebenes Projekt in TextArea aus

    private static void addPrToList(String list, String name) throws IOException {
        FileWriter fw2 = new FileWriter(list, true);
        BufferedWriter bw2 = new BufferedWriter(fw2);
        if (!inList(list, name)) {
            bw2.write(name);
            bw2.newLine();
        }
        bw2.close();
    }   // Fügt Projekt zur Liste hinzu

    private static void showPrList() throws IOException {
        FileReader fr = new FileReader(gSysDir + "/projects.txt");
        BufferedReader br = new BufferedReader(fr);

        jTextArea1.setText("Vorhandene Projekte: \n");
        String line;
        while ((line = br.readLine()) != null) {
            jTextArea1.append(line + "\n");
        }
    }   // Gibt die Projektliste in der TextArea

    private static void resizeFont() {
        int size;
        int XSize = (int) Math.round(jPanel1.getWidth() / 51.0 + 8 + 1.0 / 3.0);
        int YSize = (int) Math.round(jPanel1.getHeight() / 12.0 - 37.5);
        if (XSize >= YSize) {
            size = YSize;
        } else {
            size = XSize;
        }
        Font f = new Font("Tahoma", 0, size);
        //jSplitPanel1
        jTextArea1.setFont(new Font("Monospaced", 0, size + 10));
        jTabbedPane1.setFont(f);
        //jPanel1
        jButton1.setFont(f);
        jButton2.setFont(f);
        jButton3.setFont(f);
        jButton11.setFont(f);
        jComboBox1.setFont(f);
        jLabel1.setFont(f);
        jLabel2.setFont(f);
        jLabel3.setFont(f);
        jLabel4.setFont(f);
        jLabel5.setFont(f);
        jProgressBar1.setFont(f);
        jTextField1.setFont(f);
        jTextField2.setFont(f);
        jTextField3.setFont(f);
        jTextField4.setFont(f);
        jTextField5.setFont(f);
        //jPanel2
        jButton2c.setFont(f);
        jButton3c.setFont(f);
        jButton4.setFont(f);
        jLabel6.setFont(f);
        jLabel7.setFont(f);
        jTextField1c.setFont(f);
        jTextField5c.setFont(f);
        jTextField6.setFont(f);
        jTextField7.setFont(f);
        jTextField8.setFont(f);
        jTextField9.setFont(f);
        jTextField10.setFont(f);
        //jPanel13
        jTextField11.setFont(f);
        jButton5.setFont(f);
        jButton6.setFont(f);
        //jPanel4
        jButton7.setFont(f);
        jButton8.setFont(f);
        jButton9.setFont(f);
        jButton10.setFont(f);
        jButton12.setFont(f);
        jComboBox2.setFont(f);
        jTextField12.setFont(f);                
    } // Bestimmt die Schirftgröße anhand der Fenstergröße und legt sie für alle Komponenten fest

    private static void saveS() throws IOException{
        FileWriter fw = new FileWriter(gSysDir + "/settings.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        
        if(jRadioButton1.isSelected()){
            bw.write("1");
        }else{
            bw.write("2");
        }
        bw.newLine();
        bw.write(gDir);
        bw.newLine();
        if(jRadioButtonR1.isSelected()){
            bw.write("1");
        }else if(jRadioButtonR2.isSelected()){
            bw.write("2");
        }else{
            bw.write("3");
        }
        bw.newLine();
        bw.write(jTextFieldSR1.getText());
        bw.newLine();
        bw.write(jTextFieldSR2.getText());
        bw.newLine();
        if(jRadioButtonG1.isSelected()){
            bw.write("1");
        }else if(jRadioButtonG2.isSelected()){
            bw.write("2");
        }else{
            bw.write("3");
        }
        bw.newLine();
        bw.write(jTextFieldSG1.getText());
        bw.newLine();
        bw.write(jTextFieldSG2.getText());
        bw.newLine();
        if(jRadioButtonB1.isSelected()){
            bw.write("1");
        }else if(jRadioButtonB2.isSelected()){
            bw.write("2");
        }else{
            bw.write("3");
        }
        bw.newLine();
        bw.write(jTextFieldSB1.getText());
        bw.newLine();
        bw.write(jTextFieldSB2.getText());   
        bw.newLine();
        bw.close();
    } // Speichert die aktuellen Einstellungen

    private static void loadS() throws IOException{
        FileReader fr = new FileReader(gSysDir + "/settings.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        
        if("1".equals(br.readLine())){
            jRadioButton1.setSelected(true);
        }else{
            jRadioButton2.setSelected(true);
        }
        gDir = br.readLine();
        jTextFieldSDir.setText(gDir);
        if("1".equals(line = br.readLine())){
            jRadioButtonR1.setSelected(true);
        }else if("2".equals(line)){
            jRadioButtonR2.setSelected(true);
        }else{
            jRadioButtonR3.setSelected(true);
        }
        jTextFieldSR1.setText(br.readLine());
        jTextFieldSR2.setText(br.readLine());
        if("1".equals(line = br.readLine())){
            jRadioButtonG1.setSelected(true);
        }else if("2".equals(line)){
            jRadioButtonG2.setSelected(true);
        }else{
            jRadioButtonG3.setSelected(true);
        }
        jTextFieldSG1.setText(br.readLine());
        jTextFieldSG2.setText(br.readLine());
        if("1".equals(line = br.readLine())){
            jRadioButtonB1.setSelected(true);
        }else if("2".equals(line)){
            jRadioButtonB2.setSelected(true);
        }else{
            jRadioButtonB3.setSelected(true);
        }
        jTextFieldSB1.setText(br.readLine());
        jTextFieldSB2.setText(br.readLine());
        br.close();
    }  // Lädt die aktuellen Einstellungen

    private static void setSysFolder(){
        File dir = new File("sys");
        dir.mkdir();
        gSysDir = dir.getAbsolutePath().replace("\\", "/");;
    }   // Legt den Systemordner für das Programm fest

    private static void checkPrList() throws IOException{
        FileReader fr = new FileReader(gSysDir + "/projects.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> list = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            try {
                FileReader fr2 = new FileReader(gDir + "/" + line);
                BufferedReader br2 = new BufferedReader(fr2);
                br2.readLine();
                list.add(line);
            }catch(IOException ex){}
        }

        FileWriter fw = new FileWriter(gSysDir + "/projects.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for(String i : list){
            bw.write(i);
            bw.newLine();
        }
        bw.close();
    } // Prüft ob alle Projekte der Projekteliste öffnen kann

    public static String setName(String name){
        int index = 1;
        while(true){
            try {
                FileReader fr = new FileReader(gDir + "/" + name + index);
                BufferedReader br = new BufferedReader(fr);
                index++;
            } catch (FileNotFoundException e) {
                break;
            }
        }
        return(name + index);
    } // legt den Namen für ein Projekt fest

    public static String getName(String dir){
        int index = dir.length() - 1;
        while(index >= 0){
            if(dir.charAt(index) == '/' || dir.charAt(index) == '\\'){
                return(dir.substring(index + 1));
            }
            index--;
        }
        return(dir);
    }   // gibt den Dateinamen eines Dateipfades aus

    private static void writePr(String dir) throws IOException {
        FileReader fr = new FileReader(dir);
        BufferedReader br = new BufferedReader(fr);
        String nName = setName(getName(dir));
        FileWriter fw = new FileWriter(gDir + "/" + nName);
        BufferedWriter bw = new BufferedWriter(fw);

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
        addPrToList(gSysDir + "/projects.txt", nName);
    } // Schreibt ein vorhandenes Projekt in den Projekteorder ab

    // Globale Variablen Deklaration
    private static JFrame jFrame = new JFrame();                                        // Frame des GUI
    private static JSplitPane jSplitPane1 = new JSplitPane();                           // Geteiltes Panel
    private static JTabbedPane jTabbedPane1 = new JTabbedPane();                        // Registerkarten Panel, linker Teil des Geteilten Panel
    private static JPanel jPanel1 = new JPanel();                                       // Panel 1 -> Scannen
    private static JPanel jPanel2 = new JPanel();                                       // Panel 2 -> Speichern
    private static JPanel jPanel3 = new JPanel();                                       // Panel 3 -> Öffnen
    private static JPanel jPanel4 = new JPanel();                                       // Panel 4 -> Chart
    private static JPanel jPanel5 = new JPanel();                                       // Panel 5 -> Einstellungen
    public static JTextArea jTextArea1 = new JTextArea();                               // Textbereich, rechter Teil des Geteilten Panel
    private static JButton jButton1 = new JButton("Datei auswählen");               // Knöpfe, tragen die angegebene Beschriftung
    private static JButton jButton2 = new JButton("Original Bild anzeigen");
    private static JButton jButton2c = new JButton("Original Bild anzeigen");
    private static JButton jButton3 = new JButton("Gescanntes Bild anzeigen");
    private static JButton jButton3c = new JButton("Gescanntes Bild anzeigen");
    private static JButton jButton4 = new JButton("Speichern");
    private static JButton jButton5 = new JButton("Projekt öffnen");
    private static JButton jButton6 = new JButton("Projekt auswählen");
    private static JButton jButton7 = new JButton("Projekt hinzufügen");
    private static JButton jButton8 = new JButton("Diagramm löschen");
    private static JButton jButton9 = new JButton("Diagramm erstellen");
    private static JButton jButton10 = new JButton("Diagramm speichern");
    private static JButton jButton11 = new JButton("Zuletzt gescannte Datei");
    private static JButton jButton12 = new JButton("Letztes Projekt löschen");
    private static JButton jButton13 = new JButton("Durchschnitt erstellen");
    private static JButton jButtonSChDir = new JButton("Ändern");
    private static JButton jButtonSChCol = new JButton("Farbe auswählen");
    private static JButton jButtonSSetCol = new JButton("Farbe auswählen");
    private static JButton jButtonH = new JButton("Hilfe");
    private static JButton jButtonH1 = new JButton("?");
    private static JButton jButtonH2 = new JButton("?");
    private static JButton jButtonH3 = new JButton("?");
    private static JComboBox jComboBox1 = new JComboBox();                              // Combo-Box für Auswahl Scan-Farbe
    private static JComboBox jComboBox2 = new JComboBox();                              // Combo-Box für Auswahl Diagrammtyp
    private static JLabel jLabel1 = new JLabel(" Ausgewählte Datei");               // Labels, die den angegebenen Namen tragen
    private static JLabel jLabel2 = new JLabel(" Auflösung");
    private static JLabel jLabel3 = new JLabel(" Gesamte Pixel");
    private static JLabel jLabel4 = new JLabel(" Markierte Pixel");
    private static JLabel jLabel5 = new JLabel(" Anteil");
    private static JLabel jLabel6 = new JLabel(" Datei");
    private static JLabel jLabel7 = new JLabel(" Anteil");
    private static JProgressBar jProgressBar1 = new JProgressBar();                     // Fortschrittsbalken fürs Scannen
    private static JRadioButton jRadioButton1 = new JRadioButton("Datenbank");      // Radiobutton für Speicher-Möglichkeit
    private static JRadioButton jRadioButton2 = new JRadioButton("Lokal");
    private static JRadioButton jRadioButtonR1 = new JRadioButton("+/-");           // Radiobuttons für Farbdefinierung
    private static JRadioButton jRadioButtonR2 = new JRadioButton("<");
    private static JRadioButton jRadioButtonR3 = new JRadioButton(">");
    private static JRadioButton jRadioButtonG1 = new JRadioButton("+/-");
    private static JRadioButton jRadioButtonG2 = new JRadioButton("<");
    private static JRadioButton jRadioButtonG3 = new JRadioButton(">");
    private static JRadioButton jRadioButtonB1 = new JRadioButton("+/-");
    private static JRadioButton jRadioButtonB2 = new JRadioButton("<");
    private static JRadioButton jRadioButtonB3 = new JRadioButton(">");
    private static JTextField jTextField1 = new JTextField();                           // Textfelder für Name Ausgewählte Datei
    private static JTextField jTextField1c = new JTextField();                          // Kopie Tf 1
    private static JTextField jTextField2 = new JTextField();                           // Auflösung
    private static JTextField jTextField3 = new JTextField();                           // Gesamte Pixle
    private static JTextField jTextField4 = new JTextField();                           // Markierte Pixel
    private static JTextField jTextField4c = new JTextField();                          // Kopie Tf 4
    private static JTextField jTextField5 = new JTextField();                           // Anteil
    private static JTextField jTextField5c = new JTextField();                          // Kopie Tf 5
    private static JTextField jTextField6 = new JTextField();                           // Tag
    private static JTextField jTextField7 = new JTextField();                           // Monat
    private static JTextField jTextField8 = new JTextField();                           // Jahr
    private static JTextField jTextField9 = new JTextField();                           // Uhrzeit
    private static JTextField jTextField10 = new JTextField();                          // Dateiname Speichern
    private static JTextField jTextField11 = new JTextField();                          // Dateiname Öffnen
    public static JTextField jTextField12 = new JTextField();                          // Dateiname Chart
    private static JTextField jTextFieldSDir = new JTextField();                        // Einstellung Dateipfad
    private static JTextField jTextFieldSR1 = new JTextField();                         // Einstellung Wert Rot
    private static JTextField jTextFieldSR2 = new JTextField();                         // Einstellung Abweichung Rot
    private static JTextField jTextFieldSG1 = new JTextField();                         // Einstellung Wert Grün
    private static JTextField jTextFieldSG2 = new JTextField();                         // Einstellung Abweichung Grün
    private static JTextField jTextFieldSB1 = new JTextField();                         // Einstellung Wert Blau
    private static JTextField jTextFieldSB2 = new JTextField();                         // Einstellung Abweichung Blau

    private static int gPix = 0;                                                        // Pixel, welche auf Farbe zutreffen
    private static int gMaxX;                                                           // Breite des Bildes
    private static int gMaxY;                                                           // Höhe des Bildes
    private static int gReso;                                                           // Auflösung Bild
    public static int gDia = 0;                                                        // Index von ComboBox2, bestimmt Y-Achse des Diagramms
    protected static int gSerie = 0;                                                      // Anzahl der hinzugefügten Projekte des Diagramms
    private static int gScCol = 0;                                                      // Index von ComboBox1, bestimmt Farbe nach der gescannt wird
    private static double gFactor = 1;                                                  // Faktor für Bild Skalierung
    private static boolean gScan = false;                                               // Wahr, wenn schon ein Bild gescannt wurde
    private static boolean gBusy = false;                                               // Wahr, wenn Programm gerade ein Bild scannt
    private static boolean gSaveS = false;                                              // Wahr, wenn Einstellungen gespeichert werden müssen
    private static String gImgPath = "";                                                // Bild Dateipfad
    private static String gSysDir = "";                                                 // Dateipfad zum System Order des Programms
    public static String gDir = "";                                                    // Dateipfad zum Projekte Order
    private static BufferedImage gBuImg;                                                // Original Bild
    private static BufferedImage gBuImg2;                                               // Schwarz-Weiss Bild
    public static Image gIcon;                                                         // Icon des Programms
    private static GridBagConstraints c = new GridBagConstraints();                     // GridBagConstraints Variable des Grid-Bag-Layouts
    private static Color gC = new Color(0, 0, 0);                                // Benutzerdefinierte Farbe
    private static String[] gAvPr = new String[10];                                     // Array der Projekte, für die Durchschnitt berechnet werden muss

    public static XYSeriesCollection gDataset = new XYSeriesCollection();              // Datenset des Digrammen
    public static XYLineAndShapeRenderer gLine = new XYLineAndShapeRenderer();         // Variable für Diagrammtyp
    public static NumberAxis gXax = new NumberAxis("Zeit in Tage");               // X-Achse mit Beschriftung
    public static NumberAxis gYax;                                                     // Y-Achse, Beschriftung erfolgt je nach ausgewählten D-Typ später
    public static XYSeries gSeries1 = new XYSeries("Organismus 1");                // Organismen im Diagramm
    public static XYSeries gSeries2 = new XYSeries("Organismus 2");
    public static XYSeries gSeries3 = new XYSeries("Organismus 3");
    public static XYSeries gSeries4 = new XYSeries("Organismus 4");
    public static XYSeries gSeries5 = new XYSeries("Organismus 5");
    public static XYSeries gSeries6 = new XYSeries("Organismus 6");
    public static XYSeries gSeries7 = new XYSeries("Organismus 7");
    public static XYSeries gSeries8 = new XYSeries("Organismus 8");
    public static XYSeries gSeries9 = new XYSeries("Organismus 9");
    public static XYSeries gSeries10 = new XYSeries("Organismus 10");
    public static JFreeChart gChart;                                                   // Chart
    public static ChartPanel gChartPanel;                                              // Chart Panel

    private static JColorChooser jCC = new JColorChooser();                            // Farbauswahl
    private static JFrame jFrameCol;                                                   // Frame für Farbauswahl

    private static Runnable scan = () -> {
        try {
            scan();
        } catch (IOException ex) {
            jTextArea1.setText("Der Scan konnte nicht gestartet werden.");
        }
    };                                                // Thread Scannen
}
