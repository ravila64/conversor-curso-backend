package main;

import controlador.Controlador;
import modelo.ModelConversor;
import vista.ViewDivisas;

/**
 * @author Rene Avila Alosno
 * @date 19-07-2023
 */
public class MVCConversorONE {
    public static void main(String[] args) {
        ModelConversor model= new ModelConversor();
        ViewDivisas view = new ViewDivisas();
        Controlador control= new Controlador(view, model);
        control.iniciar();
        view.setVisible(true);
    }
}
