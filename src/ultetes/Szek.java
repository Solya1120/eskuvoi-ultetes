
package ultetes;

import annotation.getterFunctionName;
import javax.swing.JLabel;



public class Szek {
    @getterFunctionName(value = "isFoglalt", type = Boolean.class)
    private Boolean foglalt;
    @getterFunctionName(value = "getSzekSzam", type = Integer.class)
    private Integer szekSzam;
    @getterFunctionName(value = "getSzekNeve", type = JLabel.class)
    private JLabel szekNeve;

    public Szek() {
        this.foglalt = Boolean.FALSE;
        this.szekSzam = 0;
        this.szekNeve = new JLabel("balSzek0");
    }

    public Szek(Boolean foglalt, Integer szekSzam, JLabel szekNeve) {
        this.foglalt = foglalt;
        this.szekSzam = szekSzam;
        this.szekNeve = szekNeve;
    }
    
    public Boolean isFoglalt() {
        return this.foglalt;
    }
    
    public Integer getSzekSzam(){
        return this.szekSzam;
    }
    
    public JLabel getSzekNeve(){
        return this.szekNeve;
    }
    
    public void szekFoglalas(){
        this.foglalt = Boolean.TRUE;
    }
    
    public void setSzekSzam(Integer szekSzam){
        this.szekSzam = szekSzam;
    }
    
    public void setSzekNeve(JLabel szekNeve){
        this.szekNeve = szekNeve;
    }
    
}
