
package ultetes;

import annotation.getterFunctionName;

public class Szolgaltato extends Ember{
    @getterFunctionName(value = "getAr", type = Integer.class)
    private Integer ar;
    @getterFunctionName(value = "getSzolgaltatas", type = String.class)
    private String szolgaltatas;

    public Szolgaltato() {
        super();
        this.ar = 0;
        this.szolgaltatas = "Nincs megadva";
    }

    public Szolgaltato(String nev, String email, String telefonszam, Boolean resztVesz,Integer ar, String szolgaltatas, Integer szekSzam) {
        super(nev,email,telefonszam,resztVesz, szekSzam);
        this.ar = ar;
        this.szolgaltatas = szolgaltatas;
    }

    public Integer getAr() {
        return ar;
    }

    public String getSzolgaltatas() {
        return szolgaltatas;
    }

    public void setAr(Integer ar) {
        if(ar>0){
            this.ar = ar;
        }
    }

    public void setSzolgaltatas(String szolgaltatas) {
        if(szolgaltatas.length()>2){
            this.szolgaltatas = szolgaltatas;
        }
    }
    
    
    
    
}
