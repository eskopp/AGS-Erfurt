
package linsearch;
import java.util.*;

/**
 * @version free
 * @author JSkopp
 */

public class Linsearch {
    
// Grundidee: lineare_suche = lambda l,g : [i for i,e in enumerate(l) if g == e]



    
    public static int lineareSuche(final int gesucht, final int[] daten) {
    for (int i = 0; i < daten.length; i++) {
        if (daten[i] == gesucht) {
            return i;
        }
    }
    return -1;
}
   
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Anzahl der Elemente:");
            int[] data = new int[sc.nextInt()];
            System.out.print("Welche Zahl suchen Sie?:");
            int i = sc.nextInt();
       
        for(int x:data){
            data[x] = sc.nextInt();   
        }
        if (lineareSuche(i,data) != -1){
            System.out.println("Die Zahl "+i+" ist das "+lineareSuche(i,data)+" Element");
        }else{
            System.out.println("ERROR");
        }
        
    }
    
}
