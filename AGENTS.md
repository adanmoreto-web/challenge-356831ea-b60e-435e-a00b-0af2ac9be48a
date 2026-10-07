# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Aplicación de Patrones GRASP en un Sistema de Gestión de Cuentas**.

| | |
|---|---|
| Tema | aplicación de patrones GRASP en el desarrollo de sistemas |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean |
| Tiempo estimado | 10 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.projectlombok:lombok 1.18.30
- com.h2database:h2 2.2.224
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.9.1

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Análisis del Sistema Actual**: Documento que describe las responsabilidades actuales y áreas de mejora.
- **Fase 2 — Aplicación de Patrones GRASP**: Código refactorizado con patrones GRASP aplicados y documentación de los cambios.
- **Fase 3 — Evaluación y Retroalimentación**: Evaluación del sistema refactorizado y documento de retroalimentación.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (33)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountService.java` — `Account.getBalance`
      Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountService.java` — `Account.setStatus`
      Se invoca `setStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getId`
      Se invoca `getId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getAccountNumber`
      Se invoca `getAccountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getCustomerId`
      Se invoca `getCustomerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getBalance`
      Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getOpeningDate`
      Se invoca `getOpeningDate` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getAccountType`
      Se invoca `getAccountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getStatus`
      Se invoca `getStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java` — `Account.getBalance`
      Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java` — `Account.getStatus`
      Se invoca `getStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java` — `Account.getOpeningDate`
      Se invoca `getOpeningDate` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java` — `Account.getAccountType`
      Se invoca `getAccountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountControllerFacade.java` — `Account.getBalance`
      Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `AccountDto.getAccountNumber`
      Se invoca `getAccountNumber` sobre `AccountDto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `AccountDto.getCustomerId`
      Se invoca `getCustomerId` sobre `AccountDto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `AccountDto.getInitialBalance`
      Se invoca `getInitialBalance` sobre `AccountDto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `AccountDto.getAccountType`
      Se invoca `getAccountType` sobre `AccountDto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setTimestamp`
      Se invoca `setTimestamp` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setStatus`
      Se invoca `setStatus` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setError`
      Se invoca `setError` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setMessage`
      Se invoca `setMessage` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setErrorCode`
      Se invoca `setErrorCode` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setPath`
      Se invoca `setPath` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setDetails`
      Se invoca `setDetails` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.getAccountNumber`
      Se invoca `getAccountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.getCustomerId`
      Se invoca `getCustomerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.getBalance`
      Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.getAccountType`
      Se invoca `getAccountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.size`
      Se invoca `size` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.get`
      Se invoca `get` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.isEmpty`
      Se invoca `isEmpty` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (16)

- `pom.xml`
- `src/main/java/com/pragma/accountmanagement/AccountManagementApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/accountmanagement/domain/model/Account.java`
- `src/main/java/com/pragma/accountmanagement/domain/ports/AccountRepository.java`
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountService.java`
- `src/main/java/com/pragma/accountmanagement/infrastructure/adapters/JpaAccountRepository.java`
- `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java`
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountCreator.java`
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java`
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountControllerFacade.java`
- `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java`
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/AccountNotFoundException.java`
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/InsufficientFundsException.java`
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java`
- `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/accountmanagement/domain/model`
- `src/main/java/com/pragma/accountmanagement/domain/ports`
- `src/main/java/com/pragma/accountmanagement/domain/usecase`
- `src/main/java/com/pragma/accountmanagement/application`
- `src/main/java/com/pragma/accountmanagement/infrastructure/adapters`
- `src/main/java/com/pragma/accountmanagement/infrastructure/config`
- `src/main/java/com/pragma/accountmanagement/infrastructure/controllers`
- `src/main/java/com/pragma/accountmanagement/infrastructure/dto`
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception`
- `src/main/resources`
- `src/test/java/com/pragma/accountmanagement`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced
- Brecha que el reto ataca: Aplica al menos dos patrones GRASP (Patrones de Software para la Asignación de Responsabilidades Generales) en el diseño y desarrollo de un sistema, incluyendo: Experto en Información, Creador, Controlador, Alta Cohesión y Bajo Acoplamiento, Polimorfismo, Fabricación Pura, Indirección y Variaciones Protegidas
- Mision: Candidato con nivel Advanced en Backend Java, en equipo de desarrollo con enfoque en arquitectura limpia

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
