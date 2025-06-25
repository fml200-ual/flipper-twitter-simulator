-- =======================================================
-- SCRIPT SQL PARA POBLAR BASE DE DATOS DE TWITTER
-- Proyecto MDS2 - Universidad de Almería
-- =======================================================

-- Desactivar verificaciones de claves foráneas temporalmente
SET FOREIGN_KEY_CHECKS = 0;

-- =======================================================
-- 1. USUARIOS AUTENTIFICADOS (Tabla padre)
-- =======================================================

INSERT INTO Usuario_Autentificado (Id_usuario, Nickname, Contrasena) VALUES
(1, 'admin', 'admin123'),
(2, 'juan_perez', 'password123'),
(3, 'maria_garcia', 'mipassword'),
(4, 'carlos_lopez', 'carlitos2023'),
(5, 'ana_martin', 'ana456'),
(6, 'luis_fernandez', 'luis789'),
(7, 'sofia_ruiz', 'sofia2023'),
(8, 'miguel_santos', 'miguel321'),
(9, 'laura_jimenez', 'laura987'),
(10, 'pablo_moreno', 'pablo654'),
(11, 'elena_castillo', 'elena111'),
(12, 'diego_herrera', 'diego222'),
(13, 'carmen_vega', 'carmen333'),
(14, 'raul_mendez', 'raul444'),
(15, 'natalia_torres', 'natalia555');

-- =======================================================
-- 2. ADMINISTRADORES
-- =======================================================

INSERT INTO Administrador (Usuario_AutentificadoId_usuario) VALUES
(1);

-- =======================================================
-- 3. USUARIOS REGISTRADOS
-- =======================================================

INSERT INTO Usuario_Registrado (Usuario_AutentificadoId_usuario, Descripcion, ImagenFondoURL, FotoPerfilURL, CorreoElectronico, FechaDeRegistro) VALUES
(2, 'Desarrollador de software apasionado por la tecnología', 'https://ejemplo.com/fondo1.jpg', 'https://ejemplo.com/perfil1.jpg', 'juan.perez@email.com', '2023-01-15'),
(3, 'Diseñadora gráfica y amante del arte digital', 'https://ejemplo.com/fondo2.jpg', 'https://ejemplo.com/perfil2.jpg', 'maria.garcia@email.com', '2023-02-20'),
(4, 'Estudiante de ingeniería informática', 'https://ejemplo.com/fondo3.jpg', 'https://ejemplo.com/perfil3.jpg', 'carlos.lopez@email.com', '2023-03-10'),
(5, 'Marketing digital y redes sociales', 'https://ejemplo.com/fondo4.jpg', 'https://ejemplo.com/perfil4.jpg', 'ana.martin@email.com', '2023-04-05'),
(6, 'Fotógrafo profesional', 'https://ejemplo.com/fondo5.jpg', 'https://ejemplo.com/perfil5.jpg', 'luis.fernandez@email.com', '2023-05-12'),
(7, 'Escritora y blogger', 'https://ejemplo.com/fondo6.jpg', 'https://ejemplo.com/perfil6.jpg', 'sofia.ruiz@email.com', '2023-06-18'),
(8, 'Ingeniero de datos', 'https://ejemplo.com/fondo7.jpg', 'https://ejemplo.com/perfil7.jpg', 'miguel.santos@email.com', '2023-07-22'),
(9, 'Profesora de matemáticas', 'https://ejemplo.com/fondo8.jpg', 'https://ejemplo.com/perfil8.jpg', 'laura.jimenez@email.com', '2023-08-30'),
(10, 'Músico y compositor', 'https://ejemplo.com/fondo9.jpg', 'https://ejemplo.com/perfil9.jpg', 'pablo.moreno@email.com', '2023-09-14'),
(11, 'Doctora en medicina', 'https://ejemplo.com/fondo10.jpg', 'https://ejemplo.com/perfil10.jpg', 'elena.castillo@email.com', '2023-10-08'),
(12, 'Chef profesional', 'https://ejemplo.com/fondo11.jpg', 'https://ejemplo.com/perfil11.jpg', 'diego.herrera@email.com', '2023-11-25'),
(13, 'Abogada especializada en derecho digital', 'https://ejemplo.com/fondo12.jpg', 'https://ejemplo.com/perfil12.jpg', 'carmen.vega@email.com', '2023-12-03'),
(14, 'Atleta profesional', 'https://ejemplo.com/fondo13.jpg', 'https://ejemplo.com/perfil13.jpg', 'raul.mendez@email.com', '2024-01-17'),
(15, 'Arquitecta y urbanista', 'https://ejemplo.com/fondo14.jpg', 'https://ejemplo.com/perfil14.jpg', 'natalia.torres@email.com', '2024-02-28');

-- =======================================================
-- 4. DOCUMENTOS (para tweets y comentarios)
-- =======================================================

INSERT INTO Documento (Id_documento, ImagenVideoURL, Tipo) VALUES
(1, 'https://ejemplo.com/imagen1.jpg', 'imagen'),
(2, 'https://ejemplo.com/video1.mp4', 'video'),
(3, 'https://ejemplo.com/imagen2.jpg', 'imagen'),
(4, 'https://ejemplo.com/video2.mp4', 'video'),
(5, 'https://ejemplo.com/imagen3.jpg', 'imagen'),
(6, 'https://ejemplo.com/imagen4.jpg', 'imagen'),
(7, 'https://ejemplo.com/video3.mp4', 'video'),
(8, 'https://ejemplo.com/imagen5.jpg', 'imagen'),
(9, 'https://ejemplo.com/imagen6.jpg', 'imagen'),
(10, 'https://ejemplo.com/video4.mp4', 'video');

-- =======================================================
-- 5. HASHTAGS
-- =======================================================

INSERT INTO Hashtag (Id_hashtag, Hashtag) VALUES
(1, '#tecnologia'),
(2, '#programacion'),
(3, '#diseño'),
(4, '#arte'),
(5, '#fotografia'),
(6, '#viajes'),
(7, '#comida'),
(8, '#musica'),
(9, '#deporte'),
(10, '#salud'),
(11, '#educacion'),
(12, '#ciencia'),
(13, '#literatura'),
(14, '#cine'),
(15, '#gaming'),
(16, '#moda'),
(17, '#arquitectura'),
(18, '#naturaleza'),
(19, '#historia'),
(20, '#filosofia');

-- =======================================================
-- 6. TWEETS
-- =======================================================

INSERT INTO Tweet (Id_tweet, Usuario_RegistradoUsuario_AutentificadoId_usuario, DocumentoId_documento, ContenidoTweet, FechaPublicacion) VALUES
(1, 2, 1, '¡Hola mundo! Mi primer tweet en esta plataforma #tecnologia #programacion', '2024-01-01'),
(2, 3, 2, 'Trabajando en un nuevo proyecto de diseño gráfico #diseño #arte', '2024-01-02'),
(3, 4, NULL, 'Estudiando algoritmos de ordenamiento. ¡Los merge sort son fascinantes! #programacion #educacion', '2024-01-03'),
(4, 5, 3, 'Nueva campaña de marketing digital en proceso #marketing', '2024-01-04'),
(5, 6, 4, 'Capturando la belleza de la naturaleza #fotografia #naturaleza', '2024-01-05'),
(6, 7, NULL, 'Escribiendo mi próxima novela. Las palabras fluyen como agua #literatura', '2024-01-06'),
(7, 8, 5, 'Analizando big data para encontrar patrones interesantes #ciencia #tecnologia', '2024-01-07'),
(8, 9, NULL, 'Las matemáticas son el lenguaje del universo #educacion #ciencia', '2024-01-08'),
(9, 10, 6, 'Componiendo una nueva melodía para mi álbum #musica', '2024-01-09'),
(10, 11, NULL, 'La medicina preventiva salva vidas #salud', '2024-01-10'),
(11, 12, 7, 'Receta del día: paella valenciana tradicional #comida', '2024-01-11'),
(12, 13, NULL, 'El derecho digital es el futuro de la abogacía #tecnologia', '2024-01-12'),
(13, 14, 8, 'Entrenamiento matutino completado. ¡A por el día! #deporte', '2024-01-13'),
(14, 15, NULL, 'Diseñando espacios que conecten con las personas #arquitectura', '2024-01-14'),
(15, 2, 9, 'Nuevo framework de JavaScript descubierto #programacion #tecnologia', '2024-01-15'),
(16, 3, NULL, 'El color es poesía visual #arte #diseño', '2024-01-16'),
(17, 4, NULL, 'Debuggeando código a las 3 AM. La vida del programador #programacion', '2024-01-17'),
(18, 5, 10, 'ROI increíble en la última campaña #marketing', '2024-01-18'),
(19, 6, NULL, 'La luz dorada del atardecer #fotografia', '2024-01-19'),
(20, 7, NULL, 'Cada página escrita es un mundo creado #literatura', '2024-01-20');

-- =======================================================
-- 7. RELACIONES TWEET-HASHTAG (solo si la tabla existe)
-- =======================================================

-- Verificar si la tabla Tweet_Hashtag existe antes de insertar
SET @sql = IF((SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'Tweet_Hashtag') > 0,
    'INSERT INTO Tweet_Hashtag (TweetId_tweet, HashtagId_hashtag) VALUES
    (1, 1), (1, 2),
    (2, 3), (2, 4),
    (3, 2), (3, 11),
    (5, 5), (5, 18),
    (7, 12), (7, 1),
    (8, 11), (8, 12),
    (9, 8),
    (10, 10),
    (11, 7),
    (12, 1),
    (13, 9),
    (14, 17),
    (15, 2), (15, 1),
    (16, 4), (16, 3),
    (17, 2),
    (18, 4),
    (19, 5),
    (20, 13)', 
    'SELECT "Tabla Tweet_Hashtag no existe - saltando relaciones tweet-hashtag" as Info');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- =======================================================
-- 8. COMENTARIOS
-- =======================================================

INSERT INTO Comentario (Id_comentario, DocumentoId_documento, Usuario_RegistradoUsuario_AutentificadoId_usuario, TweetId_tweet, ContenidoComentario, FechaPublicacion) VALUES
(1, NULL, 3, 1, '¡Bienvenido a la plataforma! Gran primer tweet', '2024-01-01'),
(2, NULL, 4, 1, 'Me gusta tu enfoque en tecnología', '2024-01-01'),
(3, NULL, 2, 2, 'Tu trabajo de diseño es increíble', '2024-01-02'),
(4, NULL, 5, 3, 'Los algoritmos son fascinantes, estoy de acuerdo', '2024-01-03'),
(5, NULL, 6, 4, 'Buena estrategia de marketing', '2024-01-04'),
(6, NULL, 7, 5, 'Hermosa fotografía de la naturaleza', '2024-01-05'),
(7, NULL, 8, 6, 'Espero leer tu novela pronto', '2024-01-06'),
(8, NULL, 9, 7, 'El big data está revolucionando todo', '2024-01-07'),
(9, NULL, 10, 8, 'Las matemáticas son realmente universales', '2024-01-08'),
(10, NULL, 11, 9, '¡Espero escuchar tu nueva música!', '2024-01-09'),
(11, NULL, 12, 10, 'La prevención es clave en salud', '2024-01-10'),
(12, NULL, 13, 11, '¡Me encanta la paella! ¿Podrías compartir la receta?', '2024-01-11'),
(13, NULL, 14, 12, 'El derecho digital es muy importante hoy en día', '2024-01-12'),
(14, NULL, 15, 13, '¡Qué motivación! Yo también voy a entrenar', '2024-01-13'),
(15, NULL, 2, 14, 'Los espacios bien diseñados transforman vidas', '2024-01-14');

-- =======================================================
-- 9. RETWEETS (solo si la tabla existe)
-- =======================================================

-- Verificar si la tabla Retweet existe antes de insertar
SET @sql = IF((SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'Retweet') > 0,
    'INSERT INTO Retweet (Id_retweet, TweetId_tweet, Usuario_RegistradoUsuario_AutentificadoId_usuario, FechaRetweet) VALUES
    (1, 1, 3, ''2024-01-01''),
    (2, 1, 4, ''2024-01-01''),
    (3, 2, 5, ''2024-01-02''),
    (4, 3, 6, ''2024-01-03''),
    (5, 5, 7, ''2024-01-05''),
    (6, 7, 8, ''2024-01-07''),
    (7, 8, 9, ''2024-01-08''),
    (8, 10, 11, ''2024-01-10''),
    (9, 11, 12, ''2024-01-11''),
    (10, 15, 4, ''2024-01-15'')', 
    'SELECT "Tabla Retweet no existe - saltando inserción de retweets" as Info');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- =======================================================
-- 10. PROPIEDADES DE SEGUIMIENTO
-- =======================================================

INSERT INTO PropiedadesSeguidos (ID, Fecha, Usuario_RegistradoUsuario_AutentificadoId_usuario2, Usuario_RegistradoUsuario_AutentificadoId_usuario) VALUES
(1, '2024-01-01', 2, 3),
(2, '2024-01-02', 2, 4),
(3, '2024-01-03', 3, 2),
(4, '2024-01-04', 3, 5),
(5, '2024-01-05', 4, 2),
(6, '2024-01-06', 4, 6),
(7, '2024-01-07', 5, 3),
(8, '2024-01-08', 5, 7),
(9, '2024-01-09', 6, 4),
(10, '2024-01-10', 6, 8),
(11, '2024-01-11', 7, 5),
(12, '2024-01-12', 7, 9),
(13, '2024-01-13', 8, 6),
(14, '2024-01-14', 8, 10),
(15, '2024-01-15', 9, 7),
(16, '2024-01-16', 9, 11),
(17, '2024-01-17', 10, 8),
(18, '2024-01-18', 10, 12),
(19, '2024-01-19', 11, 9),
(20, '2024-01-20', 11, 13);

-- =======================================================
-- 11. ME GUSTA EN TWEETS (solo si la tabla existe)
-- =======================================================

-- Verificar si la tabla Tweet_Usuario_Registrado2 existe antes de insertar
SET @sql = IF((SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'Tweet_Usuario_Registrado2') > 0,
    'INSERT INTO Tweet_Usuario_Registrado2 (TweetId_tweet, Usuario_RegistradoUsuario_AutentificadoId_usuario) VALUES
    (1, 3), (1, 4), (1, 5),
    (2, 2), (2, 6), (2, 7),
    (3, 5), (3, 8),
    (5, 4), (5, 9),
    (7, 6), (7, 10),
    (8, 7), (8, 11),
    (10, 9), (10, 12),
    (11, 10), (11, 13),
    (15, 3), (15, 6)', 
    'SELECT "Tabla Tweet_Usuario_Registrado2 no existe - saltando me gusta en tweets" as Info');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- =======================================================
-- 12. ME GUSTA EN COMENTARIOS (solo si la tabla existe)
-- =======================================================

-- Verificar si la tabla Comentario_Usuario_Registrado2 existe antes de insertar
SET @sql = IF((SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'Comentario_Usuario_Registrado2') > 0,
    'INSERT INTO Comentario_Usuario_Registrado2 (ComentarioId_comentario, Usuario_RegistradoUsuario_AutentificadoId_usuario) VALUES
    (1, 2), (1, 4),
    (3, 3), (3, 5),
    (5, 4), (5, 6),
    (7, 6), (7, 8),
    (9, 8), (9, 10),
    (11, 10), (11, 12),
    (13, 12), (13, 14)', 
    'SELECT "Tabla Comentario_Usuario_Registrado2 no existe - saltando me gusta en comentarios" as Info');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- =======================================================
-- 13. PROPIEDADES DE BANEO (algunos usuarios baneados)
-- =======================================================

INSERT INTO PropiedadesBaneo (ID, Duracion, FechaInicioBaneo, Usuario_RegistradoUsuario_AutentificadoId_usuario, AdministradorUsuario_AutentificadoId_usuario) VALUES
(1, 7, '2024-01-20', 14, 1),
(2, 3, '2024-01-18', 13, 1);

-- =======================================================
-- 14. PROPIEDADES DE MENCIÓN
-- =======================================================

INSERT INTO PropiedadesMencion (ID, Fecha, Usuario_RegistradoUsuario_AutentificadoId_usuario, TweetId_tweet) VALUES
(1, '2024-01-01', 3, 1),
(2, '2024-01-02', 2, 2),
(3, '2024-01-03', 5, 3),
(4, '2024-01-05', 6, 5),
(5, '2024-01-07', 8, 7),
(6, '2024-01-10', 11, 10),
(7, '2024-01-15', 4, 15);

-- =======================================================
-- 15. RELACIONES DE BLOQUEO (solo si la tabla existe)
-- =======================================================

-- Verificar si la tabla Usuario_Registrado_Usuario_Registrado2 existe antes de insertar
SET @sql = IF((SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'Usuario_Registrado_Usuario_Registrado2') > 0,
    'INSERT INTO Usuario_Registrado_Usuario_Registrado2 (Usuario_RegistradoUsuario_AutentificadoId_usuario2, Usuario_RegistradoUsuario_AutentificadoId_usuario) VALUES
    (2, 14),
    (3, 13),
    (5, 14)', 
    'SELECT "Tabla Usuario_Registrado_Usuario_Registrado2 no existe - saltando relaciones de bloqueo" as Info');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Reactivar verificaciones de claves foráneas
SET FOREIGN_KEY_CHECKS = 1;

-- =======================================================
-- CONSULTAS DE VERIFICACIÓN
-- =======================================================

-- Verificar usuarios creados
SELECT 'Usuarios creados:' as Info, COUNT(*) as Cantidad FROM Usuario_Autentificado;

-- Verificar tweets creados
SELECT 'Tweets creados:' as Info, COUNT(*) as Cantidad FROM Tweet;

-- Verificar hashtags
SELECT 'Hashtags creados:' as Info, COUNT(*) as Cantidad FROM Hashtag;

-- Verificar comentarios
SELECT 'Comentarios creados:' as Info, COUNT(*) as Cantidad FROM Comentario;

-- Verificar relaciones de seguimiento
SELECT 'Relaciones de seguimiento:' as Info, COUNT(*) as Cantidad FROM PropiedadesSeguidos;

-- Tweet más popular (con más likes)
SELECT t.ContenidoTweet, COUNT(mg.Usuario_RegistradoUsuario_AutentificadoId_usuario) as Likes
FROM Tweet t 
LEFT JOIN Tweet_Usuario_Registrado2 mg ON t.Id_tweet = mg.TweetId_tweet
GROUP BY t.Id_tweet, t.ContenidoTweet
ORDER BY Likes DESC
LIMIT 5;

-- =======================================================
-- FIN DEL SCRIPT
-- =======================================================
