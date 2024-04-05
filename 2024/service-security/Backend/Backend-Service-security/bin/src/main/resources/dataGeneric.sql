INSERT INTO `service_security`.`country`
(`state`, `id`, `code`, `name`)
VALUES
('', 1, 'AR', 'Argentina'),
('', 2, 'BO', 'Bolivia'),
('', 3, 'BR', 'Brazil'),
('', 4, 'CL', 'Chile'),
('', 5, 'CO', 'Colombia'),
('', 6, 'EC', 'Ecuador'),
('', 7, 'GY', 'Guyana'),
('', 8, 'PE', 'Peru'),
('', 9, 'PY', 'Paraguay'),
('', 10, 'SR', 'Suriname'),
('', 11, 'UY', 'Uruguay'),
('', 12, 'VE', 'Venezuela');


INSERT INTO `service_security`.`department`
(`state`, `id`, `country_id`, `code`, `name`)
VALUES
('', 1, 5, 'DC', 'Distrito Capital'),
('', 2, 5, 'AMA', 'Amazonas'),
('', 3, 5, 'ANT', 'Antioquia'),
('', 4, 5, 'ARA', 'Arauca'),
('', 5, 5, 'ATL', 'Atlántico'),
('', 6, 5, 'BOL', 'Bolívar'),
('', 7, 5, 'BOY', 'Boyacá'),
('', 8, 5, 'CAL', 'Caldas'),
('', 9, 5, 'CAQ', 'Caquetá'),
('', 10, 5, 'CAS', 'Casanare'),
('', 11, 5, 'CAU', 'Cauca'),
('', 12, 5, 'CES', 'Cesar'),
('', 13, 5, 'CHO', 'Chocó'),
('', 14, 5, 'COR', 'Córdoba'),
('', 15, 5, 'CUN', 'Cundinamarca'),
('', 16, 5, 'GUA', 'Guainía'),
('', 17, 5, 'GUV', 'Guaviare'),
('', 18, 5, 'HUI', 'Huila'),
('', 19, 5, 'GUV', 'La Guajira'),
('', 20, 5, 'MAG', 'Magdalena'),
('', 21, 5, 'MET', 'Meta'),
('', 22, 5, 'NAR', 'Nariño'),
('', 23, 5, 'NSA', 'Norte de Santander'),
('', 24, 5, 'PUT', 'Putumayo'),
('', 25, 5, 'QUI', 'Quindío'),
('', 26, 5, 'RIS', 'Risaralda'),
('', 27, 5, 'SAP', 'San Andrés y Providencia'),
('', 28, 5, 'SAN', 'Santander'),
('', 29, 5, 'SUC', 'Sucre'),
('', 30, 5, 'TOL', 'Tolima'),
('', 31, 5, 'VAC', 'Valle del Cauca'),
('', 32, 5, 'VAU', 'Vaupés'),
('', 33, 5, 'VID', 'Vichada');




INSERT INTO `service_security`.`city`
(`state`, `department_id`, `id`, `code`, `name`)
VALUES
('', 18, 1, '001', 'Neiva'),
('', 18, 2, '002', 'Pitalito'),
('', 18, 3, '003', 'Garzón'),
('', 18, 4, '004', 'Campoalegre'),
('', 18, 5, '005', 'La Plata');




INSERT INTO `service_security`.`module`
(`state`, `id`, `description`, `name`, `route`)
VALUES
('', 1, 'Módulo de seguridad', 'Security', '/security'),
('', 2, 'Módulo de parámetro', 'Parameter', '/parameter'),
('', 3, 'Módulo operativo', 'Operational', '/operational');


INSERT INTO `service_security`.`role`
(`state`, `id`, `description`, `name`)
VALUES
('', 1, 'Rol de administrador', 'admin'),
('', 2, 'Rol de usuario normal', 'user');




INSERT INTO service_security.view
(
state,
description,
name,
route)
VALUES
(true,'person','person','./person.html'),
(true,'role','role','./role.html'),
(true,'module','module','./module.html'),
(true,'user','user','./user.html'),
(true,'view','view','./view.html'),
(true,'country','country','./country.html'),
(true,'department','department','./department.html'),
(true,'city','city','./city.html');



INSERT INTO service_security.module_view
(

module_id,
view_id)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(2,6),
(2,7),
(2,8);



INSERT INTO service_security.module_role
(module_id, role_id)
VALUES
(1, 1),
(2, 1),
(3, 1),
(2, 2),
(3, 2);



INSERT INTO service_security.person
(date_of_birth, state, city_id, id, gender, phone, email, first_name, last_name, address)
VALUES
('2000-01-01', true, 1, 1, 'Masculino', '1234567890', 'correo@example.com', 'Nombre', 'Apellido', 'Dirección');

INSERT INTO service_security.person
(date_of_birth, state, city_id, id, gender, phone, email, first_name, last_name, address)
VALUES
('2000-01-01', true, 1, 2, 'Masculino', '1234567890', 'stev@example.com', 'deidara', 'sss', 'ddd');

INSERT INTO `service_security`.`user`
(

`state`,

`password`,
`username`,
`person_id`)
VALUES
(true,"1234","drago",1
);




INSERT INTO service_security.user_role
(

role_id,
user_id)
VALUES
(
1,
1);

