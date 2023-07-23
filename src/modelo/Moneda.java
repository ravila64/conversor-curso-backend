package modelo;

public class Moneda {
    private String pais;
    private String nombreMoneda;
    private String sigla; 
    private double factorCambio;

    public Moneda(){
        // contructor sin parametros
    }
    public Moneda(String pais, String nombreMoneda, String sigla, double factorCambio) {
        //super();
        this.pais = pais;
        this.nombreMoneda = nombreMoneda;
        this.sigla = sigla;
        this.factorCambio = factorCambio;
    }
    /* getters and getters */ 
    /**
     * @return the nombreMoneda
     */
    public String getNombreMoneda() {
    	return nombreMoneda;
    }
    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }
    /**
     * @return the factorCambio
     */
    public double getFactorCambio() {
      return factorCambio;
    }

    public String getPais() {
      return pais;
    }

    @Override
    public String toString() {
         return "Moneda [pais=" + pais + ", nombreMoneda=" + nombreMoneda + ", sigla=" + sigla + ", factorCambio="
                   + factorCambio + "]";
    }
}
