package Parte1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Cine c1 = new Cine("Ocimax", 2000); //crear objeto c1
        System.out.println("Nombre: " + c1.getNombre()); //mostrar nombre c1
        System.out.println("Asientos: " + c1.getNumAsientos()); //mostrar asientos c1
        c1.crearAsientos(); //creacion asientos

        int contador = 0; //para evaluar eficiencia
        int asientosOcupados = 0;
        do {
            contador++;
            c1.sentar();
            asientosOcupados++;
            System.out.println("..............................................");
            c1.imprimirTodoArray();
        } while (asientosOcupados != c1.getNumAsientos());
        System.out.println("Num iteraciones: " + contador);
        System.out.println("Numeros aleatorios generados: " + c1.numAleatorios);
    }
}