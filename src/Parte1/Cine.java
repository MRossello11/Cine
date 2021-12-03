package Parte1;

import java.util.Random;

public class Cine {
    public Random rand = new Random();
    private String nombre;
    private int numAsientos;
    private int numFilas;
    private int numColumnas;
    private char arrayAsientos[][];

    public Cine(String nombre, int numAsientos){
        this.nombre = nombre;
        this.numAsientos = numAsientos;
//        this.numFilas = numFilas;
//        this.numColumnas = numColumnas;
        this.arrayAsientos = new char[numFilas][numColumnas];
    }

    public void crearAsientos(){
        numFilas = numAsientos/rand.nextInt(0, numAsientos); //asignar #filas
        //asignar # columnas
        if (numAsientos%numFilas == 0){
            numColumnas = numAsientos/numFilas;
        }else{
            numColumnas = numAsientos/numFilas + 1;
        }
        System.out.println("Filas: " + this.getNumFilas());
        System.out.println("Columnas: " + this.getNumColumnas());

        int resto = (numColumnas*numAsientos)-numAsientos;
        //llenado arrayAsientos
        for (int i = 0; i < numFilas; i++){
            for (int j = 0; j < numColumnas - 1; j++){


            }
        }

    }

    public void AsignarAsient(int f, int c){
        this.getArrayAsientos()[f][c]=1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    public char[][] getArrayAsientos() {
        return arrayAsientos;
    }

    public void setArrayAsientos(char[][] arrayAsientos) {
        this.arrayAsientos = arrayAsientos;
    }

    public void ImprimirTodoArray(){
        for (int i=0; i<this.getNumFilas(); i++){
            for (int j=0; j<this.getNumColumnas();j++){
                System.out.print(this.getArrayAsientos()[i][j]);
            }
            System.out.println();
        }
    }
}
