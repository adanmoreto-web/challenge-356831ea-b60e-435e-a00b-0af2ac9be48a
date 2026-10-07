# Aplicación de Patrones GRASP en un Sistema de Gestión de Cuentas

El sistema de gestión de cuentas de una institución financiera necesita ser refactorizado para aplicar patrones GRASP que mejoren su estructura y mantenibilidad. Los patrones a aplicar incluyen Experto en Información, Creador, Controlador, Alta Cohesión y Bajo Acoplamiento, Polimorfismo, Fabricación Pura, Indirección y Variaciones Protegidas. El sistema actual maneja cuentas de clientes, permitiendo operaciones de depósito, retiro y consulta de saldo. Debes identificar las responsabilidades y aplicar los patrones mencionados para mejorar el diseño.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | aplicación de patrones GRASP en el desarrollo de sistemas |
| **Nivel** | advanced-l2 |
| **Tipo** | mixed |
| **Tiempo estimado** | 10 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Análisis del Sistema Actual

**Objetivo:** Identificar las responsabilidades y puntos de mejora en el sistema actual

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Revisar el sistema actual de gestión de cuentas y documentar las responsabilidades de cada componente.
- Identificar áreas donde se pueden aplicar los patrones GRASP para mejorar la estructura y mantenibilidad del sistema.

**Entregable:** Documento que describe las responsabilidades actuales y áreas de mejora.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la separación de responsabilidades y cómo los patrones GRASP pueden ayudar a lograrlo.

</details>

### Fase 2: Aplicación de Patrones GRASP

**Objetivo:** Refactorizar el sistema aplicando los patrones GRASP seleccionados

**Tiempo estimado:** 6 horas

**Instrucciones:**

- Aplicar los patrones GRASP Experto en Información, Creador, Controlador, Alta Cohesión y Bajo Acoplamiento, Polimorfismo, Fabricación Pura, Indirección y Variaciones Protegidas en el sistema de gestión de cuentas.
- Documentar los cambios realizados y cómo estos mejoran el diseño del sistema.

**Entregable:** Código refactorizado con patrones GRASP aplicados y documentación de los cambios.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que el patrón Experto en Información sugiere que la responsabilidad de manipular datos debe estar en la clase que contiene esos datos.
- El patrón Creador sugiere que la responsabilidad de crear un objeto debe estar en una clase separada.

</details>

### Fase 3: Evaluación y Retroalimentación

**Objetivo:** Evaluar los cambios realizados y recibir retroalimentación

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Evaluar el sistema refactorizado para asegurar que los patrones GRASP han sido aplicados correctamente y han mejorado el diseño.
- Recibir retroalimentación de un revisor y documentar cualquier cambio adicional necesario.

**Entregable:** Evaluación del sistema refactorizado y documento de retroalimentación.

<details>
<summary>Pistas de conocimiento</summary>

- Considera realizar pruebas unitarias para validar que los cambios realizados no han introducido nuevos errores.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los patrones GRASP y por qué son importantes en el diseño de sistemas?
- **paraQueSirve**: ¿Cómo aplicas el patrón Experto en Información en el sistema de gestión de cuentas?
- **comoSeUsa**: ¿Cómo utilizas el patrón Creador para mejorar la creación de objetos en el sistema?
- **erroresComunes**: ¿Qué errores comunes se pueden cometer al aplicar los patrones GRASP?
- **queDecisionesImplica**: ¿Qué decisiones implica la aplicación de los patrones GRASP en el diseño del sistema?

## Criterios de Evaluacion

- Identificar correctamente las responsabilidades en el sistema actual.
- Aplicar correctamente los patrones GRASP en el sistema de gestión de cuentas.
- Documentar los cambios realizados y cómo estos mejoran el diseño del sistema.
- Evaluar el sistema refactorizado y recibir retroalimentación.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
