package ar.edu.unahur.obj2.banco.comandos;

import java.util.ArrayList;
import java.util.List;

//Clase que administra y ejecuta los comandos de manera individual o multiple.

public class Invoker {
    //private IComando comando; -> Esto es si quiero que el invoker ejecute de manera individual, aunque tambien sirve el que hicimos en el ejercicio que es multiple.

    //Forma de hacerlo multiple, pero tambien ejecuta de manera individual si es necesario.
    private List<IComando> comandos = new ArrayList<>();
    private List<IComando> UltimosComandos = new ArrayList<>();

    /*Lo comentamos asi se inicializa vacio el invoker y no te pide que le pases una lista de comandos por defecto.
    
    public Invoker(List<IComando> comandos) {
        this.comandos = comandos;
    } //Esto es por si queres inicializarlo ya con una lista de comandos.
    
    */

     
    public void agregarComando(IComando comando){
        this.comandos.add(comando);
    }
    

    public void ejecutarLote(){
        comandos.forEach(IComando::ejecutar); //otra forma de hacer el closure del forEach
        comandos.forEach(c -> UltimosComandos.add(c)); //Guardo en otra lista los comandos por si hay que revertir.
        comandos.clear();//Borra la lista de comando despues de ejecutar los comandos.
    }

    public void revertirUltimaEjecucion(){
        UltimosComandos.forEach(IComando::deshacer);
    }
    
}
