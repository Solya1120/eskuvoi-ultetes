
package ultetes;


public enum STATUSZ {
    VOLEGENYKOZELI("vőlegény közeli családtagja"),
    MENYASSZONYKOZELI("menyasszony közeli családja"), 
    VOLEGENYTAVOLI("vőlegény távoli családtagja"),
    MENYASSZONYTAVOLI("menyasszony távoli családja"),
    VOLEGENYBARAT("vőlegény barátja"),
    MENYASSZONYBARAT("menyasszony barátja");
    
    private String kiirandoErtek;

    private STATUSZ(String kiirandoErtek) {
        this.kiirandoErtek = kiirandoErtek;
    }
    

    public String getStatusz() {
        return this.kiirandoErtek;
    }
}
