--liquibase formatted sql

--changeset kmatveev:rolesimport
--preconditions onFail:CONTINUE onError:CONTINUE
insert into animals.roles (role_id, role_name) values
(1, 'ADMIN'),
(2, 'USER')
on conflict (role_id) do update
set role_name = excluded.role_name;
