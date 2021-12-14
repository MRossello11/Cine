/**
 * @author MRossello11
 * @version 1.2
 * @since 09/12/2021
 * @description clase Sala del proyecto Cine*/
package Parte2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sala {
    private Random rand = new Random();
    private int numAsientos;
    private int numFilas;
    private int numColumnas;
    private char arrayAsientos[][];
    private static int numAleatorios = 0;
    private List<Asiento> asientos = new ArrayList<Asiento>();
    private Pelicula p;
    private int asientosOcupados = 0; //contador de asientos que se han asignado

    //constructor
    public Sala(int numAsientos){
        this.numAsientos = numAsientos; //numero de asientos del cine
        this.numFilas = crearFilas(); //filas
        this.numColumnas = crearColumnas(); //columnas
        this.arrayAsientos = new char[numFilas][numColumnas]; //array de los asientos
        this.crearAsientos();
        this.p = new Pelicula();
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
                this.asientos.add(new Asiento(i,j));
            }
        }
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

        boolean sentado = false; //evalua si el espectador tiene asiento asignado (se ha podido sentar) o no

        Espectador e = new Espectador(); //creacion del objeto espectador

        while (!sentado) { //se itera hasta que se consiga asignar un asiento

            //evaluar que el espectador tiene dinero suficiente
            if (e.getDinero()<=Asiento.getPrecio()){ //7.5 es el precio estandar mas adelante este variara segun el asiento
                System.out.println("El espectador no tiene dinero suficiente");
                break;
            }
            //evaluar que el espectador tiene la edad suficiente para ver la pelicula en cuestion
            if (e.getEdad() < this.p.getEdadMinima()){
                System.out.println("El espectador no tiene la edad suficiente para ver la pelicula " + this.p.getNombre());
            }
            Cine.dineroRecolectado += Asiento.getPrecio();

            //numero de butaca random
            int fil = rand.nextInt(0, this.getNumFilas());
            int col = rand.nextInt(0, this.getNumColumnas());
            numAleatorios++; //aumenta el contador de numeros aleatorios generados(solo para medir eficiencia)

            //evaluacion de si el asiento esta vacio
            if (this.getArrayAsientos()[fil][col] == '-') {
                //si el asiento esta libre ('-'), se asigna como ocupado y se sale del bucle
                this.asignarAsiento(fil, col);
                sentado = true;
                asientosOcupados++; //al sentar a alguien, se aumenta el numero de asientos ocupados
            }
            //si no se consigue asignar el asiento, se vuelve a intentar en la proxima iteracion
        }
    }

    //metodo que imprime el array de asientos
    public void imprimirTodoArray(){
        for (int i=0; i<this.getNumFilas(); i++){ //bucle por cada fila
            for (int j=0; j<this.getNumColumnas();j++){ //bucle por cada columna en cada fila
                System.out.print(this.getArrayAsientos()[i][j]); //imprime cada asiento uno al lado del otro
            }
            System.out.println();
        }
    }

    //getters y setters

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

    public static int getNumAleatorios() {
        return numAleatorios;
    }

    public int getAsientosOcupados() {
        return asientosOcupados;
    }

    public Pelicula getP(){
        return p;
    }
}
