create table topicos(

    id bigserial not null,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor varchar(100) not null,
    status varchar(100) not null,
    curso varchar(100) not null,

    primary key(id)

);