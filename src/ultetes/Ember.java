
package ultetes;

import annotation.getterFunctionName;

public class Ember {
    @getterFunctionName(value = "getNev", type = String.class)
    protected String nev;
    @getterFunctionName(value = "getEmail", type = String.class)
    protected String email;
    @getterFunctionName(value = "getTelefonszam", type = String.class)
    protected String telefonszam;
    @getterFunctionName(value = "isResztVesz", type = Boolean.class)
    protected Boolean resztVesz;
    @getterFunctionName(value = "getSzekSzam", type = Integer.class)
    protected Integer szekSzam;

    public Ember() {
        this.nev = "Névtelen";
        this.email = "Nem adott meg E-mail címet";
        this.telefonszam = "000000000";
        this.resztVesz = Boolean.FALSE;
        this.szekSzam = 0;
    }

    public Ember(String nev) {
        this.nev = nev;
        this.email = "Nem adott meg E-mail címet";
        this.telefonszam = "000000000";
        this.resztVesz = Boolean.FALSE;
        this.szekSzam = 0;
    }

    public Ember(String nev, String email) {
        this.nev = nev;
        this.email = email;
        this.telefonszam = "000000000";
        this.resztVesz = Boolean.FALSE;
        this.szekSzam = 0;
    }

    public Ember(String nev, String email, String telefonszam) {
        this.nev = nev;
        this.email = email;
        this.telefonszam = telefonszam;
        this.resztVesz = Boolean.FALSE;
        this.szekSzam = 0;
    }

    public Ember(String nev, String email, String telefonszam, Boolean resztVesz, Integer szekSzam) {
        this.nev = nev;
        this.email = email;
        this.telefonszam = telefonszam;
        this.resztVesz = resztVesz;
        this.szekSzam = szekSzam;
    }

    public String getNev() {
        return nev;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public Boolean isResztVesz() {
        return resztVesz;
    }
    
    public Integer getSzekSzam() {
        return szekSzam;
    }

    public void setNev(String nev) {
        if(nev.length()>5){
            this.nev = nev;
        }
    }

    public void setEmail(String email) {
        if(email.length()>5){
            this.email = email;
        }
    }

    public void setTelefonszam(String telefonszam) {
        if(telefonszam.length()>7){
            this.telefonszam = telefonszam;
        }
    }
    
    public void setSzekSzam(Integer szekSzam){
        this.szekSzam = szekSzam;
    }

    public void eljon(){
        this.resztVesz = Boolean.TRUE;
    }
    
    
    
    
    
    
    
    
    
    
}
