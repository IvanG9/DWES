-- Copyright Jose Ramón Cebolla - 2023
-- -----------------------------------------------------
-- Table `ciudades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS ciudades;
CREATE  TABLE IF NOT EXISTS ciudades(
id IDENTITY,
nombre VARCHAR(50),
habitantes BIGINT,
 CONSTRAINT pk_ciudades PRIMARY KEY(id));


-- -----------------------------------------------------
-- Table `jornadas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jornadas` ;

CREATE  TABLE IF NOT EXISTS `jornadas` (
  `num` BIGINT NOT NULL ,
  `fecha` VARCHAR(10) NULL DEFAULT NULL ,
  CONSTRAINT pk_jornadas PRIMARY KEY (`num`) );
-- ---------------------------------------------------
-- INSERCIÓN DE DATOS
-- ---------------------------------------------------

INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (2,'Alacant',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (3,'Albacete',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (4,'Almeria',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (5,'Astúries',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (6,'Àvila',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (7,'Badajoz',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (8,'Barcelona',1615000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (9,'Bilbao',353000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (10,'Biscaia',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (11,'Burgos',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (12,'Càceres',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (13,'Cadis',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (14,'Cantàbria',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (15,'Castelló',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (16,'Ceuta',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (17,'Ciudad Real',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (18,'Còrdova',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (19,'Cornellà de Llobregat',85000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (20,'Cuenca',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (21,'Getafe',169000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (22,'Girona',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (23,'Granada',234000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (24,'Guadalajara',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (25,'Guipúscoa',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (26,'Huelva',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (27,'Illes Balears',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (28,'Jaén',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (29,'La Corunya',246000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (30,'La Rioja',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (31,'Las Palmas',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (32,'Lleida',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (33,'Lleó',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (34,'Lugo',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (35,'Madrid',3293000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (36,'Màlaga',568000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (37,'Melilla',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (38,'Múrcia',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (39,'Navarra',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (40,'Orense',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (41,'Osca',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (42,'Palència',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (43,'Palma de Mallorca',400000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (44,'Pamplona',197000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (45,'Pontevedra',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (46,'Salamanca',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (47,'Sant Sebastià',186000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (48,'Santa Cruz de Tenerife',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (49,'Saragossa',680000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (50,'Segòvia',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (51,'Sevilla',702000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (52,'Sória',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (53,'Tarragona',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (54,'Terol',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (55,'Toledo',NULL);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (56,'València',798000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (57,'Valladolid',313000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (58,'Vigo',297000);
INSERT INTO `ciudades` (`id`,`nombre`,`habitantes`) VALUES (59,'Zamora',NULL);

/*
-- Query: select * from jornadas
*/
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (1,'2019-08-19');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (2,'2019-08-26');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (3,'2020-12-29');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (4,'2019-09-16');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (5,'2019-09-23');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (6,'2002-01-11');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (7,'2020-05-13');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (8,'2019-10-21');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (9,'2019-10-28');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (10,'2019-11-04');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (11,'2019-11-11');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (12,'2019-11-18');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (13,'2019-11-25');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (14,'2019-12-02');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (15,'2019-12-09');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (16,'2019-12-16');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (17,'2019-12-22');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (18,'2020-01-06');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (19,'2020-01-13');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (20,'2020-01-20');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (21,'2020-01-27');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (22,'2020-02-03');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (23,'2020-02-10');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (24,'2020-02-17');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (25,'2020-02-24');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (26,'2020-03-03');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (27,'2020-03-10');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (28,'2020-03-17');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (29,'2020-03-31');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (30,'2020-04-07');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (31,'2020-04-14');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (32,'2020-04-21');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (33,'2020-04-28');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (34,'2020-05-05');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (35,'2020-05-12');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (36,'2020-05-19');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (37,'2020-05-29');
INSERT INTO `jornadas` (`num`,`fecha`) VALUES (38,'2020-06-01');

-- -----------------------------------------------------
-- Table `equipos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipos` ;

CREATE  TABLE IF NOT EXISTS equipos (
  id VARCHAR(3) NOT NULL ,
  nombre_corto VARCHAR(20) NULL DEFAULT NULL ,
  nombre_largo VARCHAR(40) NULL DEFAULT NULL ,
  ciudad  BIGINT NULL DEFAULT NULL ,
  entrenador VARCHAR(30) NULL DEFAULT NULL ,
  estadio VARCHAR(30) NULL DEFAULT NULL ,
  marca VARCHAR(30) NULL DEFAULT NULL ,
  patrocinador VARCHAR(30) NULL DEFAULT NULL ,
  presupuesto BIGINT NULL DEFAULT NULL ,
   CONSTRAINT pk_equipos PRIMARY KEY (id) ,
  CONSTRAINT  fk_equipos_ciudad
    FOREIGN KEY (ciudad )
    REFERENCES ciudades (id ));

CREATE  INDEX idCiudadEnEquipo  ON  equipos (ciudad ASC) ;

/*
-- Query: select * from equipos
*/
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('ath','Athletic','Athletic Club',9,'Marcelo Bielsa','estadioo de San Mamés','Umbro','Petronor',58);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('atm','At. Madrid','Club Atlético de Madrid',35,'Diego Simeone','Vicente Calderón','Nike','Azerbaiyán',120);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('bar','Barça','Futbol Club Barcelona',8,'Tito Vilanova','Camp Nou','Qatar Foundation','UNICEF',470);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('bet','Real Betis','Real Betis Balompié',51,'Pepe Mel','Benito Villamarín','Cirsa','Andalucía',40);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('cel','Celta de Vigo','Real Club Celta de Vigo',58,'Abel Resino','estadioo de Balaídos','Adidas','Citroen',33);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('dep','Deportivo','Real Club Deportivo de La Coruña',29,'Fernando Vàquez Pena','Riazor','Lotto Sport Italia','Hijos de Rivera',40);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('esp','Espanyol','Reial Club Deportiu Espanyol',8,'Javier Aguirre','Cornellà-El Prat','Puma','Cancún',46);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('gda','Granada','Granada Club de Fútbol',23,'Lucas Alcaraz','Los Cármenes','Caja Granada','',30);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('get','Getafe','Getafe Club de Fútbol',21,'Luis Garcia Plaza','Coliseum Alfonso Pérez','Joma','',42);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('lev','Llevant','LLevant Unió Esportiva',56,'Juan Ignacio Martínez Jimenez','ciudad de València','Kelme','Comunitat Valenciana',22);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('mal','Mallorca','Real Club Deportivo Mallorca',43,'Gregorio Manzano','Iberostar estadioo','Riviera Maya','Sol Melià',31);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('mga','Málaga','Málaga Club de Fútbol',36,'Manuel Pellegrini','estadioo La Rosaleda','Unesco','Porsche',80);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('osa','Osasuna','Club Atlético Osasuna',44,'Jose Luis Mendilíbar','Reyno de Navarra','','',30);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('ray','Rayo Vallecano','Rayo Vallecano de Madrid',35,'Paco Jiménez','Campo de Fútbol de Vallecas','Errer','',8);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('rma','Real Madrid','Real Madrid Club de Fútbol',35,'José Mourinho','Santiago Bernabéu','Adidas','',517);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('rso','Real Sociedad','Real Sociedad de Fútbol',47,'Philippe Montanier','Anoeta','Canal','Kutxa',43);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('sev','Sevilla','Sevilla Fútbol Club',51,'Unai Emery','Ramón Sánchez Pizjuán','','',60);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('val','València','València Club de Futbol',56,'Ernesto Valverde','Mestalla','','',103);
INSERT INTO equipos (id,nombre_corto,nombre_largo,ciudad,entrenador,estadio,marca,patrocinador,presupuesto) VALUES ('zar','Zaragoza','Real Zaragoza',49,'Manolo Jiménez Jiménez','La Romareda','Telefonica','Canal',0);