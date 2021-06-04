create table person (
                        id serial primary key,
                        firstname varchar(128),
                        lastname varchar(128)
);

alter table person add column position_id integer;

alter table person add foreign key(position_id) references position(id);
