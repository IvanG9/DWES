DROP TABLE IF EXISTS modulos;
CREATE TABLE modulos (
    id IDENTITY,  -- `identity` = auto-incrementing 64-bit long integer.
    nombre VARCHAR(50) NOT NULL,
    num_horas INT, 
    abreviatura VARCHAR(5), 
    CONSTRAINT pk_modulos PRIMARY KEY(id)
);

insert into modulos(nombre, num_horas, abreviatura)
    values('Programación', 8, 'PRO');
insert into modulos(nombre, num_horas, abreviatura)
    values('Desarrollo Web en Entornos Servidor', 8, 'DWES');
insert into modulos(nombre, num_horas, abreviatura)
    values('Entornos de Desarrollo', 3, 'EDD');