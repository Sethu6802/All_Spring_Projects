insert into users(username, password, enabled)
values ('bond','james',true);

insert into users(username, password, enabled)
values ('poo','bear',true);

insert into authorities(username, authorities)
values ('bond','ROLE_USER');

insert into authorities(username, authorities)
values ('poo','ROLE_ADMIN');