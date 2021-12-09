/**
 * @author MRossello11
 * @version 1.3
 * @since 02/12/2021
 * @description clase de los objetos Cine*/

package Parte2;

import java.util.Random;

public class Cine {
    public Random rand = new Random();
    private String nombre;
    private int numSalas;

    //constructor
    public Cine(String nombre, int numSalas){
        this.nombre = nombre; //nombre del cine
        this.numSalas = numSalas; //numero de salas que tiene el cine
    }


    //metodos getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumSalas() {
        return numSalas;
    }

    public void setNumSalas(int numSalas) {
        this.numSalas = numSalas;
    }
}
