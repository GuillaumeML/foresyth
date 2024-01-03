-- Changeset gml:0001
-- Contexts:
-- Precondition:

create table chatters_entity(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_chatters_entity foreign key(username) references chatters_entity(username)
);
create unique index ix_auth_username on authorities (username,authority);

