# 🏦 Banco y operaciones

Un banco necesita implementar un sistema que permita registrar distintas operaciones sobre cuentas bancarias y ejecutarlas posteriormente.

Además, el sistema deberá evolucionar para que otros componentes puedan enterarse automáticamente cuando ocurran movimientos en una cuenta.

---

# 👨‍🏫 Primera Parte - Operaciones bancarias

## 📋 Requerimientos

### 🏦 Cuenta bancaria

De cada cuenta se conoce:

* Número de cuenta
* Saldo disponible

Una cuenta debe permitir:

* Consultar su saldo.
* Depositar dinero.
* Retirar dinero.

---

### 💸 Operaciones

El sistema debe soportar inicialmente las siguientes operaciones:

* Depósito
* Retiro

Cada operación conoce:

* La cuenta sobre la que actúa.
* El monto involucrado.

#### 📌 Ejemplo

```txt
Depositar $3000 en la cuenta 1234

```

```txt
Retirar $5000 de la cuenta 1234

```

---

### 📋 Administrador de operaciones

El banco cuenta con un componente responsable de administrar operaciones, pudiendo ejecutar operaciones individuales o pendientes por lote.

Este componente debe permitir:

* Ejecutar una operación individual.
* Registrar operaciones en un lote.
* Ejecutar todas las operaciones registradas.
* Vaciar el listado de operaciones pendientes luego de ejecutarlas.

---

### 📌 Ejemplo de uso

**Dada una cuenta con saldo inicial:**

```txt
$10000

```

#### Si se registran las siguientes operaciones individuales:

```txt
Depositar $70000
Retirar $5000
Retirar $16000
Depositar $9000

```

* **Al ejecutarlas, los saldos deberían evolucionar de la siguiente manera:**

```txt
Saldo inicial: 10000

Depositar 70000
Saldo: 80000

Retirar 5000
Saldo: 75000

Retirar 16000
Saldo: 59000

Depositar 9000
Saldo: 68000

```

#### Si durante la noche, por ejemplo, se registran las siguientes operaciones por lote:

```txt
Retirar $5000
Depositar $300000
Retirar $50000

```

Al ejecutarlas, los saldos deberían evolucionar de la siguiente manera:

```txt
Saldo inicial: 68000

Retirar 5000
Saldo: 63000

Depositar 300000
Saldo: 363000

Depositar 50000
Saldo: 313000

```

---

## ¿Qué pasa si queremos deshacer una operación?

* ¿Es posible revertir un comando?
* ¿Cómo lo podemos implementar?
* ¿De quién es la responsabilidad de saber deshacer una operación?

---

### ⚙️ Restricciones de Diseño

* El administrador de operaciones no debe conocer cómo se implementa cada operación.
* Debe ser posible incorporar nuevos tipos de operaciones sin modificar el administrador.
* Las responsabilidades deben quedar correctamente distribuidas entre objetos.
* Evitar soluciones basadas en condicionales (`if` / `switch`) para distinguir tipos de operaciones.
* Las operaciones deben poder almacenarse y ejecutarse por lotes en un momento posterior.
* Cada operación debe poder deshacer su transformación.

---

# 👨‍🏫 Segunda Parte - Notificaciones automáticas

El banco desea incorporar nuevos sistemas que reaccionen automáticamente cuando una cuenta tenga movimientos.

Para este ejemplo:

* Un sistema de auditoría que registra las operaciones de todas las cuentas.
* Notificaciones a cada cliente, siempre que haya un nuevo movimiento en su cuenta.

---

## 📢 Observadores de cuentas

Cada vez que una cuenta reciba un depósito o un retiro, los sistemas interesados deben ser informados automáticamente.

La cuenta debe permitir:

* Registrar observadores.
* Eliminar observadores.
* Notificar a todos los observadores cuando ocurra un movimiento.

---

## 🔍 Auditoría

El sistema de auditoría registra todos los movimientos realizados sobre las cuentas.

### 📌 Ejemplo

Si se realiza:

```txt
Depositar $3000 en la cuenta 1234

```

La auditoría debería recibir información suficiente para registrar el evento.

---

## 📱 Notificaciones al cliente

También informa al cliente cada vez que ocurre un movimiento en su cuenta.

### 📌 Ejemplo

```txt
Se acreditaron $3000 en su cuenta.

```

```txt
Se debitaron $5000 de su cuenta.

```

---

## 🚨 Alertas de saldo

* Se desea incorporar un sistema que detecte cuándo una cuenta queda por debajo de un saldo mínimo que es cero.
* La alerta solo "reacciona" si la operación fue exitosa y el saldo quedó negativo.
* Se admite un descubierto de hasta $50000 (saldo negativo), no se permite realizar extracciones que dejen la cuenta con menos de ese saldo.

### 📌 Ejemplo

Si luego de una operación el saldo queda en:

```txt
- $750

```

el sistema debe generar una alerta.

---

## ⚙️ Restricciones de Diseño

* La cuenta no debe conocer los detalles de implementación de los sistemas externos.
* Debe ser posible incorporar nuevos tipos de observadores sin modificar la clase Cuenta.
* Un mismo movimiento puede generar múltiples notificaciones.
* Los observadores deben reaccionar automáticamente cuando cambia el estado de una cuenta.
* Evitar soluciones basadas en condicionales (`if` / `switch`) para distinguir tipos de observadores.

---

## 💡 Ayuda

Pensar:

* ¿Qué tienen en común todas las operaciones?
* ¿Cómo podría representarse una operación como un objeto?
* ¿Quién debería ejecutar una operación?
* ¿Cómo puede una cuenta informar cambios sin conocer quiénes están interesados?
* ¿Cómo agregar nuevos sistemas de notificación sin modificar las cuentas existentes?

---
