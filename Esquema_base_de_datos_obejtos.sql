
nombre de la base de datos:testdb
     
    create table telefonos (
        id bigint not null,
        citycode varchar(255),
        contrycode varchar(255),
        number varchar(255),
        usuario_id bigint,
        primary key (id)
    );

    
    create table usuarios (
        id bigint not null,
        email varchar(255),
        name  varchar(255),
        password varchar(255),
        primary key (id)
    );

create sequence hibernate_sequence start with 1 increment by 1;
 
 alter table telefonos 
 add constraint FKl3otxxalhle2n1guo6vs6gf8d 
 foreign key (usuario_id) 
 references usuarios;