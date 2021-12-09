/**
 * @author MRossello11
 * @version 1.3
 * @since 02/12/2021
 * @description clase principal del proyecto Cine*/

package Parte2;

public class Main {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis(); //tiempo inicio
        Cine c1 = new Cine("Ocimax", 200); //crear objeto c1
        System.out.println("Nombre: " + c1.getNombre()); //mostrar nombre c1
        System.out.println("Asientos: " + c1.getNumAsientos()); //mostrar asientos c1
        c1.crearAsientos(); //creacion asientos

        int asientosOcupados = 0; //contador de asientos que se han asignado

        do {
            c1.sentar(); //se asigna un asiento
            asientosOcupados++; //al sentar a alguien, se aumenta el numero de asientos ocupados
            System.out.println("..................................................."); //separa visualmente la impresion de las salas
            c1.imprimirTodoArray(); //imprime la sala (asientos vacios y ocupados)
        } while (asientosOcupados != c1.getNumAsientos()); //cuando se hayan ocupado tantos asientos como asientos haya, sale del bucle

        //medicion de eficiencia
        System.out.println("Numeros aleatorios generados: " + c1.numAleatorios); //mostrar cuantos numeros aleatorios se han generado
        long fin = System.currentTimeMillis(); //tiempo final
        double tiempoEjecucion = fin-inicio; //tiempo de ejecucion
        System.out.println("Tiempo ejecucion: " + tiempoEjecucion + " milisegundos");
    }
    //Fin programa
}