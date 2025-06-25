-- =======================================================
-- SCRIPT SQL PARA POBLAR BASE DE DATOS DE TWITTER
-- Compatible con el esquema real exportado de phpMyAdmin
-- Proyecto MDS2 - Universidad de Almería
-- =======================================================

-- Desactivar verificaciones de claves foráneas temporalmente
SET FOREIGN_KEY_CHECKS = 0;

-- =======================================================
-- 1. USUARIOS AUTENTIFICADOS (Tabla padre)
-- =======================================================

INSERT INTO usuario_autentificado (Id_usuario, Nickname, Contrasena) VALUES
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

INSERT INTO administrador (Usuario_AutentificadoId_usuario) VALUES
(1);

-- =======================================================
-- 3. USUARIOS REGISTRADOS
-- =======================================================

INSERT INTO usuario_registrado (Usuario_AutentificadoId_usuario, Descripcion, ImagenFondoURL, FotoPerfilURL, CorreoElectronico, FechaDeRegistro) VALUES
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

INSERT INTO documento (Id_documento, ImagenVideoURL, Tipo) VALUES
(1, 'https://ejemplo.com/imagen1.jpg', 'imagen'),
(2, 'https://ejemplo.com/video1.mp4', 'video'),
(3, 'https://ejemplo.com/imagen2.jpg', 'imagen'),
(4, 'https://ejemplo.com/video2.mp4', 'video'),
(5, 'https://ejemplo.com/imagen3.jpg', 'imagen'),
(6, 'https://ejemplo.com/imagen4.jpg', 'imagen'),
(7, 'https://ejemplo.com/video3.mp4', 'video'),
(8, 'https://ejemplo.com/imagen5.jpg', 'imagen'),
(9, 'https://ejemplo.com/imagen6.jpg', 'imagen'),
(10, 'https://ejemplo.com/video4.mp4', 'video'),
(11, 'https://ejemplo.com/imagen7.jpg', 'imagen'),
(12, 'https://ejemplo.com/video5.mp4', 'video'),
(13, 'https://ejemplo.com/imagen8.jpg', 'imagen'),
(14, 'https://ejemplo.com/imagen9.jpg', 'imagen'),
(15, 'https://ejemplo.com/video6.mp4', 'video');

-- =======================================================
-- 5. HASHTAGS
-- =======================================================

INSERT INTO hashtag (Id_hashtag, Hashtag) VALUES
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
(20, '#filosofia'),
(21, '#marketing'),
(22, '#medicina'),
(23, '#cocina'),
(24, '#entrenamiento'),
(25, '#desarrollo');

-- =======================================================
-- 6. TWEETS
-- =======================================================

INSERT INTO tweet (Id_tweet, Usuario_RegistradoUsuario_AutentificadoId_usuario, DocumentoId_documento, TweetId_tweet, ContenidoTweet, FechaPublicacion) VALUES
(1, 2, 1, NULL, '¡Hola mundo! Mi primer tweet en esta plataforma #tecnologia #programacion', '2024-01-01'),
(2, 3, 2, NULL, 'Trabajando en un nuevo proyecto de diseño gráfico #diseño #arte', '2024-01-02'),
(3, 4, NULL, NULL, 'Estudiando algoritmos de ordenamiento. ¡Los merge sort son fascinantes! #programacion #educacion', '2024-01-03'),
(4, 5, 3, NULL, 'Nueva campaña de marketing digital en proceso #marketing', '2024-01-04'),
(5, 6, 4, NULL, 'Capturando la belleza de la naturaleza #fotografia #naturaleza', '2024-01-05'),
(6, 7, NULL, NULL, 'Escribiendo mi próxima novela. Las palabras fluyen como agua #literatura', '2024-01-06'),
(7, 8, 5, NULL, 'Analizando big data para encontrar patrones interesantes #ciencia #tecnologia', '2024-01-07'),
(8, 9, NULL, NULL, 'Las matemáticas son el lenguaje del universo #educacion #ciencia', '2024-01-08'),
(9, 10, 6, NULL, 'Componiendo una nueva melodía para mi álbum #musica', '2024-01-09'),
(10, 11, NULL, NULL, 'La medicina preventiva salva vidas #salud #medicina', '2024-01-10'),
(11, 12, 7, NULL, 'Receta del día: paella valenciana tradicional #comida #cocina', '2024-01-11'),
(12, 13, NULL, NULL, 'El derecho digital es el futuro de la abogacía #tecnologia', '2024-01-12'),
(13, 14, 8, NULL, 'Entrenamiento matutino completado. ¡A por el día! #deporte #entrenamiento', '2024-01-13'),
(14, 15, NULL, NULL, 'Diseñando espacios que conecten con las personas #arquitectura', '2024-01-14'),
(15, 2, 9, NULL, 'Nuevo framework de JavaScript descubierto #programacion #tecnologia #desarrollo', '2024-01-15'),
(16, 3, NULL, NULL, 'El color es poesía visual #arte #diseño', '2024-01-16'),
(17, 4, NULL, NULL, 'Debuggeando código a las 3 AM. La vida del programador #programacion #desarrollo', '2024-01-17'),
(18, 5, 10, NULL, 'ROI increíble en la última campaña #marketing', '2024-01-18'),
(19, 6, NULL, NULL, 'La luz dorada del atardecer #fotografia #naturaleza', '2024-01-19'),
(20, 7, NULL, NULL, 'Cada página escrita es un mundo creado #literatura', '2024-01-20'),
(21, 8, 11, NULL, 'Machine learning está transformando la medicina #tecnologia #ciencia #medicina', '2024-01-21'),
(22, 9, NULL, NULL, 'Enseñar es aprender dos veces #educacion', '2024-01-22'),
(23, 10, 12, NULL, 'Grabando mi nuevo sencillo en el estudio #musica', '2024-01-23'),
(24, 11, NULL, NULL, 'Prevenir es mejor que curar #salud #medicina', '2024-01-24'),
(25, 12, 13, NULL, 'Fusión de sabores mediterráneos #comida #cocina', '2024-01-25');

-- =======================================================
-- 7. RELACIONES HASHTAG-TWEET (tabla hashtag_tweet2)
-- =======================================================

INSERT INTO hashtag_tweet2 (HashtagId_hashtag, TweetId_tweet) VALUES
-- Tweet 1: tecnologia, programacion
(1, 1), (2, 1),
-- Tweet 2: diseño, arte
(3, 2), (4, 2),
-- Tweet 3: programacion, educacion
(2, 3), (11, 3),
-- Tweet 4: marketing
(21, 4),
-- Tweet 5: fotografia, naturaleza
(5, 5), (18, 5),
-- Tweet 6: literatura
(13, 6),
-- Tweet 7: ciencia, tecnologia
(12, 7), (1, 7),
-- Tweet 8: educacion, ciencia
(11, 8), (12, 8),
-- Tweet 9: musica
(8, 9),
-- Tweet 10: salud, medicina
(10, 10), (22, 10),
-- Tweet 11: comida, cocina
(7, 11), (23, 11),
-- Tweet 12: tecnologia
(1, 12),
-- Tweet 13: deporte, entrenamiento
(9, 13), (24, 13),
-- Tweet 14: arquitectura
(17, 14),
-- Tweet 15: programacion, tecnologia, desarrollo
(2, 15), (1, 15), (25, 15),
-- Tweet 16: arte, diseño
(4, 16), (3, 16),
-- Tweet 17: programacion, desarrollo
(2, 17), (25, 17),
-- Tweet 18: marketing
(21, 18),
-- Tweet 19: fotografia, naturaleza
(5, 19), (18, 19),
-- Tweet 20: literatura
(13, 20),
-- Tweet 21: tecnologia, ciencia, medicina
(1, 21), (12, 21), (22, 21),
-- Tweet 22: educacion
(11, 22),
-- Tweet 23: musica
(8, 23),
-- Tweet 24: salud, medicina
(10, 24), (22, 24),
-- Tweet 25: comida, cocina
(7, 25), (23, 25);

-- =======================================================
-- 8. COMENTARIOS
-- =======================================================

INSERT INTO comentario (Id_comentario, DocumentoId_documento, Usuario_RegistradoUsuario_AutentificadoId_usuario, TweetId_tweet, ContenidoComentario, FechaPublicacion) VALUES
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
(15, NULL, 2, 14, 'Los espacios bien diseñados transforman vidas', '2024-01-14'),
(16, NULL, 4, 15, 'Ese framework parece muy prometedor', '2024-01-15'),
(17, NULL, 5, 16, 'El arte siempre inspira', '2024-01-16'),
(18, NULL, 6, 17, 'La vida del desarrollador nunca termina', '2024-01-17'),
(19, NULL, 7, 18, 'Excelentes resultados de marketing', '2024-01-18'),
(20, NULL, 8, 19, 'Esa luz se ve espectacular', '2024-01-19'),
(21, 14, 9, 20, 'La literatura abre mundos infinitos', '2024-01-20'),
(22, NULL, 10, 21, 'La IA en medicina es el futuro', '2024-01-21'),
(23, NULL, 11, 22, 'Sócrates tenía razón', '2024-01-22'),
(24, NULL, 12, 23, '¡Esperamos escuchar el resultado!', '2024-01-23'),
(25, NULL, 13, 24, 'Sabia filosofía médica', '2024-01-24');

-- =======================================================
-- 9. RETWEETS (con estructura real: ID, Tipo, FechaPublicacion)
-- =======================================================

INSERT INTO retweet (ID, Tipo, FechaPublicacion, Usuario_RegistradoUsuario_AutentificadoId_usuario, TweetId_tweet) VALUES
(1, 'retweet_simple', '2024-01-01', 3, 1),
(2, 'retweet_simple', '2024-01-01', 4, 1),
(3, 'retweet_simple', '2024-01-02', 5, 2),
(4, 'retweet_simple', '2024-01-03', 6, 3),
(5, 'retweet_simple', '2024-01-05', 7, 5),
(6, 'retweet_simple', '2024-01-07', 8, 7),
(7, 'retweet_simple', '2024-01-08', 9, 8),
(8, 'retweet_simple', '2024-01-10', 11, 10),
(9, 'retweet_simple', '2024-01-11', 12, 11),
(10, 'retweet_simple', '2024-01-15', 4, 15),
(11, 'retweet_comentado', '2024-01-16', 5, 16),
(12, 'retweet_simple', '2024-01-18', 7, 18),
(13, 'retweet_comentado', '2024-01-19', 8, 19),
(14, 'retweet_simple', '2024-01-21', 10, 21),
(15, 'retweet_simple', '2024-01-23', 14, 23);

-- =======================================================
-- 10. PROPIEDADES DE SEGUIMIENTO
-- =======================================================

INSERT INTO propiedadesseguidos (ID, Fecha, Usuario_RegistradoUsuario_AutentificadoId_usuario, Usuario_RegistradoUsuario_AutentificadoId_usuario2) VALUES
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
(20, '2024-01-20', 11, 13),
(21, '2024-01-21', 12, 10),
(22, '2024-01-22', 12, 14),
(23, '2024-01-23', 13, 11),
(24, '2024-01-24', 13, 15),
(25, '2024-01-25', 14, 12),
(26, '2024-01-26', 14, 2),
(27, '2024-01-27', 15, 13),
(28, '2024-01-28', 15, 3),
(29, '2024-01-29', 2, 8),
(30, '2024-01-30', 3, 9);

-- =======================================================
-- 11. ME GUSTA EN TWEETS (tabla tweet_usuario_registrado2)
-- =======================================================

INSERT INTO tweet_usuario_registrado2 (TweetId_tweet, Usuario_RegistradoUsuario_AutentificadoId_usuario) VALUES
-- Likes en tweet 1
(1, 3), (1, 4), (1, 5),
-- Likes en tweet 2
(2, 2), (2, 6), (2, 7),
-- Likes en tweet 3
(3, 5), (3, 8),
-- Likes en tweet 5
(5, 4), (5, 9),
-- Likes en tweet 7
(7, 6), (7, 10),
-- Likes en tweet 8
(8, 7), (8, 11),
-- Likes en tweet 10
(10, 9), (10, 12),
-- Likes en tweet 11
(11, 10), (11, 13),
-- Likes en tweet 15
(15, 3), (15, 6),
-- Likes en tweet 16
(16, 4), (16, 8),
-- Likes en tweet 18
(18, 5), (18, 9),
-- Likes en tweet 21
(21, 7), (21, 11),
-- Likes en tweet 23
(23, 12), (23, 14),
-- Likes en tweet 25
(25, 13), (25, 15);

-- =======================================================
-- 12. ME GUSTA EN COMENTARIOS (tabla comentario_usuario_registrado2)
-- =======================================================

INSERT INTO comentario_usuario_registrado2 (ComentarioId_comentario, Usuario_RegistradoUsuario_AutentificadoId_usuario) VALUES
(1, 2), (1, 4),
(3, 3), (3, 5),
(5, 4), (5, 6),
(7, 6), (7, 8),
(9, 8), (9, 10),
(11, 10), (11, 12),
(13, 12), (13, 14),
(15, 14), (15, 2),
(17, 7), (17, 9),
(19, 8), (19, 11),
(21, 10), (21, 13),
(23, 12), (23, 15),
(25, 14), (25, 3);

-- =======================================================
-- 13. PROPIEDADES DE BANEO
-- =======================================================

INSERT INTO propiedadesbaneo (ID, Duracion, FechaInicioBaneo, Usuario_RegistradoUsuario_AutentificadoId_usuario, AdministradorUsuario_AutentificadoId_usuario) VALUES
(1, 7, '2024-01-20', 14, 1),
(2, 3, '2024-01-18', 13, 1),
(3, 1, '2024-01-25', 12, 1);

-- =======================================================
-- 14. PROPIEDADES DE MENCIÓN
-- =======================================================

INSERT INTO propiedadesmencion (ID, Fecha, Usuario_RegistradoUsuario_AutentificadoId_usuario, TweetId_tweet) VALUES
(1, '2024-01-01', 3, 1),
(2, '2024-01-02', 2, 2),
(3, '2024-01-03', 5, 3),
(4, '2024-01-05', 6, 5),
(5, '2024-01-07', 8, 7),
(6, '2024-01-10', 11, 10),
(7, '2024-01-15', 4, 15),
(8, '2024-01-18', 6, 18),
(9, '2024-01-21', 9, 21),
(10, '2024-01-23', 11, 23);

-- =======================================================
-- 15. RELACIONES DE BLOQUEO (tabla usuario_registrado_usuario_registrado2)
-- =======================================================

INSERT INTO usuario_registrado_usuario_registrado2 (Usuario_RegistradoUsuario_AutentificadoId_usuario, Usuario_RegistradoUsuario_AutentificadoId_usuario2) VALUES
(2, 14),  -- juan_perez bloquea a raul_mendez
(3, 13),  -- maria_garcia bloquea a carmen_vega
(5, 14),  -- ana_martin bloquea a raul_mendez
(8, 12),  -- miguel_santos bloquea a diego_herrera
(11, 13); -- elena_castillo bloquea a carmen_vega

-- Reactivar verificaciones de claves foráneas
SET FOREIGN_KEY_CHECKS = 1;

-- =======================================================
-- CONSULTAS DE VERIFICACIÓN
-- =======================================================

-- Verificar usuarios creados
SELECT 'Usuarios autentificados creados:' as Info, COUNT(*) as Cantidad FROM usuario_autentificado;

-- Verificar usuarios registrados
SELECT 'Usuarios registrados creados:' as Info, COUNT(*) as Cantidad FROM usuario_registrado;

-- Verificar administradores
SELECT 'Administradores creados:' as Info, COUNT(*) as Cantidad FROM administrador;

-- Verificar tweets creados
SELECT 'Tweets creados:' as Info, COUNT(*) as Cantidad FROM tweet;

-- Verificar hashtags
SELECT 'Hashtags creados:' as Info, COUNT(*) as Cantidad FROM hashtag;

-- Verificar relaciones hashtag-tweet
SELECT 'Relaciones hashtag-tweet:' as Info, COUNT(*) as Cantidad FROM hashtag_tweet2;

-- Verificar comentarios
SELECT 'Comentarios creados:' as Info, COUNT(*) as Cantidad FROM comentario;

-- Verificar retweets
SELECT 'Retweets creados:' as Info, COUNT(*) as Cantidad FROM retweet;

-- Verificar relaciones de seguimiento
SELECT 'Relaciones de seguimiento:' as Info, COUNT(*) as Cantidad FROM propiedadesseguidos;

-- Verificar likes en tweets
SELECT 'Likes en tweets:' as Info, COUNT(*) as Cantidad FROM tweet_usuario_registrado2;

-- Verificar likes en comentarios
SELECT 'Likes en comentarios:' as Info, COUNT(*) as Cantidad FROM comentario_usuario_registrado2;

-- Verificar bloqueos
SELECT 'Relaciones de bloqueo:' as Info, COUNT(*) as Cantidad FROM usuario_registrado_usuario_registrado2;

-- Tweet más popular (con más likes)
SELECT 
    t.ContenidoTweet as Tweet, 
    COUNT(tug.Usuario_RegistradoUsuario_AutentificadoId_usuario) as Likes
FROM tweet t 
LEFT JOIN tweet_usuario_registrado2 tug ON t.Id_tweet = tug.TweetId_tweet
GROUP BY t.Id_tweet, t.ContenidoTweet
ORDER BY Likes DESC
LIMIT 5;

-- Usuarios más activos (más tweets)
SELECT 
    ua.Nickname as Usuario,
    COUNT(t.Id_tweet) as Tweets_Publicados
FROM usuario_autentificado ua
JOIN usuario_registrado ur ON ua.Id_usuario = ur.Usuario_AutentificadoId_usuario
LEFT JOIN tweet t ON ur.Usuario_AutentificadoId_usuario = t.Usuario_RegistradoUsuario_AutentificadoId_usuario
GROUP BY ua.Id_usuario, ua.Nickname
ORDER BY Tweets_Publicados DESC
LIMIT 5;

-- Hashtags más utilizados
SELECT 
    h.Hashtag,
    COUNT(ht.TweetId_tweet) as Uso_En_Tweets
FROM hashtag h
LEFT JOIN hashtag_tweet2 ht ON h.Id_hashtag = ht.HashtagId_hashtag
GROUP BY h.Id_hashtag, h.Hashtag
ORDER BY Uso_En_Tweets DESC
LIMIT 10;

-- =======================================================
-- FIN DEL SCRIPT
-- =======================================================
