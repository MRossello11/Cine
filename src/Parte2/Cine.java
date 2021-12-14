/**
 * @author MRossello11
 * @version 1.5
 * @since 02/12/2021
 * @description clase de los objetos Cine*/

package Parte2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cine {
    public Random rand = new Random();
    private String nombre;
    private int numSalas;
    private List<Sala> salas = new ArrayList<Sala>();
    private int contadorSalas = 0;
    private int asientosSala;
    public static double dineroRecolectado;

    //constructor
    public Cine(String nombre, int numSalas, int asientosSala){
        this.nombre = nombre; //nombre del cine
        this.numSalas = numSalas; //numero de salas que tiene el cine
        this.asientosSala = asientosSala; //numero de asientos por sala
        this.salas = crearSalas();
        this.dineroRecolectado = 0;

    }

    //crea tantos objetos Sala en un array como se haya especificado
    public List<Sala> crearSalas(){
        for (int i = 0; i <= this.getNumSalas(); i++){
            salas.add(new Sala(this.getAsientosSala()));
        }
        return salas;
    }

    //llena las salas
    public void llenarCine(){
        for (int i = 0; i < this.getNumSalas(); i++){
            System.out.println("Llenando sala " + i + " con la pelicula " + this.getSalas().get(i).getP().getNombre());
            do {
                this.getSalas().get(i).sentar(); //se asigna un asiento en la sala actual
                System.out.println("..................................................."); //separa visualmente la impresion de las salas
                this.getSalas().get(i).imprimirTodoArray(); //imprime la sala (asientos vacios y ocupados)
            } while (this.getSalas().get(i).getAsientosOcupados() != this.getAsientosSala()); //cuando se hayan ocupado tantos asientos como asientos haya, sale del bucle
            System.out.println("Sala " + i + " llena");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
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

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public int getAsientosSala() {
        return asientosSala;
    }

    public void setAsientosSala(int asientosSala) {
        this.asientosSala = asientosSala;
    }

    public static double getDineroRecolectado() {
        return dineroRecolectado;
    }
}
