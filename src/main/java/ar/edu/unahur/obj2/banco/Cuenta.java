package ar.edu.unahur.obj2.banco;

//En el patron commander hay un objeto el cual conoce los metodos retirar y depositar para que este pueda recordar las operaciones en caso que se tenga que deshacer la operacion.

public class Cuenta {
    private final Integer numero;
    private Double saldo;
    
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
    }

    public void retirar(Double monto){
        this.saldo -= monto;
    }
    
}
