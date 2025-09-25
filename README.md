# Sistema de Gestión de Inventario para Empresa deTecnología

## 🚀 Visión General del Proyecto

Este proyecto es una aplicación backend robusta y escalable diseñada para gestión 
integral de inventarios en una empresa de tecnología. Permite un control eficiente
de productos, proveedores y movimientos de stock, facilitando la administración 
de la cadena de suministro a través de una API RESTful.

## ✨ Caracteristicas Principales

*  **Gestión de Productos:** CRUD (Crear, Leer, Actualizar, Eliminar) para productos.
*  **Gestión de Proveedores:** CRUD para la información de proveedores.
*  **Control de Stock:** CRUD para el Registro de entradas y salidas de inventario.
*  **API RESTful:** Interfaz para la integración con otras apicaciones o frontends.
*  **Base de Datos Relacional:** Almacenamiento persistente de datos.

## 🛠️ Tecnologías Utilizadas

* **Java 17+**
* **Spring Boot 3.x:** Framework pra el desarrollo rápido de aplicaciones Java.
* **Maven:** Herramienta de gestión de dependencias y construcción del proyecto.
* **PostgreSQL:** Base de datos relacional.
* **JPA / Hibernate:** Para la persistencia de datos.
* **Postman:** Para pruebas de la API.

## ⚙️ Configuración y Ejecución Local

Sigue estos pasos para levantar el proyecto en tu entorno local:

### Prerrequisitos

Asegúrate de tener instalado:

* JDK 17 o superior
* Maven
* PostgreSQL
* Intellij IDEA (o t IDEA Java preferido)

### Pasos para la Ejecución

1.  **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/tu-usuario/nombre-de-tu-repositorio.git
    cd nombre-de-tu-repositorio
    ```
    *(Asegúrate de reemplazar `tu-usuario` y `nombre-de-tu-repositorio` con los datos correctos una vez que lo subas a GitHub)*

2.  **Configurar la Base de Datos:**
    *   Crea una base de datos PostgreSQL (ej. `inventario_db`).
    *   Crea un usuario y contraseña para la base de datos.
    *   Copia el archivo `application-example.properties` a `src/main/resources/application.properties` y actualiza las credenciales de tu base de datos:
        ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/inventario_db
        spring.datasource.username=tu_usuario_db
        spring.datasource.password=tu_password_db
        spring.jpa.hibernate.ddl-auto=update # o create para la primera vez
        spring.jpa.show-sql=true
        ```

3.  **Ejecutar la Aplicación:**
    *   Abre el proyecto en IntelliJ IDEA.
    *   Construye el proyecto con Maven: `mvn clean install`.
    *   Ejecuta la clase principal de Spring Boot (ej. `com.example.inventario.InventarioApplication`).

## 🧪 Pruebas de API con Postman

Se incluye una colección de Postman (`Inventario.postman_collection.json`) en la carpeta `postman/` para facilitar las pruebas de los endpoints de la API.

1.  Importa el archivo `Inventario.postman_collection.json` en Postman.
2.  Asegúrate de que la aplicación Spring Boot esté corriendo.
3.  Ejecuta las solicitudes definidas en la colección para interactuar con la API.

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si deseas mejorar este proyecto, por favor, sigue estos pasos:

1.  Haz un "fork" del repositorio.
2.  Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3.  Realiza tus cambios y haz commit (`git commit -m 'feat: Añadir nueva funcionalidad X'`).
4.  Sube tus cambios a tu fork (`git push origin feature/nueva-funcionalidad`).
5.  Abre un Pull Request.

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---
