package bo;

import javax.swing.JOptionPane;

/* @author bg15dv-jskopp */
public class Bo {

    /* @param args the command line arguments */
    
    public static void main(String[] args) {
        
        double pin = 10.0;
        double max = 0.0;
        double wurf = 0.0;
        double div = 0.0;
        double eigen = 0.0;
          
        eigen = Double.parseDouble(JOptionPane.showInputDialog("Eigen: "));
        
        wurf = Double.parseDouble(JOptionPane.showInputDialog("Wurf: "));
        
        max = wurf * pin;
        
        div = max / eigen;
        
        System.out.println(div);
        
        
    
        
    }
    
    
}
