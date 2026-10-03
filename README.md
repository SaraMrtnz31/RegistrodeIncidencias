# Registro de Incidencias by SARA PORTILLO

## Propósito

**RegistroIncidencias** es una aplicación móvil para Android que permite al usuario registrar una incidencia de manera sencilla mediante un título, una descripción breve y una prioridad.

La aplicación cuenta con una pantalla principal donde el usuario puede ingresar la información de la incidencia, seleccionar su nivel de prioridad y presionar el botón **"Crear Reporte"**. Al hacerlo, se muestra un mensaje de confirmación indicando que el reporte fue creado.

## Funcionalidades actuales

La aplicación permite:

* Ingresar el **título de la incidencia**.
* Ingresar una **descripción breve** de la incidencia.
* Utilizar un teclado configurado de acuerdo con el tipo de información ingresada.
* Utilizar **capitalización de oraciones** en los campos de texto.
* Utilizar las acciones **Next** y **Done** del teclado según el flujo de los campos.
* Seleccionar la **prioridad de la incidencia** entre Baja, Media y Alta.
* Seleccionar la prioridad mediante una interacción táctil utilizando `Modifier.clickable`.
* Mostrar visualmente la prioridad seleccionada.
* Mostrar un mensaje de retroalimentación indicando la prioridad seleccionada.
* Presionar el botón **"Crear Reporte"**.
* Mostrar un mensaje de confirmación con el título y la prioridad de la incidencia.
* Mostrar el mensaje de confirmación en **color verde y negrita**.
* Limpiar automáticamente los campos de título y descripción después de crear el reporte.
* Quitar el foco de los campos de texto después de crear el reporte.

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

La selección se realiza mediante `Modifier.clickable`, debido a que la aplicación solamente necesita detectar un toque sobre cada opción.

No se utiliza `pointerInput`, ya que no es necesario implementar un gesto personalizado.

Al seleccionar una prioridad, la aplicación actualiza el estado de la opción seleccionada y muestra una retroalimentación visible al usuario.

## Retroalimentación

La aplicación muestra mensajes de acuerdo con las acciones realizadas.

Al seleccionar una prioridad, se muestra un mensaje como:

**"Prioridad seleccionada: Alta"**

Al crear correctamente una incidencia, se muestra un mensaje como:

**"Reporte creado: Error al iniciar sesión | Prioridad: Alta"**

Esto permite comprobar visualmente que la selección realizada por el usuario fue registrada correctamente.

## Herramientas utilizadas

* **Android Studio**
* **Kotlin**
* **Jetpack Compose**
* **Git**
* **GitHub**

## Estado actual

**Funcionando:**

* Interfaz principal de la aplicación.
* Campo para ingresar el título de la incidencia.
* Campo para ingresar una descripción breve.
* Configuración contextual del teclado.
* Capitalización de oraciones en los campos de texto.
* Acciones IME `Next` y `Done`.
* Selección de prioridad Baja, Media y Alta.
* Interacción táctil mediante `Modifier.clickable`.
* Retroalimentación visual de la prioridad seleccionada.
* Botón para crear el reporte.
* Mensaje de confirmación después de crear el reporte.
* Inclusión de la prioridad en el reporte creado.
* Mensaje de confirmación en color verde y negrita.
* Limpieza automática de los campos después de crear el reporte.
* Eliminación del foco de los campos después de crear el reporte.
* Ejecución y comprobación de la aplicación mediante emulador.

**Pendiente:**

* Guardar las incidencias de forma permanente.
* Implementar una base de datos.
* Mostrar y administrar las incidencias registradas.

## Avance de la semana

Durante esta semana se realizaron mejoras en la interacción de la aplicación:

* Se configuró la entrada de texto mediante `KeyboardOptions`.
* Se agregaron acciones IME coherentes con el flujo de la pantalla.
* Se incorporó la selección de prioridad mediante interacción táctil.
* Se utilizó `Modifier.clickable` para detectar la selección de las opciones.
* Se agregó retroalimentación visible para comprobar la opción seleccionada.
* Se probó la aplicación mediante ejecución real en un emulador.
* Se actualizaron los cambios en el repositorio de GitHub.

## Cómo abrir el proyecto

1. Abrir **Android Studio**.
2. Seleccionar **Open**.
3. Elegir la carpeta del proyecto `RegistrodeIncidencias`.
4. Esperar la sincronización de Gradle.
5. Ejecutar la aplicación en un emulador o dispositivo Android.

## Autor

**Sara Portillo**

Proyecto académico.
