--liquibase formatted sql

--changeset kmatveev:rolesimport
--preconditions onFail:CONTINUE onError:CONTINUE
insert into animals.expOrganization (idOfExploitingOrganization, nameOfExploitingOrganization) values
(1, 'ГБУ «Автомобильные дороги САО»'),
(2, 'ГБУ «Автомобильные дороги СВАО»'),
(3, 'ГБУ «Автомобильные дороги ВАО»'),
(4, 'ГБУ «Автомобильные дороги ЮАО»'),
(5, 'ГБУ «Автомобильные дороги ЮЗАО»'),
(6, 'ГБУ «Автомобильные дороги ЮВАО»'),
(7, 'ГБУ «Автомобильные дороги ЗАО»'),
(8, 'ГБУ «Доринвест»')
on conflict (idOfExploitingOrganization) do update
set nameOfExploitingOrganization = excluded.nameOfExploitingOrganization;
