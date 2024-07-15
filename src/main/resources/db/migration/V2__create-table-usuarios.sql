create table usuarios(

    id bigserial not null,
    username varchar(100) not null,
    password varchar(300) not null,

    primary key(id)

);