/**
 * @author MRossello11
 * @version 1.3
 * @since 02/12/2021
 * @description clase de los objetos Cine*/
package Parte1;

import java.util.Random;

public class Cine {
    public Random rand = new Random();
    private String nombre;
    private int numAsientos;
    private int numFilas;
    private int numColumnas;
    private char arrayAsientos[][];
    char[][] copiaArrayAsientos;
    public int numAleatorios = 0;


    //constructor
    public Cine(String nombre, int numAsientos){
        this.nombre = nombre; //nombre del cine
        this.numAsientos = numAsientos; //numero de asientos del cine
        this.numFilas = crearFilas(); //filas
        this.numColumnas = crearColumnas(); //columnas
        this.arrayAsientos = new char[numFilas][numColumnas]; //array de los asientos
        this.copiaArrayAsientos = this.arrayAsientos.clone();
    }

    //crea un numero de filas aleatorias a partir del numero de asientos
    public int crearFilas(){
        this.numFilas = numAsientos/rand.nextInt(1, numAsientos); //asignar numero filas
        return numFilas;
    }

    //crea el numero de columnas a partir del numero de filas y el numero total de asientos
    public int crearColumnas(){
        //si no hay resto (la sala es un cuadrado/rectangulo) perfecto
        if (this.numAsientos%numFilas == 0){
            numColumnas = this.numAsientos/this.numFilas;

        }else{ //en caso de que la ultima columna no tenga el mismo numero de asientos que las demas
            numColumnas = this.numAsientos/this.numFilas + 1;
        }

        return numColumnas;
    }

    //llena el arrayAsientos
    public void crearAsientos(){
        //resto indica el numero de filas que hay en la ultima columna
        int resto = (this.numColumnas*this.numFilas)-this.numAsientos;

        //bucle llenado del arrayAsientos (creacion butacas de la sala)
        for (int i = 0; i < numFilas; i++){
            for (int j = 0; j < numColumnas; j++){
                //cuando el resto sea mayor que la fila actual y sea la penultima columna, pase la iteracion
                //para cuando numAsientos/numFilas no sea entero y se asignen menos asientos a la ultima columna
                //para compensar
                if (i < resto && j == numColumnas-1){
                    continue;
                }
                //crear asiento (vacio)
                arrayAsientos[i][j] = '-';

            }
        }
        //this.imprimirTodoArray(); //debug
    }

    /*metodo que se llama desde el metodo sentar() al encontrar un asiento vacio y
    se asigna ese asiento como ocupado
    @since 03/12/2021*/
    public void asignarAsiento(int f, int c){
        this.arrayAsientos[f][c] = 'x';
    }

    /*
    genera numeros aleatorios (filas y columnas) e intenta asignar un asiento para esa iteracion,
    si el asiento esta ocupado, se vuelve a intentar asignar un asiento en la siguiente iteracion
    @since 03/12/2021 */
    public void sentar() {

        boolean sentado = false;

        while (!sentado) { //se itera hasta que se consiga asignar un asiento

            //numero de butaca random
            int fil = rand.nextInt(0, this.getNumFilas());
            int col = rand.nextInt(0, this.getNumColumnas());
            numAleatorios++; //aumenta el contador de numeros aleatorios generados(solo para medir eficiencia)

            //evaluacion de si el asiento esta vacio
            if (this.getArrayAsientos()[fil][col] == '-') {
                //si el asiento esta libre ('-'), se asigna como ocupado y se sale del bucle
                this.asignarAsiento(fil, col);
                sentado = true;
            }
            //si no se consigue asignar el asiento, se vuelve a intentar en la proxima iteracion
        }
    }

    //metodo que imprime el array de asientos
    public void imprimirTodoArray(){
        for (int i=0; i<this.getNumFilas(); i++){
            for (int j=0; j<this.getNumColumnas();j++){
                System.out.print(this.getArrayAsientos()[i][j]);
            }
            System.out.println();
        }
    }
    //metodos getters y setters

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
}
