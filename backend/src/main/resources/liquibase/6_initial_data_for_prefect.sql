--liquibase formatted sql

--changeset kmatveev:prefectimport
--preconditions onFail:CONTINUE onError:CONTINUE
insert into animals.prefect (idOfPrefect, nameOfPrefectn) values
(1, 'Префектура СВАО'),
(2, 'Префектура ВАО'),
(3, 'Префектура ЮАО'),
(4, 'ДЖКХ города Москвы'),
(5, 'Префектура САО'),
(6, 'Префектура ЗАО'),
(7, 'Префектура ЮВАО'),
(8, 'Префектура ЮЗАО')
