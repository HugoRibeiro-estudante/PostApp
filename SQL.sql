#drop database articlesys;
create database articlesys;
use articlesys;

create table usuario(
    id int auto_increment primary key not null,
    nome varchar(40) not null,
    telefone varchar(20),
    email varchar(40) not null,
    senha varchar(40) not null,
    username varchar(40) not null,
    foto varchar(255)
);

create table categorias(
    id int auto_increment primary key not null,
    nome varchar(40) not null
);

create table usuario_categorias(
    id int auto_increment primary key not null,
    id_usuario int not null, 
    id_categoria int not null,
    foreign key (id_usuario) references usuario(id),
    foreign key (id_categoria) references categorias(id)
);

create table postagem(
    id int auto_increment primary key not null,
    id_usuario int not null,
    titulo varchar(50) not null,
    subtitulo varchar(50),
    corpo mediumtext not null,
    foreign key (id_usuario) references usuario(id)
);

create table postagem_categorias(
	id int auto_increment not null,
    id_categoria int not null,
    id_postagem int not null,
    primary key(id),
    foreign key (id_categoria) references categorias(id),
    foreign key (id_postagem) references postagem(id)
);

create table comentario(
    id int auto_increment primary key not null,
    id_postagem int not null,
    id_usuario int not null,
    comentario mediumtext not null,
    foreign key (id_postagem) references postagem(id),
    foreign key (id_usuario) references usuario(id)
);