
/**
 *
 * @author ESkopp
 */

public class Switch {

    // Variabeln deklarieren
    protected String Port0;
    protected String Port1;
    protected String Port2;
    protected String Port3;

    protected String source;
    protected String aim;

    // Konstruktor 

    public Switch(String Port0, String Port1, String Port2, String Port3, String source, String aim) {
        this.Port0 = Port0;
        this.Port1 = Port1;
        this.Port2 = Port2;
        this.Port3 = Port3;
        this.source = source;
        this.aim = aim;
    }
    
    // Getter und Setter
    public String getPort0() {
        return Port0;
    }

    public void setPort0(String Port0) {
        this.Port0 = Port0;
    }

    public String getPort1() {
        return Port1;
    }

    public void setPort1(String Port1) {
        this.Port1 = Port1;
    }

    public String getPort2() {
        return Port2;
    }

    public void setPort2(String Port2) {
        this.Port2 = Port2;
    }

    public String getPort3() {
        return Port3;
    }

    public void setPort3(String Port3) {
        this.Port3 = Port3;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }
    



}
