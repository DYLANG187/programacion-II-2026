INSERT INTO producto
(codigo, nombre, categoria, precio, stock, activo)
VALUES
    ('P001', 'Teclado mecanico', 'Electronica', 350.00, 5, TRUE),
    ('P002', 'Mouse inalambrico', 'Electronica', 180.00, 3, TRUE),
    ('P003', 'Monitor 24 pulgadas', 'Electronica', 1250.00, 2, TRUE),
    ('P004', 'Cuaderno universitario', 'Papeleria', 25.00, 10, TRUE),
    ('P005', 'Lapiceros paquete', 'Papeleria', 18.50, 0, TRUE),
    ('P006', 'Mochila escolar', 'Accesorios', 275.00, 7, TRUE),
    ('P007', 'Calculadora cientifica', 'Electronica', 145.00, 1, TRUE);

INSERT INTO producto
(codigo, nombre, categoria, precio, stock)
VALUES
    ('P008', 'Botella termica', 'Accesorios', 120.00, 4);

-- Producto temporal para probar DELETE
INSERT INTO producto
(codigo, nombre, categoria, precio, stock)
VALUES
    ('TEMP-001', 'Producto temporal', 'Pruebas', 50.00, 5);

INSERT INTO producto
(codigo, nombre, categoria, precio, stock)
VALUES
    ('ERR-001', 'Producto stock negativo', 'Pruebas', 75.00, -5);

-- Corrección del código duplicado
INSERT INTO producto
(codigo, nombre, categoria, precio, stock)
VALUES
    ('COR-001', 'Producto corregido', 'Electronica', 100.00, 5);

-- Corrección del stock negativo
INSERT INTO producto
(codigo, nombre, categoria, precio, stock)
VALUES
    ('ERR-001', 'Producto corregido stock', 'Pruebas', 75.00, 5);