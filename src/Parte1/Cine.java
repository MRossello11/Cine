package Parte1;

import java.util.Random;

public class Cine {
    public Random rand = new Random();
    private String nombre;
    private int numAsientos;
    private int numFilas;
    private int numColumnas;
    private char arrayAsientos[][];


    //constructor
    public Cine(String nombre, int numAsientos){
        this.nombre = nombre;
        this.numAsientos = numAsientos;
        this.numFilas = crearFilas();
        this.numColumnas = crearColumnas();
        this.arrayAsientos = new char[numFilas][numColumnas];
    }

    public int crearFilas(){
        numFilas = numAsientos/rand.nextInt(1, numAsientos); //asignar #filas
       return numFilas;
    }

    public int crearColumnas(){
        if (this.numAsientos%numFilas == 0){
            numColumnas = this.numAsientos/this.numFilas;
        }else{
            numColumnas = this.numAsientos/this.numFilas + 1;
        }

        return numColumnas;
    }

    public void crearAsientos(){
        System.out.println("Filas: " + this.numFilas);
        System.out.println("Columnas: " + this.numColumnas);

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

    public void asignarAsiento(int f, int c){
        this.arrayAsientos[f][c] = 'x';
    }

    /*
    genera numeros aleatorios (filas y columnas) e intenta asignar un asiento para esa iteracion,
    si el asiento esta ocupado, se vuelve a intentar asignar un asiento en la siguiente iteracion
    @since 03/12/2021 */
    public void sentar() {
        boolean sentado = false;

        while (!sentado) {
            //numero de butaca random
            int fil = rand.nextInt(0, this.getNumFilas());
            int col = rand.nextInt(0, this.getNumColumnas());
            if (this.getArrayAsientos()[fil][col] == '-') {
                this.asignarAsiento(fil, col);
                sentado = true;
            }
        }
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

    public void imprimirTodoArray(){
        for (int i=0; i<this.getNumFilas(); i++){
            for (int j=0; j<this.getNumColumnas();j++){
                System.out.print(this.getArrayAsientos()[i][j]);
            }
            System.out.println();
        }
    }
}
