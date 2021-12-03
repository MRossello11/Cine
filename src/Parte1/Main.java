package Parte1;

public class Main {
    public static void main(String[] args) {
        Cine c1 = new Cine("Ocimax",150);
        System.out.println(c1.getNombre());
        System.out.println(c1.getNumAsientos());
        c1.crearAsientos();



        System.out.println(c1.getArrayAsientos());
        /*
        Boolean lleno=false;
        while (!lleno){


        }
        //c1.ImprimirTodoArray();
        c1.AsignarAsient(0,0);
        c1.ImprimirTodoArray();

         */
    }
}
