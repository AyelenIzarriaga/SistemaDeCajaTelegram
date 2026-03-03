# 💰 Sistema de Caja + Bot de Telegram

Sistema backend desarrollado en **Java + Spring Boot** que permite registrar movimientos de caja y consultarlos mediante un **bot de Telegram**.

El proyecto está pensado para funcionar 24/7 desplegado en la nube (Render).

---

## 🚀 Tecnologías utilizadas

* Java 17
* Spring Boot 3
* Spring Data JPA
* PostgreSQL
* Telegram Bots API
* Maven

---

## 📦 Funcionalidades

* Registro de ingresos y egresos
* Asociación de movimientos a usuarios
* Gestión de proveedores
* Consulta de resumen de caja
* Bot de Telegram para interacción en tiempo real

---

## 🛠 Configuración del entorno

El proyecto utiliza variables de entorno para mayor seguridad.

Variables necesarias:

```
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
BOT_TOKEN
```

---

## ▶ Ejecutar en local

Desde la raíz del proyecto:

```
.\mvnw.cmd spring-boot:run
```

O generar el jar:

```
.\mvnw.cmd clean package
java -jar target/*.jar
```

---

## 🌐 Deploy en Render

### Build Command

```
mvn clean package
```

### Start Command

```
java -jar target/*.jar
```

⚠ Importante agregar en `application.properties`:

```
server.port=${PORT:8080}
```

---

## 🗄 Base de Datos

Base de datos PostgreSQL externa (ej: Supabase).

La aplicación crea/actualiza las tablas automáticamente mediante JPA.

---

## 🤖 Bot de Telegram

El bot utiliza `getUpdates`, por lo que solo puede haber **una instancia activa** usando el mismo token.

Si aparece error 409:

* Verificar que no haya otro deploy activo.
* Confirmar que no esté corriendo en otra máquina.

---

## 📌 Estado del Proyecto

Versión estable inicial.
Base de datos reiniciada y funcionando desde marzo 2026.

---

## 👩‍💻 Autora

Desarrollado por Ayelen Izarriaga.

---
