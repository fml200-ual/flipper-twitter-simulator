-- =======================================================
-- SCRIPT PARA LIMPIAR BASE DE DATOS DE TWITTER
-- Compatible con el esquema real exportado de phpMyAdmin
-- Proyecto MDS2 - Universidad de Almería
-- =======================================================

-- Desactivar verificaciones de claves foráneas temporalmente
SET FOREIGN_KEY_CHECKS = 0;

-- =======================================================
-- LIMPIAR DATOS DE TODAS LAS TABLAS
-- =======================================================

-- Limpiar tablas de relaciones muchos-a-muchos primero
DELETE FROM hashtag_tweet2;
DELETE FROM tweet_usuario_registrado2;
DELETE FROM comentario_usuario_registrado2;
DELETE FROM usuario_registrado_usuario_registrado2;

-- Limpiar tablas de propiedades y relaciones
DELETE FROM propiedadesbaneo;
DELETE FROM propiedadesmencion;
DELETE FROM propiedadesseguidos;

-- Limpiar entidades dependientes
DELETE FROM retweet;
DELETE FROM comentario;
DELETE FROM tweet;

-- Limpiar entidades independientes
DELETE FROM hashtag;
DELETE FROM documento;

-- Limpiar usuarios (en orden jerárquico)
DELETE FROM administrador;
DELETE FROM usuario_registrado;
DELETE FROM usuario_autentificado;

-- =======================================================
-- RESETEAR AUTO_INCREMENT
-- =======================================================

-- Resetear contadores de auto-incremento
ALTER TABLE usuario_autentificado AUTO_INCREMENT = 1;
ALTER TABLE documento AUTO_INCREMENT = 1;
ALTER TABLE hashtag AUTO_INCREMENT = 1;
ALTER TABLE tweet AUTO_INCREMENT = 1;
ALTER TABLE comentario AUTO_INCREMENT = 1;
ALTER TABLE retweet AUTO_INCREMENT = 1;
ALTER TABLE propiedadesbaneo AUTO_INCREMENT = 1;
ALTER TABLE propiedadesmencion AUTO_INCREMENT = 1;
ALTER TABLE propiedadesseguidos AUTO_INCREMENT = 1;

-- Reactivar verificaciones de claves foráneas
SET FOREIGN_KEY_CHECKS = 1;

-- =======================================================
-- VERIFICACIÓN DE LIMPIEZA
-- =======================================================

-- Verificar que todas las tablas están vacías
SELECT 'usuario_autentificado' as Tabla, COUNT(*) as Registros FROM usuario_autentificado
UNION ALL
SELECT 'usuario_registrado' as Tabla, COUNT(*) as Registros FROM usuario_registrado
UNION ALL
SELECT 'administrador' as Tabla, COUNT(*) as Registros FROM administrador
UNION ALL
SELECT 'documento' as Tabla, COUNT(*) as Registros FROM documento
UNION ALL
SELECT 'hashtag' as Tabla, COUNT(*) as Registros FROM hashtag
UNION ALL
SELECT 'tweet' as Tabla, COUNT(*) as Registros FROM tweet
UNION ALL
SELECT 'comentario' as Tabla, COUNT(*) as Registros FROM comentario
UNION ALL
SELECT 'retweet' as Tabla, COUNT(*) as Registros FROM retweet
UNION ALL
SELECT 'hashtag_tweet2' as Tabla, COUNT(*) as Registros FROM hashtag_tweet2
UNION ALL
SELECT 'tweet_usuario_registrado2' as Tabla, COUNT(*) as Registros FROM tweet_usuario_registrado2
UNION ALL
SELECT 'comentario_usuario_registrado2' as Tabla, COUNT(*) as Registros FROM comentario_usuario_registrado2
UNION ALL
SELECT 'usuario_registrado_usuario_registrado2' as Tabla, COUNT(*) as Registros FROM usuario_registrado_usuario_registrado2
UNION ALL
SELECT 'propiedadesbaneo' as Tabla, COUNT(*) as Registros FROM propiedadesbaneo
UNION ALL
SELECT 'propiedadesmencion' as Tabla, COUNT(*) as Registros FROM propiedadesmencion
UNION ALL
SELECT 'propiedadesseguidos' as Tabla, COUNT(*) as Registros FROM propiedadesseguidos;

SELECT '=== LIMPIEZA COMPLETADA ===' as Mensaje;

-- =======================================================
-- FIN DEL SCRIPT DE LIMPIEZA
-- =======================================================
