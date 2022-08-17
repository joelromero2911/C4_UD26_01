drop database if exists C4_UD26_01;
create database C4_UD26_01;
use C4_UD26_01;

CREATE TABLE piezas (
	codigo int auto_increment,
	nombre varchar(100),
	PRIMARY KEY (codigo)
);

CREATE TABLE proveedores (
	id char(4),
	nombre varchar(100),
	PRIMARY KEY (id)
);

CREATE TABLE suministra (
	id_auto int auto_increment,
	codigo_pieza int,
	id_proveedor char(4),
    precio int,
	PRIMARY KEY (id_auto),
    constraint suministra_fk foreign key (codigo_pieza) references piezas(codigo)
    on update cascade on delete cascade,
    constraint suministra_fk_01 foreign key (id_proveedor) references proveedores(id)
    on update cascade on delete cascade
);

insert into piezas(nombre) values 
	("Pieza 1"),
    ("Pieza 2"),
    ("Pieza 3");
    
insert into proveedores(id, nombre) values 
	("AB01", "Proveedor 1"),
    ("AB02", "Proveedor 2"),
    ("AB03", "Proveedor 3");
    
insert into suministra(codigo_pieza, id_proveedor, precio) values 
	(1, "AB01", 2),
    (2, "AB02", 3),
    (3, "AB03", 2);