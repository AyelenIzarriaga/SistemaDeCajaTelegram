# 💰 Sistema de Caja con Bot de Telegram

Proyecto backend desarrollado en Java + Spring Boot que permite gestionar una caja diaria mediante un bot de Telegram.

Desde el bot se pueden registrar ingresos y gastos, consultar balances y obtener estadísticas de recaudación.

La idea del proyecto es simular un sistema real de caja para un local/negocio, utilizando únicamente backend y mensajería.

---

## 🚀 Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Data JPA / Hibernate
* PostgreSQL
* Maven
* Telegram Bots API
* Railway (deploy y base de datos en la nube)

---

## 🗄️ Base de Datos

El sistema utiliza PostgreSQL alojado en la nube mediante Railway.

Las tablas se generan automáticamente usando JPA/Hibernate gracias a la configuración:

spring.jpa.hibernate.ddl-auto=update

No es necesario crear las tablas manualmente.

---

## 🤖 Funcionalidades

Actualmente el sistema permite:

* Registrar ingresos desde Telegram
* Registrar gastos desde Telegram
* Asignar proveedor automáticamente
* Manejar fechas distintas al día actual
* Consultar caja del día
* Ver resumen semanal
* Ver resumen mensual
* Calcular balance mensual
* Calcular promedio diario de recaudación

---

## 📌 Comandos del Bot

### Ejemplos de uso

/ingreso 7000 cliente venta mostrador hoy
/gasto 3000 proveedor mercaderia ayer

### Consultas

/hoy
/semana
/mes
/balance


---

## 🧾 Formato general de comandos

/ingreso monto proveedor [detalle] [fecha]
/gasto monto proveedor [detalle] [fecha]

---

## ⚙️ Configuración

Para ejecutar el proyecto es necesario configurar variables de entorno:

SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
TELEGRAM_BOT_USERNAME
TELEGRAM_BOT_TOKEN

---

## 🎯 Objetivo del proyecto

Este proyecto fue desarrollado como práctica backend para:

* Integrar Spring Boot con APIs externas
* Manejar persistencia de datos con JPA
* Trabajar con bases de datos en la nube
* Simular un sistema real de gestión de caja

---

## 💡 Posibles mejoras futuras

* Autenticación de usuarios
* Panel web de administración
* Exportación de reportes
* Estadísticas avanzadas
* Notificaciones automáticas

