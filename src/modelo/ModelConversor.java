package modelo;
import java.util.ArrayList;

public class ModelConversor {
    
    public static ArrayList cargarMonedas(ArrayList<Moneda> divisa) {
        // DATOS A 22 07 2023 ==> todos los valores estan en dolares
        divisa.add(new Moneda("USA","DOLAR","USD",1.0));
        divisa.add(new Moneda("Colombia","PESO","COP",3976.46));
        divisa.add(new Moneda("Mexico","PESO","MXN",16.99));   // peso mex
        divisa.add(new Moneda("Euro","EURO","EUR",0.90));   // euros
        divisa.add(new Moneda("Reino Unido","Libra Esterlina","GBP",0.78));   // Inglaterra
        divisa.add(new Moneda("Japon","YEN JAPONES","JPY",141.79));   // Japon
        divisa.add(new Moneda("Corea del Sur","Won Surcoreano","KRW",1286.65));   //  Corea Sur 
        divisa.add(new Moneda("Peru","SOL","PEN",3.58));
        divisa.add(new Moneda("Venezuela","BOLIVAR","VES",27.07));
        divisa.add(new Moneda("Ecuador","DOLAR ECUADOR","ECS",38.19));
        divisa.add(new Moneda("Bolivia","PESO","BOB",6.91));
        divisa.add(new Moneda("Argentina","PESO","ARS",247.96));
        divisa.add(new Moneda("Chile","PESO","CLP",801.08));
        divisa.add(new Moneda("Brazil","REAL","BRL",4.82));
        divisa.add(new Moneda("Uruguay","PESO","UYU",37.99));
        divisa.add(new Moneda("Paraguay","PESO","PYG",7270.60));
        return divisa;
    }

    
}

