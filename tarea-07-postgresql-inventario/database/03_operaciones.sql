-- 1. Mostrar todos los productos
SELECT codigo, nombre, categoria, precio, stock
FROM producto;

-- 2. Buscar productos de una categoría específica
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE categoria = 'Electronica';

-- 3. Productos ordenados del precio más alto al más bajo
SELECT codigo, nombre, categoria, precio, stock
FROM producto
ORDER BY precio DESC;

-- 4. Productos con tres unidades o menos
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE stock <= 3;

-- 5. Productos activos que todavía tienen existencias
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE activo = TRUE
  AND stock > 0;

-- 6. Buscar un producto mediante su código
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE codigo = 'P003';

-- 7. Verificar stock antes de la venta
SELECT codigo, nombre, stock
FROM producto
WHERE codigo = 'P001';

-- Simular venta de 2 unidades
UPDATE producto
SET stock = stock - 2
WHERE codigo = 'P001';

-- Verificar stock después de la venta
SELECT codigo, nombre, stock
FROM producto
WHERE codigo = 'P001';

-- 8. Verificar productos agotados antes de actualizar
SELECT codigo, nombre, stock, activo
FROM producto
WHERE stock = 0;

-- 9. Desactivar productos con stock igual a 0
UPDATE producto
SET activo = FALSE
WHERE stock = 0;

-- Verificar productos inactivos después de la actualización
SELECT codigo, nombre, stock, activo
FROM producto
WHERE activo = FALSE;

-- 9. Verificar TEMP-001 antes de eliminar
SELECT codigo, nombre, categoria, precio, stock, activo
FROM producto
WHERE codigo = 'TEMP-001';

-- 10. Eliminar únicamente TEMP-001
DELETE FROM producto
WHERE codigo = 'TEMP-001';

-- Verificar que TEMP-001 ya no existe
SELECT codigo, nombre, categoria, precio, stock, activo
FROM producto
WHERE codigo = 'TEMP-001';