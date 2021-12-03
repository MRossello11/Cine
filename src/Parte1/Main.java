package Parte1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Cine c1 = new Cine("Ocimax", 20); //crear objeto c1
        System.out.println("Nombre: " + c1.getNombre()); //mostrar nombre c1
        System.out.println("Asientos: " + c1.getNumAsientos()); //mostrar asientos c1
        c1.crearAsientos(); //creacion asientos

        int contador = 0; //para evaluar eficiencia
        int contadorExterno = 0;
        int asientosOcupados = 0;
        do {
            contadorExterno++;
            for (int i = 0; i < c1.getNumFilas(); i++) {
                for (int j = 0; j < c1.getNumColumnas(); j++) {
                    if (c1.getArrayAsientos()[i][j] == 'x') {
                        asientosOcupados++;
                    }
                }
            }
            System.out.println("..............................................");
            c1.imprimirTodoArray();

            c1.sentar();
        } while (asientosOcupados <= c1.getNumAsientos());
        System.out.println("Num iteraciones: " + contador);
        System.out.println("Iteraciones externo: " + contadorExterno);
    }
}