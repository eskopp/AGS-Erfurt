
package fahrzeug;
import java.io.*;
import java.util.*;

/**
 *  @author ESkopp
 */

public class Logger {
    public final String pfad = "log";
    public final dat
    File file = new File(pfad);
    
    public boolean check_dir(){
        return file.exists();
    }
    
    
    
}
