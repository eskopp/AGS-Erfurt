
package bowling;

import java.io.*;
import java.util.*;
import javax.swing.*; 


/**
 * @author ESkopp
 * lädt und arbeitet mit dem Spiel
 * @version 1.0
 */

public class game{
    
    //Konstruktor

    /**
     * Standart Konstruktor
     */
    public game(){};
    
    // global in class --> {prot}

    /**  
     * legt die Ausgabe fest
     */
    protected String ausgabe = "";
    
    /**
     * legt die Anzahl der Spieler fest
     */
    protected int anz_player = 0;

    /**
     * Anzahl der Runden (von Start aus)
     */
    protected int round = 0;
    
    // final

    /**
     * Basispfad (Ordner)
     */
    public final String path = "game";

    /**
     * Legt die Unique Identifier fest
     */
    public final String uid = uuid();

    /**
     * Pfad zu den Namen. Format: csv
     */
    public final String file_name = path+"/"+uid+"/"+"name_"+uid+".csv";

    /**
     * Ordner zu den UID-Tabellen
     */
    public final String file_round = path+"/"+uid;
    //public final String path_round = file_round+"/"+round+"_"+uid+".csv";

    /**
     * Würfe pro Runde
     */
    public final Integer a = 7; // Anzahl der Würfe / runde    public final String 
    
    //session
    /**
     *  Trennungszeichen unter Win 10 erstellt
     */
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    
    // itteration
    ArrayList<Integer> result = new ArrayList<>();    
    ArrayList<Integer> sort = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();

    //puffer    

    /**
     *
     * @param list ´
     * @return reverse list
     */
    public ArrayList<Object> reverse(ArrayList<Object> list) {
    if(list.size() > 1) {                   
        Object value = list.remove(0);
        reverse(list);
        list.add(value);
    }
    return list;
}
    
    /**
     * Gibt einen eindeutigen String aus.
     * @return UID String
     */
    public String uuid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    /**
     *
     * @param path
     */
    public void create_folder(String path){
       File f = new File(path);
            f.mkdir();
 }
 
    /**
     * Deinstalliert das Programm
     */
    public void uninstall(){ // Necessary since otherwise recursive
       delete_sys(new File(path));
    }
    
    /**
     * Deinstallations Runtime
     * @param path 
     */
    public void delete_sys(File path) {
      for (File file : path.listFiles()) {
         if (file.isDirectory())
            delete_sys(file);
         file.delete();
      }
      path.delete();
   }
    
    /**
     * Programm-Ablauf-Plan (Line)
     * @throws IOException
     */
    public void pal() throws IOException{
     set_count_player();
     player_name_write();
     create_new_round();
 }
 
    /**
     * Datei erstellung. Runtime
     * @param file_path
     * @throws IOException
     */
    public void create_file(String file_path) throws IOException{
     File f = new File(file_path);
         f.createNewFile();
 }
    
    /**
     * installiert das Programm
     */
    public void install(){ // Flag
       create_folder(path);
    }
    
    /**
     * Erstellt neue Runde und lädt pal()
     * @throws IOException
     */
    public void create_new_game() throws IOException{ // Flag
      try{
        create_folder(path+"/"+uid);
        pal();
      }catch(IOException e){
          System.out.println("Fehlercode: "+e);
          System.exit(0);
      }
    }
    
    /**
     * legt die Anzahl der Spieler fest.
     */
    public void set_count_player(){ // Flag
        anz_player = Integer.parseInt(JOptionPane.showInputDialog(null,"Wie viele Spieler sind sie?: ","Eine Eingabeaufforderung",JOptionPane.PLAIN_MESSAGE));
    }
    
    /**
     *  Schreibt und legt die Spielernamen (fest)
     * @throws IOException
     */
    public void player_name_write() throws IOException{
        create_file(file_name);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_name))) {
            for(int c=1;c<=this.anz_player;c++){
                bw.write(JOptionPane.showInputDialog(null,"Ihr Name: ","Eine Eingabeaufforderung",JOptionPane.PLAIN_MESSAGE));
                bw.newLine();
            }
        }
    }
    
    /**
     * Erstellen und schreiben der neuen Runde
     * @throws IOException
     */
    public void create_new_round() throws IOException{
        round++;
        int temp = 0;
        create_file(file_round+"/"+round+".csv");
        // bw.write("sep=;"); new version of xml ?!
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_round+"/"+round+".csv"))) {
            for(int c=1;c<=this.anz_player;c++){
                temp = 0;
                for(int x=1;x<=this.a;x++){
                    Integer eingabe = Integer.parseInt(JOptionPane.showInputDialog(null,"Ihre Punktzahl","Spieler: "+c+" Runde: "+x,JOptionPane.PLAIN_MESSAGE));
                    temp += eingabe;
                    bw.write(eingabe+";");
                }
                result.add(temp);
                bw.newLine();
            }
        }
        evaluate_round();
        
    }
    
    /**
     * Laden der Namen und Ausgabe
     * @throws IOException
     */
    public void evaluate_round () throws IOException{
       BufferedReader br = new BufferedReader(new FileReader(file_name));
       for(String zeile = ""; (zeile = br.readLine()) != null; )
        {
            name.add(zeile);
        }
        
        sort = result;
        Collections.sort(sort);
        Collections.reverse(sort);
      for(int x=1; x<=anz_player; x++){
           System.out.println((x)+". Platz:  "+name.get(result.indexOf(sort.get(x-1)))+" --> "+ sort.get((x-1)));
       
       } 
  }  
}