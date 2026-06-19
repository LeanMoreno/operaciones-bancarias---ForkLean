package ar.edu.unahur.obj2.banco;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.banco.observadores.IObservadorCuenta;

//En el patron commander hay un objeto el cual conoce los metodos retirar y depositar para que este pueda recordar las operaciones en caso que se tenga que deshacer la operacion.

public class Cuenta {
    private final Integer numero;
    private Double saldo;
    private List<IObservadorCuenta> observadores = new ArrayList<>();
    
    public Cuenta(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double monto){
        this.saldo += monto;
        notificar(new Deposito(), monto);
    }

    public void retirar(Double monto){
        this.saldo -= monto;
        notificar(new Retiro(), monto);
    }

    private void notificar(IOperacion operacion, Double monto) {
        observadores.forEach(o -> o.notificar(this, operacion, monto));
    }

    public void agregarObservador(IObservadorCuenta observador){
        observadores.add(observador);
    }
    
    public void quitarObservador(IObservadorCuenta observador){
        observadores.remove(observador);
    }
}
