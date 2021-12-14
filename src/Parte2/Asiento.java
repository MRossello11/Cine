/**
 * @author MRossello11
 * @version 1.0
 * @since 10/12/2021
 * @description clase Asiento del proyecto Cine*/
package Parte2;

import java.util.Random;

public class Asiento {
    private static Random rand = new Random();
    private int fil;
    private int col;
    private static double precio = rand.nextDouble(7.5, 10);

    //constructor
    public Asiento(int f, int c){
        this.fil = f;
        this.col = c;
    }

    //getters y setters

    public static double getPrecio() {
        return precio;
    }
}
