/**
 * @author MRossello11
 * @version 1.0
 * @since 09/12/2021
 * @description clase Espectador del proyecto Cine*/
package Parte2;

import java.util.Random;

public class Espectador {
    private Random rand = new Random();
    private int edad;
    private double dinero;

    //constructor
    public Espectador(){
        this.edad = generarEdad();
        this.dinero = generarDinero();
    }

    private int generarEdad(){
        return rand.nextInt(5,120); //devuelve un numero dentro rango de edad
    }

    private double generarDinero(){
        return rand.nextDouble(0, 50); //rango de dinero posible
    }

    //getters
    public int getEdad() {
        return edad;
    }

    public double getDinero() {
        return dinero;
    }
}
