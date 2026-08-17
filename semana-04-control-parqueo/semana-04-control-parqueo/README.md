# Control de Parqueo

## Datos del estudiante

**Nombre completo:** Dylan Sneyder Garcia Sosa  
**Carné:** 9941-25-21652

## Descripción de la solución

El programa Control de Parqueo permite registrar varios vehículos que utilizan un parqueo y calcular el pago correspondiente según el tipo de vehículo y el tiempo que permaneció estacionado.

El programa solicita la placa, tipo de vehículo, hora y minuto de entrada, hora y minuto de salida, y si el conductor perdió el ticket.

Las tarifas utilizadas son:

- Motocicleta: Q5.00 por hora.
- Automóvil: Q8.00 por hora.
- Pickup o camioneta: Q12.00 por hora.

Cuando el vehículo permanece más de 8 horas, se aplica un descuento del 15 % sobre el subtotal. Si el conductor perdió el ticket, se agrega un recargo de Q50.00 después de aplicar el descuento.

Al finalizar, el programa muestra un resumen de la jornada con la cantidad de vehículos de cada tipo, tickets perdidos, total recaudado y el vehículo que realizó el pago más alto.

## Métodos creados

### obtenerTarifa()

Obtiene la tarifa por hora según el tipo de vehículo.

### obtenerNombreVehiculo()

Obtiene el nombre del vehículo según el tipo seleccionado.

### calcularDescuento()

Calcula el descuento del 15 % cuando el vehículo permanece más de 8 horas.

### calcularPago(int horas, double tarifa)

Calcula el pago cuando no existe un recargo por ticket perdido.

### calcularPago(int horas, double tarifa, double recargo)

Calcula el pago cuando existe un recargo por ticket perdido.

### mostrarComprobante()

Muestra el comprobante de cada vehículo con sus datos, tiempo estacionado, tarifa, subtotal, descuento, recargo y total.

### solicitarHora()

Solicita y valida una hora entre 0 y 23.

### solicitarMinuto()

Solicita y valida los minutos entre 0 y 59.

### calcularMinutosEstacionado()

Calcula el tiempo total estacionado en minutos y permite calcular correctamente el tiempo cuando el vehículo sale al día siguiente.

## Sobrecarga de métodos

La sobrecarga se aplicó en el método `calcularPago`.

Se crearon dos métodos con el mismo nombre pero diferente cantidad de parámetros:

- `calcularPago(int horas, double tarifa)`
- `calcularPago(int horas, double tarifa, double recargo)`

Esto constituye una sobrecarga real de métodos.

## Casos de prueba

### Ejecución normal

Se probó un automóvil durante 5 horas sin perder el ticket.

Resultado:

- Subtotal: Q40.00
- Descuento: Q0.00
- Recargo: Q0.00
- Total: Q40.00

### Descuento y ticket perdido

Se probó un automóvil durante 10 horas con ticket perdido.

Resultado:

- Subtotal: Q80.00
- Descuento: Q12.00
- Recargo: Q50.00
- Total: Q118.00

### Validación de datos

Se probaron valores incorrectos para verificar las validaciones del programa.

El programa valida:

- Cantidad de vehículos mayor que cero.
- Tipo de vehículo entre 1 y 3.
- Horas y minutos dentro de los rangos permitidos.
- Ticket únicamente con S o N.

### Control exacto del tiempo

Se probó una entrada a las 22:30 y una salida a las 02:10 del día siguiente.

Resultado:

- Tiempo estacionado: 3 horas y 40 minutos.
- Horas cobradas: 4.

## Reto opcional

**Realizado.**

Se implementó el control exacto del tiempo mediante hora y minuto de entrada y salida.

El programa calcula correctamente el tiempo cuando el vehículo sale al día siguiente y cobra como una hora completa cualquier fracción de hora.