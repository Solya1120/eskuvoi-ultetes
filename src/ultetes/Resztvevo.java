
package ultetes;

import annotation.getterFunctionName;

public class Resztvevo extends Ember{
    @getterFunctionName(value = "getStatusz", type = STATUSZ.class)
    private STATUSZ statusz;
    

    public Resztvevo() {
        super();
        this.statusz = STATUSZ.VOLEGENYBARAT;
    }

        public Resztvevo(STATUSZ statusz, String nev, String email, String telefonszam, Boolean resztVesz, Integer szekSzam) {
        super(nev, email, telefonszam, resztVesz, szekSzam);
        this.statusz = statusz;
    }

    public STATUSZ getStatusz() {
        return statusz;
    }

    public void setStatusz(STATUSZ statusz) {
        this.statusz = statusz;
    }
    
    
    
}
