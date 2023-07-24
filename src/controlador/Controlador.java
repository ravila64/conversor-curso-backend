package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ModelConversor;
import modelo.Moneda;
import vista.ViewDivisas;
import vista.ViewTemperatura;

/**
 * @author Rene Avila Alonso
 * @date 
 */

public class Controlador  implements ActionListener{
        private ViewDivisas view;
        private ModelConversor model;
        
        public Controlador(ViewDivisas view, ModelConversor model){
            this.view = view;
            this.model = model;
            this.view.btnConvertir.addActionListener(this);
        }
        
        public void iniciar(){
            view.setTitle("CONVERSOR ALURA ONE-CURSO BACKEND");
            view.setLocationRelativeTo(null);   // quede pos 0 pantalla
        }

        public void actionPerformed(ActionEvent e) throws IllegalArgumentException{
            // tomar variables para hacer calculos que estan en el JFrame
            try{
            	// seleccionar paises dados por usuario
                String paisO= view.cbxPaisOrigen.getSelectedItem().toString().trim();  // trim() quita blancos ambos lados
                String paisC= view.cbxPaisCambio.getSelectedItem().toString().trim();
                //System.out.println("Divisa de "+paisO+ " pasar a "+paisC);
                
                // selecciono pais origen
                Moneda paisBusq = buscarPais(paisO);
                double dolares=0.0;
                double result=0.0;
                boolean lError=false;
                String formNeg="###.####################################";
                String formPos="###,###,###,###.00";
                DecimalFormat df;

                int cant=0;
                try {
                   cant = Integer.parseInt(view.txtCantidad.getText()); 
                }catch (NumberFormatException exe){
                    JOptionPane.showMessageDialog(view, "Debe digitar una Cantidad "+ exe.getMessage());
                    lError = true;
                }
                if (paisO.equals(paisC) || lError){
                    JOptionPane.showMessageDialog(view, "No Paises Iguales o Cantidad [en blanco o caracteres alfabeticos]");
                    limpiar();
                }else {
                    if (paisBusq!=null){
                        // traer valores de moneda pais origen
                        String nombreMon= paisBusq.getNombreMoneda(); 
                        double factorO = paisBusq.getFactorCambio(); // factor pais origen
                        view.txtMonedaInicial.setText(nombreMon);
                        view.txtSiglaMoneda1.setText(paisBusq.getSigla());
                        if (paisO.equals("USA")){
                            dolares = cant * factorO;
                        }else {
                            dolares = cant / factorO;
                        }
                        if (dolares >= 1){
                          df = new DecimalFormat(formPos);  
                        }else{
                          df = new DecimalFormat(formNeg);    
                        }
                        String resTxt = df.format(dolares);
                        view.txtValorFinal.setText(resTxt);
                        
                       // System.out.println("Intermedia USD "+dolares+" Pais "+paisBusq.getPais());
                        // convierte cantidad a dolares, no importando el pais
                        
                        Moneda paisCambio = buscarPais(paisC);
                        if (paisCambio!=null){
                            view.txtMonedaDestino.setText(paisCambio.getNombreMoneda());
                            view.txtSiglaMoneda2.setText(paisCambio.getSigla());
                            // pasar cantidad de dolares a cambio pais seleccionado
                            double factorD = paisCambio.getFactorCambio();
                            if(paisC.equals("USA")) {
                                result = dolares / factorD; // cant dolares * factor Cambio
                            }else {
                                result = dolares * factorD;
                            }
                            if (result >= 1){
                                df = new DecimalFormat(formPos);  
                            }else{
                                df = new DecimalFormat(formNeg);    
                            }
                            resTxt = df.format(result);
                            view.txtValorFinal.setText(resTxt);
                          //  System.out.println("resultado "+result+" Pais "+paisCambio.getPais());
                        } else{
                            JOptionPane.showMessageDialog(view, "Pais Cambio No existe");
                        }
                    }else{
                    	JOptionPane.showMessageDialog(view, "Pais Origen no existe");
                    }
                    
                   } // end else paises iguales    
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
    }

    private Moneda buscarPais(String paisBuscar) {
        ArrayList<Moneda> monedas = new ArrayList<>();
        Moneda objBuscado=null;
        monedas = modelo.ModelConversor.cargarMonedas(monedas);
        for (Moneda moneda : monedas) {
            if(moneda.getPais().equals(paisBuscar)) {
                objBuscado = moneda;
                break;
            }
        }
        return objBuscado;
    }
    
    private void limpiar(){
        view.txtCantidad.setText("");
        view.txtMonedaInicial.setText("");
        view.txtMonedaDestino.setText("");
        view.txtValorFinal.setText("");
        view.txtSiglaMoneda1.setText("");
        view.txtSiglaMoneda2.setText("");
    }
    
    // calculos grados celsius y fahrenheit
    // celsius = gradosc * 1.8 + 32; 
    public static double calcularFahrenheit(int grados){
        Double res= (Double) (grados * 1.8 + 32.0);
        return (res);
    }
    
    // fahren = (gradosf - 32) * 5  / 9; 
    public static double calcularCelsius(int grados){
        Double res= (Double) (grados * 5.0 / 9.0) - 32;
        return (res);
    }
        
}
