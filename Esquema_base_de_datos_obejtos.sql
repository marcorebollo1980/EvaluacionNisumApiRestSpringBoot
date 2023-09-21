
nombre de la base de datos:testdb
     
    create table telefono (
        id bigint not null,
        citycode varchar(255),
        contrycode varchar(255),
        number varchar(255),
        usuario_id varchar(255),
        primary key (id)
    )
Hibernate: 
    
    create table usuario (
        id varchar(255) not null,
        created date,
        email varchar(255),
        isactive varchar(255),
        lastlogin date,
        modified date,
        name varchar(255),
        password varchar(255),
        primary key (id)
    )
  
    alter table telefono 
       add constraint FKpi2c7iq0lw09d1ovc7bn86f85 
       foreign key (usuario_id) 
       references usuario

create sequence hibernate_sequence start with 1 increment by 1;
 
 alter table telefonos 
 add constraint FKl3otxxalhle2n1guo6vs6gf8d 
 foreign key (usuario_id) 
 references usuarios;
 
SELECT * FROM TELEFONO;

SELECT * FROM USUARIO;
