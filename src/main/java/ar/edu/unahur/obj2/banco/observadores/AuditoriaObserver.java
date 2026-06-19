package ar.edu.unahur.obj2.banco.observadores;

import ar.edu.unahur.obj2.banco.Cuenta;
import ar.edu.unahur.obj2.banco.IOperacion;

//La auditoria registra todos los movimientos.

public class AuditoriaObserver implements IObservadorCuenta{

    @Override
    public void notificar(Cuenta cuenta, IOperacion operacion, Double monto) {
        System.out.println(
            "[Auditoria] cuenta" + cuenta.getNumero() + "-" + operacion.descripcion() + "$" + monto
        );
    }

}
