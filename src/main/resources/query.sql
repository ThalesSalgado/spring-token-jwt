select * from user_app;
select * from role;
select * from permission;
select * from user_roles;
select * from role_permissions;

INSERT INTO user_app (id, username, application, password) VALUES (1, 'user1', 'Delfos', '$2a$10$HTx0Pt6VQERJ/fgxSlNyQO/suHNbAvTupTjOrCBgqnnOjidS6zBDC');
INSERT INTO user_app (id, username, application, password) VALUES (2, 'user2', 'Delfos', '$2a$10$dTod4LQlkNhJbFzF1dFeX.PflcUB5uMlnqt4E7AwP6GCt1oZJDT8i');
INSERT INTO user_app (id, username, application, password) VALUES (3, 'user3', 'Delfos', '$2a$10$xpDMpHDWI9A0tXu3QwlYsePeN8g2rQhN3yFxHD1pecGrsBjKB1waW');

INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'User role', 'USER');
INSERT INTO role (id, description, name) VALUES (3, 'User role', 'ANALIST');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);

insert into permission (id, description, name) values (1, '', 'POLICIES_ALL');
insert into permission (id, description, name) values (2, '', 'POLICIES_READ');
insert into permission (id, description, name) values (3, '', 'POLICIES_APPROVE');
insert into permission (id, description, name) values (4, '', 'POLICIES_CREATE');
insert into permission (id, description, name) values (5, '', 'USERS_ALL');
insert into permission (id, description, name) values (6, '', 'USERS_READ');
insert into permission (id, description, name) values (7, '', 'USERS_CREATE');
insert into permission (id, description, name) values (8, '', 'USERS_EDIT');

insert into role_permissions (role_id, permission_id) values (1, 1);
insert into role_permissions (role_id, permission_id) values (2, 2);
insert into role_permissions (role_id, permission_id) values (3, 2);
insert into role_permissions (role_id, permission_id) values (3, 4);
insert into role_permissions (role_id, permission_id) values (1, 5);
insert into role_permissions (role_id, permission_id) values (3, 6);
