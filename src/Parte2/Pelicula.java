/**
 * @author MRossello11
 * @version 1.1
 * @since 09/12/2021
 * @description clase Pelicula del proyecto Cine*/

package Parte2;

import java.util.Random;

public class Pelicula {
    Random rand = new Random();
    private String nombre;
    private String director;
    private int edadMinima;

    //listas con nombres de peliculas y directores
    private String[] titulos = {"Jurassic Park", "Django", "Alien", "Pacific rim", "Inception"};
    private String[] directores = {"Steven Spilberg", "Quentin Tarantino", "Ridley Scott", "Guillermo del Toro", "Christopher Nolan"};


    //constructor
    public Pelicula(){
        this.nombre = titulos[rand.nextInt(0, this.titulos.length)];
        this.director = directores[rand.nextInt(0, this.directores.length)];
        this.edadMinima = generarEdadMinima();
    }

    private int generarEdadMinima(){
        return rand.nextInt(5,18);
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getDirector() {
        return director;
    }

    public int getEdadMinima() {
        return edadMinima;
    }
}
