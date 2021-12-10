/**
 * @author MRossello11
 * @version 1.4
 * @since 02/12/2021
 * @description clase principal del proyecto Cine*/

package Parte2;

public class Main {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis(); //tiempo inicio
        Cine c1 = new Cine("Ocimax", 100, 400); //crear objeto c1
        System.out.println("Nombre: " + c1.getNombre()); //mostrar nombre c1
        System.out.println("Salas: " + c1.getNumSalas()); //mostrar numero de salas de c1
        c1.crearSalas(); //creacion salas

        c1.llenarCine(); //llena todas las salas de c1
        //medicion de eficiencia
        System.out.println("Numeros aleatorios generados: " + Sala.getNumAleatorios()); //mostrar cuantos numeros aleatorios se han generado
        long fin = System.currentTimeMillis(); //tiempo final
        double tiempoEjecucion = fin-inicio; //tiempo de ejecucion
        System.out.println("Tiempo ejecucion: " + tiempoEjecucion + " milisegundos" + "(" + tiempoEjecucion/1000 + " segundos)");
    }
    //Fin programa
}