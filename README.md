# Registro de Incidencias by SARA PORTILLO

## Propósito

**RegistroIncidencias** es una aplicación móvil para Android que permite al usuario registrar una incidencia mediante un título, una descripción breve y una prioridad.

La aplicación cuenta con una pantalla principal donde el usuario puede ingresar la información, seleccionar el nivel de prioridad y presionar el botón **"Crear Reporte"**. Al hacerlo, se muestra un mensaje de confirmación indicando que el reporte fue creado.

Además, incorpora una sección de monitor de movimiento que permite visualizar las lecturas del acelerómetro del dispositivo.

## Funcionalidades actuales

La aplicación permite:

* Ingresar el **título de la incidencia**.
* Ingresar una **descripción breve** de la incidencia.
* Utilizar un teclado configurado según el tipo de información ingresada.
* Utilizar capitalización de oraciones en los campos de texto.
* Utilizar las acciones **Next** y **Done** del teclado.
* Seleccionar la prioridad entre Baja, Media y Alta.
* Seleccionar la prioridad mediante interacción táctil utilizando `Modifier.clickable`.
* Mostrar visualmente la prioridad seleccionada.
* Mostrar un mensaje de retroalimentación indicando la prioridad seleccionada.
* Presionar el botón **"Crear Reporte"**.
* Mostrar un mensaje de confirmación con el título y la prioridad de la incidencia.
* Mostrar el mensaje de confirmación en color verde y negrita.
* Limpiar automáticamente los campos de título y descripción después de crear el reporte.
* Quitar el foco de los campos de texto después de crear el reporte.
* Visualizar los valores X, Y y Z del acelerómetro.
* Mostrar el estado de disponibilidad del sensor.
* Actualizar las lecturas cuando se reciben nuevos eventos del acelerómetro.
* Liberar el listener del sensor cuando el componente deja de utilizarse.

## Configuración de entrada de texto

Los campos de entrada utilizan `KeyboardOptions` para adaptar el comportamiento del teclado al contexto de la información.

El campo **Título de la incidencia** utiliza:

* `KeyboardType.Text`
* `KeyboardCapitalization.Sentences`
* `ImeAction.Next`

El campo **Descripción breve** utiliza:

* `KeyboardType.Text`
* `KeyboardCapitalization.Sentences`
* `ImeAction.Done`

Esta configuración permite utilizar un teclado adecuado para la información que debe ingresar el usuario y facilita la navegación entre los campos.

## Interacción táctil

Se incorporó una sección de selección de prioridad con tres opciones:

* **Baja**
* **Media**
* **Alta**

La selección se realiza mediante `Modifier.clickable`, debido a que la aplicación necesita detectar un toque sobre cada opción.

No se utiliza `pointerInput`, ya que no es necesario implementar un gesto personalizado.

Al seleccionar una prioridad, la aplicación actualiza el estado de la opción seleccionada y muestra una retroalimentación visible al usuario.

## Integración del acelerómetro

Se incorporó una sección denominada **"Monitor de movimiento"**, que permite observar las lecturas del acelerómetro del dispositivo Android.

### Configuración del sensor

Para integrar el acelerómetro se utilizaron los siguientes componentes:

* `SensorManager`: permite acceder al servicio de sensores de Android.
* `Sensor.TYPE_ACCELEROMETER`: permite obtener el acelerómetro del dispositivo.
* `SensorEventListener`: recibe los eventos y las lecturas del sensor.
* `SensorManager.SENSOR_DELAY_NORMAL`: establece la frecuencia de lectura solicitada.
* `DisposableEffect`: administra el registro del listener y permite liberarlo cuando el componente deja de utilizarse.

Los valores obtenidos corresponden a los ejes X, Y y Z, expresados en metros por segundo al cuadrado (m/s²).

### Retroalimentación visible

La interfaz muestra:

* El estado del acelerómetro.
* El valor actual del eje X.
* El valor actual del eje Y.
* El valor actual del eje Z.
* Un mensaje que indica al usuario que puede mover el dispositivo para observar los cambios.

La aplicación también contempla el caso en que el sensor no esté disponible o no se pueda iniciar la lectura.

### Propósito y limitaciones

Esta integración permite demostrar el acceso a un sensor físico y la visualización de sus datos mediante Jetpack Compose.

Las lecturas del acelerómetro no permiten determinar por sí solas si ocurrió una caída o una incidencia. Por el momento, el sensor funciona como una demostración inicial de captura de movimiento y no modifica el registro de incidencias.

Como mejora futura, se podría evaluar el uso de datos de movimiento como información contextual en reportes relacionados con dispositivos móviles.

## Retroalimentación

La aplicación muestra mensajes de acuerdo con las acciones realizadas.

Al seleccionar una prioridad, se muestra un mensaje como:

**"Prioridad seleccionada: Alta"**

Al crear correctamente una incidencia, se muestra un mensaje como:

**"Reporte creado: Error al iniciar sesión | Prioridad: Alta"**

En la sección del acelerómetro se muestran los valores de los tres ejes y el estado del sensor.

Esto permite comprobar visualmente la respuesta de la aplicación ante las interacciones del usuario y la recepción de lecturas del sensor.

## Herramientas utilizadas

* **Android Studio**
* **Kotlin**
* **Jetpack Compose**
* **SensorManager y SensorEventListener**
* **Git**
* **GitHub**

## Estado actual

**Implementado:**

* Interfaz principal de la aplicación.
* Campos para el título y la descripción de la incidencia.
* Configuración contextual del teclado.
* Capitalización de oraciones y acciones IME Next y Done.
* Selección de prioridad Baja, Media y Alta.
* Interacción táctil mediante `Modifier.clickable`.
* Retroalimentación visual de la prioridad seleccionada.
* Validación de campos requeridos.
* Botón para crear el reporte.
* Mensaje de confirmación con el título y la prioridad.
* Mensaje de confirmación en color verde y negrita.
* Limpieza automática de los campos después de crear el reporte.
* Monitor de movimiento mediante el acelerómetro.
* Visualización de las lecturas X, Y y Z.
* Mensajes para indicar el estado y la disponibilidad del sensor.
* Gestión del ciclo de vida del listener mediante `DisposableEffect`.

**Pendiente:**

* Guardar las incidencias de forma permanente.
* Implementar una base de datos.
* Mostrar y administrar las incidencias registradas.
* Evaluar futuras funcionalidades que aprovechen los datos del acelerómetro.

## Avance de la semana

Durante esta semana se integró una primera funcionalidad de sensores en la aplicación:

* Se incorporó el acelerómetro mediante `SensorManager`.
* Se implementó `SensorEventListener` para recibir las lecturas del sensor.
* Se agregaron los valores de los ejes X, Y y Z a la interfaz.
* Se incorporó retroalimentación visible sobre el estado del sensor.
* Se agregó una validación para contemplar la ausencia del acelerómetro o la imposibilidad de iniciar la lectura.
* Se utilizó `DisposableEffect` para administrar el registro y la liberación del listener.
* Se preparó la aplicación para verificar las lecturas en un dispositivo físico o emulador compatible.

## Cómo abrir el proyecto

1. Abrir **Android Studio**.
2. Seleccionar **Open**.
3. Elegir la carpeta del proyecto `RegistrodeIncidencias`.
4. Esperar la sincronización de Gradle.
5. Ejecutar la aplicación en un emulador o dispositivo Android.
6. Comprobar el funcionamiento del formulario y la sección del monitor de movimiento.

## Autor

**Sara Portillo**

Proyecto académico.