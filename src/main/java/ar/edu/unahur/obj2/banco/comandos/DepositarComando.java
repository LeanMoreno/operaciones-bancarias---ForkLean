package ar.edu.unahur.obj2.banco.comandos;

import ar.edu.unahur.obj2.banco.Cuenta;

public class DepositarComando implements IComando{
    private final Cuenta cuenta; //Cada comando debe conocer al receptor, en este caso es la cuenta bancaria. Es final porque cada comando es un objeto el cual acciona sobre una cuenta especifica.
    
    private Double monto;

    public DepositarComando(Cuenta cuenta, Double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        cuenta.depositar(monto);
    }

    @Override
    public void deshacer() {
        cuenta.retirar(monto);
    }

}
