# 🐾 VeTurno

Sistema de gestión veterinaria desarrollado con Spring Boot para la administración de propietarios, mascotas, veterinarios, citas e historial clínico.

El proyecto implementa arquitectura en capas, persistencia con JPA/Hibernate, autenticación JWT, control de acceso por roles, validaciones, manejo global de excepciones y documentación interactiva con Swagger/OpenAPI.

---

# 📌 Características principales

## Gestión de Propietarios

- Crear propietarios
- Consultar propietarios
- Actualizar propietarios
- Eliminar propietarios
  
## Gestión de Mascotas

- Crear mascotas
- Consultar mascotas
- Actualizar mascotas
- Eliminar mascotas
- Asociación con propietarios
  
## Gestión de Veterinarios

- Crear veterinarios
- Consultar veterinarios
- Actualizar veterinarios
- Eliminar veterinarios
  
## Gestión de Citas

- Crear citas
- Consultar citas
- Actualizar citas
- Eliminar citas
- Filtro por estado
- Filtro por mascota
- Filtro por veterinario
- Filtro por fecha
- Filtro por rango de fechas
  
## Historial Clínico

- Registrar historial médico
- Consultar historial clínico
- Actualizar historial
- Eliminar historial
  
---

# 📊 Dashboards

El sistema incorpora indicadores de gestión veterinaria:

### Dashboard General

- Total de mascotas
- Total de propietarios
- Total de veterinarios
- Total de citas
  
### Dashboard Diario

- Citas programadas hoy
- Citas completadas
- Citas pendientes
  
### Dashboard Mensual

- Total de citas del mes
- Citas completadas
- Citas canceladas
- Citas pendientes
  
### Dashboard por Veterinario

- Total de citas por veterinario
  
### Top Veterinarios

- Ranking de veterinarios con mayor cantidad de citas
  
---

# 🔒 Seguridad

El sistema implementa:

## Autenticación

- Registro de usuarios
- Inicio de sesión
- JWT (JSON Web Token)
- Filtro de autenticación JWT
- Sesiones Stateless
  
## Roles

### ADMIN

Permisos para:

- Crear registros
- Actualizar registros
- Eliminar registros
- Consultar información
  
### USER

Permisos para:

- Consultar información autorizada
  
## Protección de contraseñas

Las contraseñas son almacenadas utilizando:

```java
BCryptPasswordEncoder
```

---

# 🧱 Arquitectura

El proyecto está organizado por responsabilidades:

```text
com.veturno.veturno
│
├── config
├── controller
├── dto
├── model
├── repository
├── security
├── service
└── exception
```

Patrón utilizado:

```text
Controller
↓
Service
↓
Repository
↓
MySQL
```

---

# 🗄️ Modelo de Datos

## Entidades Principales

- Usuario
- Propietario
- Mascota
- Veterinario
- Cita
- HistorialClinico
  
## Relaciones

```text
Propietario
1 ─── N
Mascota

Mascota
1 ─── N
Cita

Veterinario
1 ─── N
Cita

Mascota
1 ─── N
HistorialClinico
```

---

# 🛠️ Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Security
- JWT
- BCrypt
- Maven
- MySQL
- Swagger/OpenAPI
  
---

# 📚 Documentación API

Swagger se encuentra disponible en:

```text
http://localhost:8080/swagger-ui/index.html
```

Desde Swagger es posible:

- Registrar usuarios
- Iniciar sesión
- Obtener JWT
- Autorizar peticiones
- Probar todos los endpoints
  
---

# 🚀 Instalación

## Clonar repositorio

```bash
git clone https://github.com/Andres-tlh8/VeTurno.git
```

## Entrar al proyecto

```bash
cd VeTurno
```

## Configurar Base de Datos

Modificar:

```properties
application.properties
```

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/veturno
spring.datasource.username=root
spring.datasource.password=123456

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# ▶️ Ejecución

Ejecutar:

```bash
mvn spring-boot:run
```

o iniciar:

```java
VeturnoApplication.java
```

---

# 🔑 Autenticación

## Registro

```http
POST /auth/register
```

Ejemplo:

```json
{
"nombre": "Administrador",
"email": "admin@veturno.com",
"password": "123456"
}
```

---

## Login

```http
POST /auth/login
```

Ejemplo:

```json
{
"email": "admin@veturno.com",
"password": "123456"
}
```

Respuesta:

```json
{
"mensaje": "Login exitoso",
"token": "eyJ..."

```

---

## Uso del Token

Agregar encabezado:

```http
Authorization: Bearer TU_TOKEN
```

---

# ✅ Funcionalidades implementadas

- CRUD completos
- DTOs de entrada y salida
- Validaciones con Bean Validation
- Manejo global de excepciones
- Seguridad JWT
- BCrypt Password Encoder
- Roles ADMIN y USER
- Filtros de búsqueda
- Dashboards estadísticos
- Swagger/OpenAPI
- Persistencia MySQL
- Arquitectura por capas
- Spring Security
  
---

# 👨‍💻 Autor

**Andres Felipe Perez Diaz**

Proyecto académico desarrollado como sistema de gestión veterinaria utilizando Spring Boot, JPA, MySQL y Spring Security.

---

# 📄 Licencia

Proyecto desarrollado con fines académicos y educativos.