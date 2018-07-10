package semi;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;

import java.io.*;

public class Chart {
    static void add(String prName, XYSeries series) throws IOException {
        int ys;
        int ms;
        int ds;
        int pixe;
        int pixl;
        int pix;
        int d;
        int m;
        int y;
        int maxX;
        int maxY;
        double perc;
        double tb;
        String ts;
        String t;
        String dir = MainClass.gDir + "/" + prName;

        FileReader fr = new FileReader(dir);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        ds = Integer.valueOf(line);
        ms = Integer.valueOf(br.readLine());
        ys = Integer.valueOf(br.readLine());
        ts = br.readLine();

        br.readLine();
        br.readLine();

        pixe = Integer.valueOf(br.readLine());
        pixl = pixe;
        pix = pixe;
        br.readLine();

        while (br.readLine() != null) {
            for (int i = 0; i < 5; i++) {
                br.readLine();
            }
            pixe = Integer.valueOf(br.readLine());
            br.readLine();
        }

        br.close();
        fr.close();

        FileReader fr2 = new FileReader(dir);
        BufferedReader br2 = new BufferedReader(fr2);

        while ((line = br2.readLine()) != null) {
            pixl = pix;
            d = Integer.valueOf(line);
            m = Integer.valueOf(br2.readLine());
            y = Integer.valueOf(br2.readLine());
            t = br2.readLine();
            maxX = Integer.valueOf(br2.readLine());
            maxY = Integer.valueOf(br2.readLine());

            if (Date.biggerT(ts, t)) {
                if (d == 1 && m == 1) {
                    d = 31;
                    m = 12;
                } else if (d == 1) {
                    d = Date.lenM(y, m - 1);
                    m = m - 1;
                } else {
                    d = d - 1;
                }
                tb = 1 - Date.difT(t, ts);
            } else {
                tb = Date.difT(ts, t);
            }

            pix = Integer.valueOf(br2.readLine());
            perc = Double.valueOf(br2.readLine());

            switch (MainClass.gDia) {
                case 0:
                    series.add(Date.difD(ys, ms, ds, y, m, d) + tb, pix);
                    break;
                case 1:
                    series.add(Date.difD(ys, ms, ds, y, m, d) + tb, pix * 100 / pixe);
                    break;
                case 2:
                    if (Date.difD(ys, ms, ds, y, m, d) + tb == 0) {
                        break;
                    }
                    series.add(Date.difD(ys, ms, ds, y, m, d) + tb, (pix - pixl) / (Date.difD(ys, ms, ds, y, m, d) + tb));
                    break;
                case 3:
                    series.add(Date.difD(ys, ms, ds, y, m, d) + tb, (pix - pixl) * 100 / pixl);
                    break;
                default:
                    series.add(Date.difD(ys, ms, ds, y, m, d) + tb, pix);
                    break;
            }
        }
        MainClass.gDataset.addSeries(series);
        switch (MainClass.gDia) {
            case 0:
                MainClass.gYax = new NumberAxis("Absolute Größe in Pixel");
                break;
            case 1:
                MainClass.gYax = new NumberAxis("Relative Größe in %");
                break;
            case 2:
                MainClass.gYax = new NumberAxis("Absolute Wachstumsgeschwindigkeit in Pixel / Tag");
                break;
            case 3:
                MainClass.gYax = new NumberAxis("Relativer Wachstumszuwachs in %");
                break;
            default:
                MainClass.gYax = new NumberAxis("Größe");
                break;

        }
        MainClass.jTextArea1.setText("Projekt " + MainClass.jTextField12.getText() + " wurde als " + (MainClass.gSerie + 1) + ". Objekt zum Diagramm hinzugefügt.");
    }

    static void create() {
        if (MainClass.gSerie == 0) {
            MainClass.jTextArea1.setText("Es konnte kein Diagramm erstellt werden, da noch keine Projekte zum Diagramm hinzugefügt wurden.");
        } else {
            XYPlot plot = new XYPlot(MainClass.gDataset, MainClass.gXax, MainClass.gYax, MainClass.gLine);
            MainClass.gChart = new JFreeChart(plot);
            ChartFrame chartFrame = new ChartFrame("Wachstumskurve", MainClass.gChart);
            MainClass.gChartPanel = new ChartPanel(MainClass.gChart);
            chartFrame.setContentPane(MainClass.gChartPanel);
            chartFrame.setIconImage(MainClass.gIcon);
            chartFrame.pack();
            chartFrame.setVisible(true);
            MainClass.jTextArea1.setText("Es wurde erfolgreich ein Diagramm aus " + String.valueOf(MainClass.gSerie) + " Projekt(en) erstellt.");
        }
    }

    static void average(String[] prList, String name) throws IOException {
        FileWriter fw = new FileWriter(MainClass.gDir + "/" + name);
        BufferedWriter bw = new BufferedWriter(fw);
        FileReader fr = new FileReader("projects2.txt");
        BufferedReader br = new BufferedReader(fr);
        int[] value = new int[6];
        int num = MainClass.gSerie;
        int lineNum = 0;
        double val = 0;
        boolean stop = true;

        String[] time = new String[num];
        int[] days = new int[num];
        int[] months = new int[num];
        int[] years = new int[num];

        while (stop) {
            for (int i = 0; i < num; i++) {
                days[i] = Integer.valueOf(Chart.readPrLine(prList[i], lineNum));
            }
            lineNum++;
            for (int i = 0; i < num; i++) {
                months[i] = Integer.valueOf(Chart.readPrLine(prList[i], lineNum));
            }
            lineNum++;
            for (int i = 0; i < num; i++) {
                years[i] = Integer.valueOf(Chart.readPrLine(prList[i], lineNum));
            }
            lineNum++;
            for (int i = 0; i < num; i++) {
                time[i] = Chart.readPrLine(prList[i], lineNum);
            }
            String[] e = Date.avY(years, months, days, time);
            bw.write(e[2]);
            bw.newLine();
            bw.write(e[1]);
            bw.newLine();
            bw.write(e[0]);
            bw.newLine();
            bw.write(e[3]);
            bw.newLine();
            lineNum++;

            for (int v = 3; v < 6; v++) {
                value[v] = 0;
                for (int i = 0; i < num; i++) {
                    value[v] += Integer.valueOf(Chart.readPrLine(prList[i], lineNum));
                }
                bw.write(String.valueOf(value[v] / num));
                bw.newLine();
                lineNum++;
            }

            for (int i = 0; i < num; i++) {
                val += Double.valueOf(Chart.readPrLine(prList[i], lineNum));
            }
            bw.write(String.valueOf(Math.round(val * 1000.0) / (num * 1000.0)));
            val = 0.0;
            bw.newLine();
            lineNum++;

            for (int i = 0; i < num; i++) {
                if (Chart.readPrLine(prList[i], lineNum) == null) {
                    stop = false;
                }
            }
        }

        bw.close();
        br.close();

    }

    private static String readPrLine(String project, int lineNum) throws IOException {
        FileReader fr = new FileReader(project);
        BufferedReader br = new BufferedReader(fr);

        for (int i = 0; i < lineNum; i++) {
            br.readLine();
        }
        return (br.readLine());
    }

    static void delete() {
        MainClass.gDataset.removeAllSeries();
        MainClass.gSeries1.clear();
        MainClass.gSeries2.clear();
        MainClass.gSeries3.clear();
        MainClass.gSeries4.clear();
        MainClass.gSeries5.clear();
        MainClass.gSeries6.clear();
        MainClass.gSeries7.clear();
        MainClass.gSeries8.clear();
        MainClass.gSeries9.clear();
        MainClass.gSeries10.clear();
        MainClass.gSerie = 0;

    }

    static void deleteL() {
        switch (MainClass.gSerie) {
            case 0:
                MainClass.jTextArea1.setText("Das Diagramm ist bereits leer.");
                break;
            case 1:
                MainClass.gDataset.removeSeries(MainClass.gSeries1);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 1. Projekt wurde aus dem Diagramm gelöscht.");
                break;
            case 2:
                MainClass.gDataset.removeSeries(MainClass.gSeries2);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 2. Projekt wurde aus dem Diagramm gelöscht.");
                break;
            case 3:
                MainClass.gDataset.removeSeries(MainClass.gSeries3);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 3. Projekt wurde aus dem Diagramm gelöscht.");
                break;
            case 4:
                MainClass.gDataset.removeSeries(MainClass.gSeries4);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 4. Projekt wurde aus dem Diagramm gelöscht.");
                break;
            case 5:
                MainClass.gDataset.removeSeries(MainClass.gSeries5);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 5. Projekt wurde aus dem Diagramm gelöscht.");
                break;
            case 6:
                MainClass.gDataset.removeSeries(MainClass.gSeries6);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 6. Projekt wurde aus dem Diagramm gelöscht.");
                break;
            case 7:
                MainClass.gDataset.removeSeries(MainClass.gSeries7);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 7. Projekt wurde aus dem Diagramm gelöscht.");
                break;
            case 8:
                MainClass.gDataset.removeSeries(MainClass.gSeries8);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 8. Projekt wurde aus dem Diagramm gelöscht.");
                break;
            case 9:
                MainClass.gDataset.removeSeries(MainClass.gSeries9);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 9. Projekt wurde aus dem Diagramm gelöscht.");
                break;
            case 10:
                MainClass.gDataset.removeSeries(MainClass.gSeries10);
                MainClass.gSerie--;
                MainClass.jTextArea1.setText("Das 10. Projekt wurde aus dem Diagramm gelöscht.");
                break;
        }
    }

    static void deleteAv(){
        try {
            FileWriter fw = new FileWriter("projects2.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
        } catch (IOException ex) {
            MainClass.jTextArea1.setText("Die Projekte für den Durchschnitt konnten nicht gelöscht werden.");
        }

    }

    static void saveD() {
        String dir = MainClass.gDir + "/" + MainClass.jTextField12.getText();
        try {
            if (!".png".equals(dir.substring(dir.length() - 4))) {
                dir += ".png";
            }
            ChartUtilities.saveChartAsPNG(new File(dir), MainClass.gChart, MainClass.gChartPanel.getWidth(), MainClass.gChartPanel.getHeight());
            MainClass.jTextArea1.setText("Das Diagramm wurde erfolgreich als PNG-Datei in '" + dir + "' gespeichert.");
        } catch (IOException ex) {
            MainClass.jTextArea1.setText("Ein unbekannter Fehler ist aufgetreten.");
        } catch (NullPointerException ex2) {
            MainClass.jTextArea1.setText("FEHLER: \nDiagramm konnte nicht gespeichert werden. \nEventuell wurde das Diagramm noch nicht erstellt.");
        } catch (StringIndexOutOfBoundsException ex3) {
            try {
                dir += ".png";
                ChartUtilities.saveChartAsPNG(new File(dir), MainClass.gChart, MainClass.gChartPanel.getWidth(), MainClass.gChartPanel.getHeight());
                MainClass.jTextArea1.setText("Das Diagramm wurde erfolgreich als PNG-Datei in '" + dir + "' gespeichert.");
            } catch (IOException ex4) {
                MainClass.jTextArea1.setText("Ein unbekannter Fehler ist aufgetreten.");
            } catch (NullPointerException ex5) {
                MainClass.jTextArea1.setText("FEHLER: \nDiagramm konnte nicht gespeichert werden. \nEventuell wurde das Diagramm noch nicht erstellt.");
            }
        }
    }
}
