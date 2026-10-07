# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountService.java` — `Account.getBalance`: Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountService.java` — `Account.setStatus`: Se invoca `setStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getId`: Se invoca `getId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getAccountNumber`: Se invoca `getAccountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getCustomerId`: Se invoca `getCustomerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getBalance`: Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getOpeningDate`: Se invoca `getOpeningDate` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getAccountType`: Se invoca `getAccountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java` — `Account.getStatus`: Se invoca `getStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java` — `Account.getBalance`: Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java` — `Account.getStatus`: Se invoca `getStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java` — `Account.getOpeningDate`: Se invoca `getOpeningDate` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java` — `Account.getAccountType`: Se invoca `getAccountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/domain/usecase/AccountControllerFacade.java` — `Account.getBalance`: Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `AccountDto.getAccountNumber`: Se invoca `getAccountNumber` sobre `AccountDto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `AccountDto.getCustomerId`: Se invoca `getCustomerId` sobre `AccountDto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `AccountDto.getInitialBalance`: Se invoca `getInitialBalance` sobre `AccountDto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java` — `AccountDto.getAccountType`: Se invoca `getAccountType` sobre `AccountDto`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setTimestamp`: Se invoca `setTimestamp` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setStatus`: Se invoca `setStatus` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setError`: Se invoca `setError` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setMessage`: Se invoca `setMessage` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setErrorCode`: Se invoca `setErrorCode` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setPath`: Se invoca `setPath` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java` — `ErrorResponse.setDetails`: Se invoca `setDetails` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.getAccountNumber`: Se invoca `getAccountNumber` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.getCustomerId`: Se invoca `getCustomerId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.getBalance`: Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.getAccountType`: Se invoca `getAccountType` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.size`: Se invoca `size` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.get`: Se invoca `get` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java` — `Account.isEmpty`: Se invoca `isEmpty` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced

### Brecha de conocimiento
Aplica al menos dos patrones GRASP (Patrones de Software para la Asignación de Responsabilidades Generales) en el diseño y desarrollo de un sistema, incluyendo: Experto en Información, Creador, Controlador, Alta Cohesión y Bajo Acoplamiento, Polimorfismo, Fabricación Pura, Indirección y Variaciones Protegidas

### Misión / candidato
Candidato con nivel Advanced en Backend Java, en equipo de desarrollo con enfoque en arquitectura limpia

### Reto
- Tema: aplicación de patrones GRASP en el desarrollo de sistemas
- Seniority: advanced-l2
- Tipo: mixed
- Título: Aplicación de Patrones GRASP en un Sistema de Gestión de Cuentas
- Tiempo estimado: 10 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Análisis del Sistema Actual — objetivo: Identificar las responsabilidades y puntos de mejora en el sistema actual — entregable (NO resolver): Documento que describe las responsabilidades actuales y áreas de mejora.
- Fase 2: Aplicación de Patrones GRASP — objetivo: Refactorizar el sistema aplicando los patrones GRASP seleccionados — entregable (NO resolver): Código refactorizado con patrones GRASP aplicados y documentación de los cambios.
- Fase 3: Evaluación y Retroalimentación — objetivo: Evaluar los cambios realizados y recibir retroalimentación — entregable (NO resolver): Evaluación del sistema refactorizado y documento de retroalimentación.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>account-management</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>account-management</name>
    <description>Sistema de gestión de cuentas con aplicación de patrones GRASP</description>

    <properties>
        <java.version>21</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.2.224</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.9.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/AccountManagementApplication.java ===
package com.pragma.accountmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AccountManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: account-management
  
  datasource:
    url: jdbc:h2:mem:accountdb
    driverClassName: org.h2.Driver
    username: sa
    password: ""
    
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        web-allow-others: true
  
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

server:
  port: 8080
  error:
    include-message: always
    include-binding-errors: always
    include-stacktrace: on_param

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    operationsSorter: method

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/domain/model/Account.java ===
package com.pragma.accountmanagement.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private UUID id;

    @NotBlank(message = "El número de cuenta no puede estar vacío")
    private String accountNumber;

    @NotBlank(message = "El ID del cliente no puede estar vacío")
    private String customerId;

    @NotNull(message = "El saldo inicial no puede ser nulo")
    @PositiveOrZero(message = "El saldo no puede ser negativo")
    private BigDecimal balance;

    @NotNull(message = "La fecha de apertura no puede ser nula")
    private LocalDate openingDate;

    @NotBlank(message = "El tipo de cuenta no puede estar vacío")
    private String accountType;

    @NotBlank(message = "El estado de la cuenta no puede estar vacío")
    private String status;

    public Account(String accountNumber, String customerId, BigDecimal initialBalance, String accountType) {
        this.id = UUID.randomUUID();
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = initialBalance;
        this.openingDate = LocalDate.now();
        this.accountType = accountType;
        this.status = "ACTIVE";
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente para realizar el retiro");
        }
        this.balance = this.balance.subtract(amount);
    }

    public boolean isActive() {
        return "ACTIVE".equals(this.status);
    }
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/domain/ports/AccountRepository.java ===
package com.pragma.accountmanagement.domain.ports;

import com.pragma.accountmanagement.domain.model.Account;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findById(UUID id);
    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findByCustomerId(String customerId);
    void deleteById(UUID id);
    boolean existsByAccountNumber(String accountNumber);
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/domain/usecase/AccountService.java ===
package com.pragma.accountmanagement.domain.usecase;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String accountNumber, String customerId, BigDecimal initialBalance, String accountType) {
        if (accountRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("Ya existe una cuenta con ese número");
        }

        Account account = new Account(accountNumber, customerId, initialBalance, accountType);
        return accountRepository.save(account);
    }

    public Account getAccountById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada con ID: " + id));
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada con número: " + accountNumber));
    }

    public List<Account> getAccountsByCustomerId(String customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    public Account deposit(UUID accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);
        if (!account.isActive()) {
            throw new IllegalStateException("No se puede depositar en una cuenta inactiva");
        }
        account.deposit(amount);
        return accountRepository.save(account);
    }

    public Account withdraw(UUID accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);
        if (!account.isActive()) {
            throw new IllegalStateException("No se puede retirar de una cuenta inactiva");
        }
        account.withdraw(amount);
        return accountRepository.save(account);
    }

    public void closeAccount(UUID accountId) {
        Account account = getAccountById(accountId);
        if (account.getBalance().compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalStateException("No se puede cerrar una cuenta con saldo diferente de cero");
        }
        account.setStatus("CLOSED");
        accountRepository.save(account);
    }
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/infrastructure/adapters/JpaAccountRepository.java ===
package com.pragma.accountmanagement.infrastructure.adapters;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaAccountRepository extends JpaRepository<Account, UUID>, AccountRepository {

    @Override
    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
    Optional<Account> findByAccountNumber(@Param("accountNumber") String accountNumber);

    @Override
    @Query("SELECT a FROM Account a WHERE a.customerId = :customerId")
    List<Account> findByCustomerId(@Param("customerId") String customerId);

    @Override
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Account a WHERE a.accountNumber = :accountNumber")
    boolean existsByAccountNumber(@Param("accountNumber") String accountNumber);
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/infrastructure/dto/AccountDto.java ===
package com.pragma.accountmanagement.infrastructure.dto;


import com.pragma.accountmanagement.domain.model.Account;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record AccountDto(
    UUID id,
    
    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres")
    String accountNumber,
    
    @NotBlank(message = "El ID del cliente es obligatorio")
    String customerId,
    
    @NotNull(message = "El saldo inicial es obligatorio")
    @DecimalMin(value = "0.0", message = "El saldo no puede ser negativo")
    BigDecimal balance,
    
    LocalDate openingDate,
    
    @NotBlank(message = "El tipo de cuenta es obligatorio")
    String accountType,
    
    @NotBlank(message = "El estado de la cuenta es obligatorio")
    String status
) {
    public static AccountDto fromDomain(Account account) {
        return new AccountDto(
            account.getId(),
            account.getAccountNumber(),
            account.getCustomerId(),
            account.getBalance(),
            account.getOpeningDate(),
            account.getAccountType(),
            account.getStatus()
        );
    }
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/domain/usecase/AccountCreator.java ===
package com.pragma.accountmanagement.domain.usecase;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import com.pragma.accountmanagement.infrastructure.exception.InsufficientFundsException;

import java.math.BigDecimal;

public class AccountCreator {

    private final AccountRepository accountRepository;

    public AccountCreator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(String accountNumber, String customerId, BigDecimal initialBalance, String accountType) {
        if (accountRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("Ya existe una cuenta con el número: " + accountNumber);
        }

        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException("El saldo inicial no puede ser negativo");
        }

        Account newAccount = new Account(accountNumber, customerId, initialBalance, accountType);
        return accountRepository.save(newAccount);
    }

    public Account createWithDefaultBalance(String accountNumber, String customerId, String accountType) {
        return create(accountNumber, customerId, BigDecimal.ZERO, accountType);
    }

    public Account createWithMinimumBalance(String accountNumber, String customerId, BigDecimal minimumBalance, String accountType) {
        if (minimumBalance == null || minimumBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo mínimo no puede ser negativo");
        }
        return create(accountNumber, customerId, minimumBalance, accountType);
    }
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/domain/usecase/AccountInformationExpert.java ===
package com.pragma.accountmanagement.domain.usecase;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException;
import com.pragma.accountmanagement.infrastructure.exception.InsufficientFundsException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Implementa el patrón GRASP Experto en Información.
 * Esta clase es la experta en manejar la información relacionada con las cuentas,
 * incluyendo consultas de saldo, historial de transacciones y estado de cuenta.
 * Tiene acceso a todos los datos necesarios para realizar estos cálculos y consultas.
 */
public class AccountInformationExpert {

    private final AccountRepository accountRepository;

    public AccountInformationExpert(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Obtiene el saldo actual de una cuenta.
     * Como experto en información, tiene acceso al modelo Account y puede extraer el saldo.
     */
    public BigDecimal getAccountBalance(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        return account.getBalance();
    }

    /**
     * Consulta el estado de una cuenta (activa, inactiva, cerrada).
     */
    public String getAccountStatus(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        return account.getStatus();
    }

    /**
     * Verifica si una cuenta está activa para realizar operaciones.
     */
    public boolean isAccountActive(UUID accountId) {
        return accountRepository.findById(accountId)
                .map(Account::isActive)
                .orElse(false);
    }

    /**
     * Obtiene información completa de una cuenta por su ID.
     */
    public Account getAccountDetails(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
    }

    /**
     * Obtiene información completa de una cuenta por su número.
     */
    public Account getAccountDetailsByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con número: " + accountNumber));
    }

    /**
     * Obtiene todas las cuentas de un cliente.
     */
    public List<Account> getCustomerAccounts(String customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    /**
     * Calcula el saldo total de un cliente en todas sus cuentas.
     * Como experto en información, tiene acceso a todas las cuentas del cliente
     * y puede realizar el cálculo agregado.
     */
    public BigDecimal getTotalBalanceForCustomer(String customerId) {
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        return accounts.stream()
                .filter(Account::isActive)
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Obtiene la fecha de apertura de una cuenta.
     */
    public LocalDate getAccountOpeningDate(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        return account.getOpeningDate();
    }

    /**
     * Obtiene el tipo de cuenta (ahorro, corriente, etc.).
     */
    public String getAccountType(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        return account.getAccountType();
    }

    /**
     * Valida si una cuenta existe y está activa para realizar operaciones.
     */
    public void validateAccountForOperation(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        
        if (!account.isActive()) {
            throw new IllegalStateException(
                    "La cuenta no está activa para realizar operaciones");
        }
    }

    /**
     * Valida si hay fondos suficientes para un retiro.
     */
    public void validateSufficientFunds(UUID accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Cuenta no encontrada con ID: " + accountId));
        
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException(
                    "Saldo insuficiente. Saldo actual: " + account.getBalance() + 
                    ", monto solicitado: " + amount);
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/domain/usecase/AccountControllerFacade.java ===
package com.pragma.accountmanagement.domain.usecase;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Implementa el patrón GRASP Controlador.
 * Esta clase actúa como controlador de aplicación, siendo el intermediary
 * entre la capa de presentación (controladores REST) y los casos de uso del dominio.
 * Coordina las operaciones y delega a las clases Expertas en Información.
 */
public class AccountControllerFacade {

    private final AccountRepository accountRepository;
    private final AccountInformationExpert informationExpert;

    public AccountControllerFacade(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.informationExpert = new AccountInformationExpert(accountRepository);
    }

    /**
     * Crea una nueva cuenta en el sistema.
     * Delega la creación al AccountCreator y registra la cuenta.
     */
    public Account createAccount(String accountNumber, String customerId, 
                                  BigDecimal initialBalance, String accountType) {
        if (accountRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException(
                    "Ya existe una cuenta con el número: " + accountNumber);
        }
        
        Account newAccount = new Account(accountNumber, customerId, 
                initialBalance, accountType);
        return accountRepository.save(newAccount);
    }

    /**
     * Realiza un depósito en una cuenta.
     * Coordina la validación y la operación de depósito.
     */
    public Account deposit(UUID accountId, BigDecimal amount) {
        validatePositiveAmount(amount);
        informationExpert.validateAccountForOperation(accountId);
        
        Account account = informationExpert.getAccountDetails(accountId);
        account.deposit(amount);
        return accountRepository.save(account);
    }

    /**
     * Realiza un retiro de una cuenta.
     * Coordina la validación de fondos suficientes y la operación de retiro.
     */
    public Account withdraw(UUID accountId, BigDecimal amount) {
        validatePositiveAmount(amount);
        informationExpert.validateAccountForOperation(accountId);
        informationExpert.validateSufficientFunds(accountId, amount);
        
        Account account = informationExpert.getAccountDetails(accountId);
        account.withdraw(amount);
        return accountRepository.save(account);
    }

    /**
     * Obtiene los detalles de una cuenta por su ID.
     */
    public Account getAccount(UUID accountId) {
        return informationExpert.getAccountDetails(accountId);
    }

    /**
     * Obtiene los detalles de una cuenta por su número.
     */
    public Account getAccountByNumber(String accountNumber) {
        return informationExpert.getAccountDetailsByNumber(accountNumber);
    }

    /**
     * Obtiene todas las cuentas de un cliente.
     */
    public List<Account> getAccountsByCustomer(String customerId) {
        return informationExpert.getCustomerAccounts(customerId);
    }

    /**
     * Obtiene el saldo de una cuenta.
     */
    public BigDecimal getBalance(UUID accountId) {
        return informationExpert.getAccountBalance(accountId);
    }

    /**
     * Obtiene el estado de una cuenta.
     */
    public String getStatus(UUID accountId) {
        return informationExpert.getAccountStatus(accountId);
    }

    /**
     * Cierra una cuenta existente.
     */
    public void closeAccount(UUID accountId) {
        Account account = informationExpert.getAccountDetails(accountId);
        
        if (account.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalStateException(
                    "No se puede cerrar una cuenta con saldo pendiente: " + 
                    account.getBalance());
        }
        
        accountRepository.deleteById(accountId);
    }

    /**
     * Obtiene el saldo total de un cliente.
     */
    public BigDecimal getTotalCustomerBalance(String customerId) {
        return informationExpert.getTotalBalanceForCustomer(customerId);
    }

    /**
     * Valida que el monto sea positivo.
     */
    private void validatePositiveAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero");
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/infrastructure/controllers/AccountController.java ===
package com.pragma.accountmanagement.infrastructure.controllers;

import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.usecase.AccountControllerFacade;
import com.pragma.accountmanagement.infrastructure.dto.AccountDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para operaciones de gestión de cuentas.
 * Expone los endpoints para crear cuentas, realizar depósitos, retiros,
 * consultas de saldo y otras operaciones relacionadas con cuentas bancarias.
 */
@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Cuentas", description = "API para gestión de cuentas bancarias")
public class AccountController {

    private final AccountControllerFacade accountFacade;

    public AccountController(AccountControllerFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @PostMapping
    @Operation(summary = "Crear cuenta", description = "Crea una nueva cuenta bancaria")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        Account account = accountFacade.createAccount(
                accountDto.getAccountNumber(),
                accountDto.getCustomerId(),
                accountDto.getInitialBalance() != null ? accountDto.getInitialBalance() : BigDecimal.ZERO,
                accountDto.getAccountType()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AccountDto.fromDomain(account));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cuenta", description = "Obtiene los detalles de una cuenta por su ID")
    public ResponseEntity<AccountDto> getAccount(@PathVariable UUID id) {
        Account account = accountFacade.getAccount(id);
        return ResponseEntity.ok(AccountDto.fromDomain(account));
    }

    @GetMapping("/number/{accountNumber}")
    @Operation(summary = "Obtener cuenta por número", 
               description = "Obtiene los detalles de una cuenta por su número")
    public ResponseEntity<AccountDto> getAccountByNumber(@PathVariable String accountNumber) {
        Account account = accountFacade.getAccountByNumber(accountNumber);
        return ResponseEntity.ok(AccountDto.fromDomain(account));
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Cuentas por cliente", 
               description = "Obtiene todas las cuentas de un cliente")
    public ResponseEntity<List<AccountDto>> getAccountsByCustomer(@PathVariable String customerId) {
        List<AccountDto> accounts = accountFacade.getAccountsByCustomer(customerId)
                .stream()
                .map(AccountDto::fromDomain)
                .toList();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}/balance")
    @Operation(summary = "Consultar saldo", description = "Obtiene el saldo de una cuenta")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable UUID id) {
        BigDecimal balance = accountFacade.getBalance(id);
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/{id}/status")
    @Operation(summary = "Consultar estado", description = "Obtiene el estado de una cuenta")
    public ResponseEntity<String> getStatus(@PathVariable UUID id) {
        String status = accountFacade.getStatus(id);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/customer/{customerId}/total-balance")
    @Operation(summary = "Saldo total del cliente", 
               description = "Obtiene el saldo total de todas las cuentas de un cliente")
    public ResponseEntity<BigDecimal> getTotalCustomerBalance(@PathVariable String customerId) {
        BigDecimal totalBalance = accountFacade.getTotalCustomerBalance(customerId);
        return ResponseEntity.ok(totalBalance);
    }

    @PostMapping("/{id}/deposit")
    @Operation(summary = "Depósito", description = "Realiza un depósito en una cuenta")
    public ResponseEntity<AccountDto> deposit(@PathVariable UUID id, 
                                               @RequestParam BigDecimal amount) {
        Account account = accountFacade.deposit(id, amount);
        return ResponseEntity.ok(AccountDto.fromDomain(account));
    }

    @PostMapping("/{id}/withdraw")
    @Operation(summary = "Retiro", description = "Realiza un retiro de una cuenta")
    public ResponseEntity<AccountDto> withdraw(@PathVariable UUID id, 
                                                @RequestParam BigDecimal amount) {
        Account account = accountFacade.withdraw(id, amount);
        return ResponseEntity.ok(AccountDto.fromDomain(account));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cerrar cuenta", description = "Cierra una cuenta bancaria")
    public ResponseEntity<Void> closeAccount(@PathVariable UUID id) {
        accountFacade.closeAccount(id);
        return ResponseEntity.noContent().build();
    }
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/infrastructure/exception/AccountNotFoundException.java ===
package com.pragma.accountmanagement.infrastructure.exception;

public class AccountNotFoundException extends RuntimeException {
    private final String accountIdentifier;
    private final String searchType;

    public AccountNotFoundException(String accountIdentifier) {
        super(String.format("No se encontró la cuenta con identificador: %s", accountIdentifier));
        this.accountIdentifier = accountIdentifier;
        this.searchType = "ID";
    }

    public AccountNotFoundException(String accountIdentifier, String searchType) {
        super(String.format("No se encontró la cuenta con %s: %s", searchType, accountIdentifier));
        this.accountIdentifier = accountIdentifier;
        this.searchType = searchType;
    }

    public AccountNotFoundException(String message, String accountIdentifier, String searchType) {
        super(message);
        this.accountIdentifier = accountIdentifier;
        this.searchType = searchType;
    }

    public AccountNotFoundException(String message, Throwable cause, String accountIdentifier, String searchType) {
        super(message, cause);
        this.accountIdentifier = accountIdentifier;
        this.searchType = searchType;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public String getSearchType() {
        return searchType;
    }

    public String getErrorCode() {
        return "ACCOUNT_NOT_FOUND";
    }
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/infrastructure/exception/InsufficientFundsException.java ===
package com.pragma.accountmanagement.infrastructure.exception;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException {
    private final String accountNumber;
    private final BigDecimal currentBalance;
    private final BigDecimal requestedAmount;

    public InsufficientFundsException(String accountNumber, BigDecimal currentBalance, BigDecimal requestedAmount) {
        super(String.format("Fondos insuficientes en la cuenta %s. Saldo actual: %s, monto solicitado: %s",
                accountNumber, currentBalance, requestedAmount));
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public InsufficientFundsException(String message, String accountNumber, BigDecimal currentBalance, BigDecimal requestedAmount) {
        super(message);
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public InsufficientFundsException(String message, Throwable cause, String accountNumber, 
                                       BigDecimal currentBalance, BigDecimal requestedAmount) {
        super(message, cause);
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public BigDecimal getDeficit() {
        return requestedAmount.subtract(currentBalance);
    }

    public String getErrorCode() {
        return "INSUFFICIENT_FUNDS";
    }
}

// === ARCHIVO: src/main/java/com/pragma/accountmanagement/infrastructure/exception/GlobalExceptionHandler.java ===
package com.pragma.accountmanagement.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(
            AccountNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientFundsException(
            InsufficientFundsException ex, WebRequest request) {
        Map<String, Object> details = new HashMap<>();
        details.put("accountNumber", ex.getAccountNumber());
        details.put("currentBalance", ex.getCurrentBalance());
        details.put("requestedAmount", ex.getRequestedAmount());
        details.put("deficit", ex.getDeficit());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .path(request.getDescription(false).replace("uri=", ""))
                .details(details)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> validationErrors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage() != null ? error.getDefaultMessage() : "Valor inválido",
                        (existing, replacement) -> existing
                ));

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation Failed")
                .message("Los datos proporcionados no son válidos")
                .errorCode("VALIDATION_ERROR")
                .path(request.getDescription(false).replace("uri=", ""))
                .details(validationErrors)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .errorCode("INVALID_ARGUMENT")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(
            IllegalStateException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error("Conflict")
                .message(ex.getMessage())
                .errorCode("INVALID_STATE")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message("Ha ocurrido un error inesperado en el sistema")
                .errorCode("INTERNAL_ERROR")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static class ErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String errorCode;
        private String path;
        private Object details;

        private ErrorResponse() {
        }

        public static ErrorResponseBuilder builder() {
            return new ErrorResponseBuilder();
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Object getDetails() {
            return details;
        }

        public void setDetails(Object details) {
            this.details = details;
        }
    }

    public static class ErrorResponseBuilder {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String errorCode;
        private String path;
        private Object details;

        ErrorResponseBuilder() {
        }

        public ErrorResponseBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorResponseBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder error(String error) {
            this.error = error;
            return this;
        }

        public ErrorResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponseBuilder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorResponseBuilder path(String path) {
            this.path = path;
            return this;
        }

        public ErrorResponseBuilder details(Object details) {
            this.details = details;
            return this;
        }

        public ErrorResponse build() {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setTimestamp(this.timestamp);
            errorResponse.setStatus(this.status);
            errorResponse.setError(this.error);
            errorResponse.setMessage(this.message);
            errorResponse.setErrorCode(this.errorCode);
            errorResponse.setPath(this.path);
            errorResponse.setDetails(this.details);
            return errorResponse;
        }
    }
}

// === ARCHIVO: src/test/java/com/pragma/accountmanagement/domain/usecase/AccountServiceTest.java ===
package com.pragma.accountmanagement.domain.usecase;



import com.pragma.accountmanagement.infrastructure.exception.InsufficientFundsException;
import com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException;
import com.pragma.accountmanagement.domain.model.Account;
import com.pragma.accountmanagement.domain.ports.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("AccountService - Pruebas Unitarias")
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account cuentaDePrueba;
    private UUID idDePrueba;
    private static final String NUMERO_CUENTA = "1234567890";
    private static final String ID_CLIENTE = "CLIENTE-001";
    private static final String TIPO_CUENTA = "AHORROS";
    private static final BigDecimal SALDO_INICIAL = new BigDecimal("1000.00");

    @BeforeEach
    void setUp() {
        idDePrueba = UUID.randomUUID();
        cuentaDePrueba = new Account(NUMERO_CUENTA, ID_CLIENTE, SALDO_INICIAL, TIPO_CUENTA);
    }

    @Nested
    @DisplayName("Creación de Cuentas")
    class CreacionCuentas {

        @Test
        @DisplayName("Crear cuenta exitosamente cuando el número de cuenta no existe")
        void crearCuenta_Exitoso_CuandoNumeroNoExiste() {
            when(accountRepository.existsByAccountNumber(NUMERO_CUENTA)).thenReturn(false);
            when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> {
                Account cuenta = invocation.getArgument(0);
                return cuenta;
            });

            Account resultado = accountService.createAccount(NUMERO_CUENTA, ID_CLIENTE, SALDO_INICIAL, TIPO_CUENTA);

            assertNotNull(resultado);
            assertEquals(NUMERO_CUENTA, resultado.getAccountNumber());
            assertEquals(ID_CLIENTE, resultado.getCustomerId());
            assertEquals(SALDO_INICIAL, resultado.getBalance());
            assertEquals(TIPO_CUENTA, resultado.getAccountType());
            verify(accountRepository).existsByAccountNumber(NUMERO_CUENTA);
            verify(accountRepository).save(any(Account.class));
        }

        @Test
        @DisplayName("Crear cuenta con balance inicial cero")
        void crearCuenta_ConBalanceInicialCero() {
            BigDecimal balanceCero = BigDecimal.ZERO;
            when(accountRepository.existsByAccountNumber(NUMERO_CUENTA)).thenReturn(false);
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.createAccount(NUMERO_CUENTA, ID_CLIENTE, balanceCero, TIPO_CUENTA);

            assertNotNull(resultado);
            assertEquals(BigDecimal.ZERO, resultado.getBalance());
        }

        @Test
        @DisplayName("Crear cuenta con balance negativo lanza excepción")
        void crearCuenta_ConBalanceNegativo_LanzaExcepcion() {
            BigDecimal balanceNegativo = new BigDecimal("-100.00");
            when(accountRepository.existsByAccountNumber(NUMERO_CUENTA)).thenReturn(false);

            assertThrows(IllegalArgumentException.class, () ->
                accountService.createAccount(NUMERO_CUENTA, ID_CLIENTE, balanceNegativo, TIPO_CUENTA)
            );
            verify(accountRepository, never()).save(any(Account.class));
        }
    }

    @Nested
    @DisplayName("Consulta de Cuentas")
    class ConsultaCuentas {

        @Test
        @DisplayName("Obtener cuenta por ID exitosamente")
        void obtenerPorId_Exitoso() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            Account resultado = accountService.getAccountById(idDePrueba);

            assertNotNull(resultado);
            assertEquals(NUMERO_CUENTA, resultado.getAccountNumber());
            verify(accountRepository).findById(idDePrueba);
        }

        @Test
        @DisplayName("Obtener cuenta por ID cuando no existe lanza excepción")
        void obtenerPorId_CuandoNoExiste_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.getAccountById(idDePrueba)
            );
        }

        @Test
        @DisplayName("Obtener cuenta por número de cuenta exitosamente")
        void obtenerPorNumeroCuenta_Exitoso() {
            when(accountRepository.findByAccountNumber(NUMERO_CUENTA)).thenReturn(Optional.of(cuentaDePrueba));

            Account resultado = accountService.getAccountByAccountNumber(NUMERO_CUENTA);

            assertNotNull(resultado);
            assertEquals(NUMERO_CUENTA, resultado.getAccountNumber());
            verify(accountRepository).findByAccountNumber(NUMERO_CUENTA);
        }

        @Test
        @DisplayName("Obtener cuenta por número de cuenta cuando no existe lanza excepción")
        void obtenerPorNumeroCuenta_CuandoNoExiste_LanzaExcepcion() {
            when(accountRepository.findByAccountNumber(NUMERO_CUENTA)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.getAccountByAccountNumber(NUMERO_CUENTA)
            );
        }

        @Test
        @DisplayName("Obtener todas las cuentas de un cliente")
        void obtenerPorCliente_Exitoso() {
            List<Account> cuentas = List.of(cuentaDePrueba);
            when(accountRepository.findByCustomerId(ID_CLIENTE)).thenReturn(cuentas);

            List<Account> resultado = accountService.getAccountsByCustomerId(ID_CLIENTE);

            assertNotNull(resultado);
            assertEquals(1, resultado.size());
            assertEquals(ID_CLIENTE, resultado.get(0).getCustomerId());
            verify(accountRepository).findByCustomerId(ID_CLIENTE);
        }

        @Test
        @DisplayName("Obtener cuentas de cliente sin cuentas retorna lista vacía")
        void obtenerPorCliente_SinCuentas_RetornaListaVacia() {
            when(accountRepository.findByCustomerId(ID_CLIENTE)).thenReturn(new ArrayList<>());

            List<Account> resultado = accountService.getAccountsByCustomerId(ID_CLIENTE);

            assertNotNull(resultado);
            assertTrue(resultado.isEmpty());
        }
    }

    @Nested
    @DisplayName("Operaciones de Depósito")
    class Depositos {

        @Test
        @DisplayName("Depósito exitoso aumenta el balance")
        void deposito_Exitoso_AumentaBalance() {
            BigDecimal montoDeposito = new BigDecimal("500.00");
            BigDecimal balanceEsperado = SALDO_INICIAL.add(montoDeposito);

            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.deposit(idDePrueba, montoDeposito);

            assertNotNull(resultado);
            assertEquals(balanceEsperado, resultado.getBalance());
            verify(accountRepository).findById(idDePrueba);
            verify(accountRepository).save(any(Account.class));
        }

        @Test
        @DisplayName("Depósito en cuenta inexistente lanza excepción")
        void deposito_CuentaNoExiste_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.deposit(idDePrueba, new BigDecimal("100.00"))
            );
        }

        @Test
        @DisplayName("Depósito con monto cero no modifica balance")
        void deposito_MontoCero_NoModificaBalance() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.deposit(idDePrueba, BigDecimal.ZERO);

            assertEquals(SALDO_INICIAL, resultado.getBalance());
        }

        @Test
        @DisplayName("Depósito con monto negativo lanza excepción")
        void deposito_MontoNegativo_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            assertThrows(IllegalArgumentException.class, () ->
                accountService.deposit(idDePrueba, new BigDecimal("-50.00"))
            );
        }
    }

    @Nested
    @DisplayName("Operaciones de Retiro")
    class Retiros {

        @Test
        @DisplayName("Retiro exitoso disminuye el balance")
        void retiro_Exitoso_DisminuyeBalance() {
            BigDecimal montoRetiro = new BigDecimal("300.00");
            BigDecimal balanceEsperado = SALDO_INICIAL.subtract(montoRetiro);

            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.withdraw(idDePrueba, montoRetiro);

            assertNotNull(resultado);
            assertEquals(balanceEsperado, resultado.getBalance());
            verify(accountRepository).findById(idDePrueba);
            verify(accountRepository).save(any(Account.class));
        }

        @Test
        @DisplayName("Retiro mayor al balance lanza excepción de fondos insuficientes")
        void retiro_MayorAlBalance_LanzaExcepcion() {
            BigDecimal montoRetiro = new BigDecimal("2000.00");

            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.InsufficientFundsException.class, () ->
                accountService.withdraw(idDePrueba, montoRetiro)
            );
            verify(accountRepository, never()).save(any(Account.class));
        }

        @Test
        @DisplayName("Retiro igual al balance deja cuenta en cero")
        void retiro_IgualAlBalance_DejaEnCero() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            Account resultado = accountService.withdraw(idDePrueba, SALDO_INICIAL);

            assertEquals(BigDecimal.ZERO, resultado.getBalance());
        }

        @Test
        @DisplayName("Retiro en cuenta inexistente lanza excepción")
        void retiro_CuentaNoExiste_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.withdraw(idDePrueba, new BigDecimal("100.00"))
            );
        }

        @Test
        @DisplayName("Retiro con monto negativo lanza excepción")
        void retiro_MontoNegativo_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            assertThrows(IllegalArgumentException.class, () ->
                accountService.withdraw(idDePrueba, new BigDecimal("-50.00"))
            );
        }
    }

    @Nested
    @DisplayName("Cierre de Cuenta")
    class CierreCuenta {

        @Test
        @DisplayName("Cerrar cuenta exitosamente")
        void cerrarCuenta_Exitoso() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            doNothing().when(accountRepository).deleteById(idDePrueba);

            accountService.closeAccount(idDePrueba);

            verify(accountRepository).findById(idDePrueba);
            verify(accountRepository).deleteById(idDePrueba);
        }

        @Test
        @DisplayName("Cerrar cuenta inexistente lanza excepción")
        void cerrarCuenta_CuentaNoExiste_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.empty());

            assertThrows(com.pragma.accountmanagement.infrastructure.exception.AccountNotFoundException.class, () ->
                accountService.closeAccount(idDePrueba)
            );
            verify(accountRepository, never()).deleteById(any());
        }

        @Test
        @DisplayName("Cerrar cuenta con balance positivo lanza excepción")
        void cerrarCuenta_ConBalancePositivo_LanzaExcepcion() {
            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));

            assertThrows(IllegalStateException.class, () ->
                accountService.closeAccount(idDePrueba)
            );
            verify(accountRepository, never()).deleteById(any());
        }
    }

    @Nested
    @DisplayName("Validaciones de Integridad")
    class ValidacionesIntegridad {

        @Test
        @DisplayName("El repository se llama correctamente en cada operación")
        void verificarLlamadasRepository() {
            when(accountRepository.existsByAccountNumber(NUMERO_CUENTA)).thenReturn(false);
            when(accountRepository.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

            accountService.createAccount(NUMERO_CUENTA, ID_CLIENTE, SALDO_INICIAL, TIPO_CUENTA);
            verify(accountRepository, times(1)).existsByAccountNumber(NUMERO_CUENTA);
            verify(accountRepository, times(1)).save(any(Account.class));

            reset(accountRepository);

            when(accountRepository.findById(idDePrueba)).thenReturn(Optional.of(cuentaDePrueba));
            accountService.getAccountById(idDePrueba);
            verify(accountRepository, times(1)).findById(idDePrueba);

            reset(accountRepository);

            when(accountRepository.findByAccountNumber(NUMERO_CUENTA)).thenReturn(Optional.of(cuentaDePrueba));
            accountService.getAccountByAccountNumber(NUMERO_CUENTA);
            verify(accountRepository, times(1)).findByAccountNumber(NUMERO_CUENTA);
        }
    }
}
```
