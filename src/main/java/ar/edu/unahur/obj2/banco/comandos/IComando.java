package ar.edu.unahur.obj2.banco.comandos;
//Minimo tiene que existir el comando ejecutar, deshacer esta porque nos lo pide el ejercicio.

public interface IComando {
    void ejecutar();//Ejecuta una operacion.
    void deshacer(); //Ultimo comando que ejecute lo deshace.
}
