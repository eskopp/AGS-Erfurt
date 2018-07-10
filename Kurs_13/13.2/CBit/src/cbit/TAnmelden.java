package cbit;



/**
 *
 * @author Florian Draeger
 */

public class TAnmelden {
    private String name;
    private boolean CBFahrt,CBEintritt;
    
    //Konstruktor
    public TAnmelden(String name, boolean CBFahrt, boolean CBEintritt) {
        this.name = name;
        this.CBFahrt = CBFahrt;
        this.CBEintritt = CBEintritt;
    }
    
    public boolean getCBFahrt() {
        return CBFahrt;
    }

    public boolean getCBEintritt() {
        return CBEintritt;
    }

    public String getName() {
        return name;
    }
    
    
}
