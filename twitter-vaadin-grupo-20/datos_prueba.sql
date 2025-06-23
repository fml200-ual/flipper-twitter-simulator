-- Script para insertar datos de prueba en la base de datos
USE bd_mds2_twitter;

-- Insertar usuarios autentificados
INSERT INTO usuario_autentificado (Nickname, Contrasena) VALUES 
('admin', 'admin123'),
('usuario1', 'password123'),
('usuario2', 'password456'), 
('usuario3', 'password789'),
('maria_garcia', 'maria123'),
('juan_perez', 'juan456'),
('ana_lopez', 'ana789'),
('carlos_rodriguez', 'carlos321');

-- Insertar usuarios registrados (usando los IDs generados automáticamente de usuarios autentificados)
INSERT INTO usuario_registrado (Usuario_AutentificadoId_usuario, CorreoElectronico, Descripcion, FechaDeRegistro) VALUES 
(2, 'usuario1@email.com', 'Desarrollador apasionado por Java', '2024-01-15'),
(3, 'usuario2@email.com', 'Estudiante de ingeniería informática', '2024-02-20'),
(4, 'usuario3@email.com', 'Programador web full-stack', '2024-03-10'),
(5, 'maria.garcia@email.com', 'Especialista en bases de datos', '2024-01-05'),
(6, 'juan.perez@email.com', 'Arquitecto de software', '2024-02-12'),
(7, 'ana.lopez@email.com', 'Frontend developer', '2024-03-18'),
(8, 'carlos.rodriguez@email.com', 'DevOps engineer', '2024-01-25');

-- Insertar hashtags
INSERT INTO hashtag (Hashtag) VALUES 
('#tecnologia'),
('#programacion'),
('#java'),
('#vaadin'),
('#desarrollo'),
('#software'),
('#web'),
('#backend'),
('#frontend'),
('#base_datos'),
('#mysql'),
('#spring'),
('#hibernate'),
('#universidad'),
('#proyecto');

-- Insertar tweets
INSERT INTO tweet (Usuario_RegistradoUsuario_AutentificadoId_usuario, ContenidoTweet, FechaPublicacion) VALUES 
(2, 'Comenzando un nuevo proyecto con Vaadin y Spring Boot! #vaadin #java #desarrollo', '2024-03-20'),
(3, 'Aprendiendo sobre Hibernate y la persistencia de datos #hibernate #java #base_datos', '2024-03-20'),
(4, 'El desarrollo web con tecnologías modernas es fascinante #web #frontend #tecnologia', '2024-03-20'),
(5, 'Trabajando en la integración de MySQL con Spring #mysql #spring #backend', '2024-03-20'),
(6, 'Los proyectos universitarios nos enseñan tanto! #universidad #proyecto #desarrollo', '2024-03-21'),
(7, 'Vaadin hace que el desarrollo de UI sea mucho más sencillo #vaadin #java #frontend', '2024-03-21'),
(8, 'Configurando el entorno de desarrollo para el proyecto #software #desarrollo #programacion', '2024-03-21'),
(2, 'Las bases de datos relacionales siguen siendo fundamentales #base_datos #mysql #tecnologia', '2024-03-21'),
(3, 'Spring Boot simplifica mucho el desarrollo de aplicaciones Java #spring #java #backend', '2024-03-21'),
(4, 'Debugeando código y aprendiendo en el proceso #programacion #desarrollo #software', '2024-03-22'),
(5, 'La arquitectura MVC es clave para organizar bien el código #programacion #web #desarrollo', '2024-03-22'),
(6, 'Trabajando con Hibernate para mapear entidades #hibernate #java #base_datos', '2024-03-22'),
(7, 'Frontend y backend trabajando en armonía #frontend #backend #web', '2024-03-22'),
(8, 'Los hashtags ayudan a organizar y categorizar el contenido #tecnologia #web', '2024-03-22'),
(2, 'Último día trabajando en las funcionalidades CRUD #desarrollo #programacion #proyecto', '2024-03-23');

-- Mostrar resumen de datos insertados
SELECT 'Usuarios Autentificados' as Tabla, COUNT(*) as Total FROM usuario_autentificado
UNION ALL
SELECT 'Usuarios Registrados' as Tabla, COUNT(*) as Total FROM usuario_registrado
UNION ALL
SELECT 'Hashtags' as Tabla, COUNT(*) as Total FROM hashtag
UNION ALL
SELECT 'Tweets' as Tabla, COUNT(*) as Total FROM tweet;
