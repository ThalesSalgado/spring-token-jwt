drop table if exists role
drop table if exists user_app
drop table if exists user_roles
drop table if exists permission

--create table user_app (id bigint not null auto_increment, age integer, password varchar(255), salary bigint, username varchar(255), primary key (id))
create table user_app (id bigint not null auto_increment, username varchar(255) unique, application varchar(255), password varchar(255), primary key (id))
create table role (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id))
create table permission (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id))

create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id))
alter table user_roles add constraint foreign key (role_id) references role (id)
alter table user_roles add constraint foreign key (user_id) references user_app (id)

create table role_permissions (role_id bigint not null, permission_id bigint not null, primary key (role_id, permission_id))
alter table role_permissions add constraint foreign key (role_id) references role (id)
alter table role_permissions add constraint foreign key (permission_id) references permission (id)


INSERT INTO user_app (id, username, application, password) VALUES (1, 'user1', 'Delfos', '$2a$10$HTx0Pt6VQERJ/fgxSlNyQO/suHNbAvTupTjOrCBgqnnOjidS6zBDC');
INSERT INTO user_app (id, username, application, password) VALUES (2, 'user2', 'Delfos', '$2a$10$dTod4LQlkNhJbFzF1dFeX.PflcUB5uMlnqt4E7AwP6GCt1oZJDT8i');
INSERT INTO user_app (id, username, application, password) VALUES (3, 'user3', 'Delfos', '$2a$10$xpDMpHDWI9A0tXu3QwlYsePeN8g2rQhN3yFxHD1pecGrsBjKB1waW');

INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'User role', 'USER');
INSERT INTO role (id, description, name) VALUES (3, 'User role', 'ANALIST');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);