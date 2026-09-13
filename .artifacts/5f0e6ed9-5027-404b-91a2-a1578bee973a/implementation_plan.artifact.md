# Rediseño Visual de Registro de Incidencias

Rediseñar la pantalla `RegistroIncidencias` para adoptar una estética moderna de "Get Started" con un encabezado decorativo y una tarjeta central, manteniendo la lógica original.

## User Review Required

> [!IMPORTANT]
> Se mantendrá exactamente la misma lógica de negocio y variables solicitadas. El cambio es puramente estético en la estructura de la UI.

## Proposed Changes

### [Component Name] UI Redesign

#### [MODIFY] [MainActivity.kt](file:///C:/Users/trued/AndroidStudioProjects/RegistrodeIncidencias/app/src/main/java/com/example/registrodeincidencias/MainActivity.kt)
- Actualizar `RegistroIncidencias()` con una estructura de `Box` para superponer el fondo decorativo y la tarjeta blanca.
- Implementar el encabezado con gradiente y formas abstractas usando `Canvas`.
- Estilizar los campos de texto y el botón según las especificaciones de colores y formas.
- Asegurar que todas las importaciones necesarias (Canvas, Brush, RoundedCornerShape, etc.) estén presentes.

## Verification Plan

### Automated Tests
- No hay pruebas unitarias existentes, pero se verificará la compilación mediante `gradle build` o similar si es posible, o simplemente asegurando que no falten símbolos.

### Manual Verification
- Renderizar la vista previa `RegistroIncidenciasPreview` para confirmar que el diseño coincide con la descripción visual.
- Probar la funcionalidad en el emulador (si el usuario lo hace) para asegurar que el botón sigue funcionando y el mensaje cambia a verde al crear la incidencia.
