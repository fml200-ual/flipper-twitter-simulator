# Flipper Twitter Simulator

¡Bienvenido a **Flipper Twitter Simulator**!  
Este proyecto simula el funcionamiento esencial de la red social Twitter y está desarrollado con **Vaadin** sobre **Spring Boot**.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Tecnologías](#tecnologías)
- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Contribuir](#contribuir)
- [Licencia](#licencia)
- [Contacto](#contacto)

## Descripción

El objetivo de este simulador es proporcionar una plataforma sencilla para experimentar con los conceptos básicos de Twitter, tanto desde la perspectiva de la programación web como desde la simulación de interacciones sociales entre usuarios.

## Características

- Registro y autenticación de usuarios
- Publicación, borrado y edición de tweets
- Seguimiento y dejar de seguir usuarios
- Visualización de timeline personalizado
- Simulación de interacciones (likes, retweets, respuestas, etc.)
- Interfaz web moderna e interactiva con Vaadin
- Persistencia de datos con Spring

## Tecnologías

- [Vaadin](https://vaadin.com/) (UI web en Java)
- [Spring Boot](https://spring.io/projects/spring-boot) (backend y configuración)
- Java 17+ (o la versión especificada en el proyecto)
- Maven o Gradle (gestión de dependencias)

## Instalación

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/fml200-ual/flipper-twitter-simulator.git
   ```
2. **Accede al directorio:**
   ```bash
   cd flipper-twitter-simulator
   ```
3. **Compila la aplicación:**
   Si usas Maven:
   ```bash
   ./mvnw clean install
   ```
   O con Gradle:
   ```bash
   ./gradlew build
   ```
4. **Ejecuta la aplicación:**
   Con Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
   O con Gradle:
   ```bash
   ./gradlew bootRun
   ```
   La aplicación estará disponible en [http://localhost:8080](http://localhost:8080)

## Uso

Abre tu navegador y visita [http://localhost:8080](http://localhost:8080).  
Sigue las instrucciones en pantalla para crear usuarios, publicar tweets y explorar todas las funcionalidades del simulador.

## Estructura del proyecto

```
flipper-twitter-simulator/
│
├── src/
│   ├── main/
│   │   ├── java/             # Código fuente Java (Spring y lógica)
│   │   └── resources/        # Configuración y recursos
│   └── test/                 # Pruebas
├── README.md                 # Este archivo
├── pom.xml / build.gradle    # Gestión de dependencias
└── ...
```

## Contribuir

¡Las contribuciones son bienvenidas!  
Para sugerencias o reportes de errores, abre un issue.  
Si deseas contribuir con código:

1. Haz un fork del repositorio.
2. Crea una rama: `git checkout -b feature/nueva-funcionalidad`
3. Realiza tus cambios y haz commit: `git commit -m 'Agrega nueva funcionalidad'`
4. Sube la rama: `git push origin feature/nueva-funcionalidad`
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## Contacto

- Autor: [fml200-ual](https://github.com/fml200-ual) y [aek676](https://github.com/aek676)
- ¿Dudas o sugerencias? Abre un issue en el repositorio.

---

¡Gracias por visitar y contribuir a Flipper Twitter Simulator!
