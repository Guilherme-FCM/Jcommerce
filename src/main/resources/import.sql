insert into `jcommerce`.`role` (id, name) values (1, "ROLE_ADMIN");
insert into `jcommerce`.`role` (id, name) values (2, "ROLE_EMPLOYEE");
insert into `jcommerce`.`role` (id, name) values (3, "ROLE_USER");

insert into `jcommerce`.`user` (id, name, email, password) values (1, "Administrador", "admin@jcommerce.com", "$2a$10$VnsmA6rAOstufZlu5jjLHO90G8XRmiDh.3wzsMAyoRj2BCXE4NaAq");

insert into `jcommerce`.`user_roles` (users_id, roles_id) values (1,1);