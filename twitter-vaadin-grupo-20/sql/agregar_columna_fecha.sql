-- =======================================================
-- SCRIPT PARA AÑADIR COLUMNA FechaDeRegistro
-- Proyecto MDS2 - Universidad de Almería
-- =======================================================

-- Verificar si la tabla Usuario_Registrado existe
SELECT 'Verificando tabla Usuario_Registrado...' as Status;

-- Mostrar estructura actual de la tabla
SELECT 'Estructura actual de Usuario_Registrado:' as Info;
DESCRIBE Usuario_Registrado;

-- =======================================================
-- AÑADIR COLUMNA FechaDeRegistro SI NO EXISTE
-- =======================================================

-- Verificar si la columna ya existe
SET @column_exists = (
    SELECT COUNT(*) 
    FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_SCHEMA = DATABASE() 
    AND TABLE_NAME = 'Usuario_Registrado' 
    AND COLUMN_NAME = 'FechaDeRegistro'
);

-- Añadir la columna solo si no existe
SET @sql = IF(@column_exists = 0, 
    'ALTER TABLE Usuario_Registrado ADD COLUMN FechaDeRegistro DATE DEFAULT NULL', 
    'SELECT "La columna FechaDeRegistro ya existe" as Mensaje'
);

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- =======================================================
-- VERIFICAR QUE LA COLUMNA SE AÑADIÓ CORRECTAMENTE
-- =======================================================

SELECT 'Estructura después de la modificación:' as Info;
DESCRIBE Usuario_Registrado;

-- Verificar datos existentes
SELECT 'Usuarios registrados existentes:' as Info, COUNT(*) as Cantidad FROM Usuario_Registrado;