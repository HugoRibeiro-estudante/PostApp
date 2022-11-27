#drop database articlesys;
#create database articlesys;
#use articlesys;

create table usuario(
    id int auto_increment primary key not null,
    nome varchar(40) not null,
    telefone varchar(20),
    email varchar(40) not null,
    senha varchar(40) not null,
    username varchar(40) not null,
    perfil varchar(40) not null,
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
    create_data datetime not null,
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
    create_data datetime not null,
    foreign key (id_postagem) references postagem(id),
    foreign key (id_usuario) references usuario(id)
);

#USUARIO
insert into usuario(nome, telefone, email, senha, username, foto, perfil) values ("Lucas Ilussencio da silva", "34912345678", "ilussencio@gmail.com","password","ilussencio", "https://media-exp1.licdn.com/dms/image/C4E03AQHR0yPiwVtfjA/profile-displayphoto-shrink_800_800/0/1654528097336?e=2147483647&v=beta&t=pJ5UEI9qA4pBa1dte4Qr04toC5PUfeaVY-0E5dv0-QE","ADMIN");
insert into usuario(nome, telefone, email, senha, username, foto, perfil) values ("Patricia Santana Santiago", "34912345678", "patriciasantanasantiago@gmail.com","password","pssantiago", "fotoperfil.jpg","USER");
#CATEGORIA
insert into categorias(nome) values ("Desenvolvimento"),("Java"),("HTML"),("CSS"),("JavaScript"),("Git Hub");
#USUARIO CATEGORIA
insert into usuario_categorias(id_usuario, id_categoria) values (1,1),(1,2),(1,3),(1,4);
#POSTAGEM
insert into postagem(id_usuario, titulo, subtitulo, corpo, create_data) values
(1,"JAVA SCRIPT", "Porque utilizar JavaScript","<main> CORPO DA POSTAGEM SOBRE JAVA SCRIPT</main>","2022-11-19T13:00:00"),
(1,"HTML", "Porque utilizar HTML","<main> CORPO DA POSTAGEM SOBRE HTML</main>","2022-11-19T13:00:00"),
(1,"CSS", "Porque utilizar CSS","<main> CORPO DA POSTAGEM SOBRE CSS</main>","2022-11-19T13:00:00"),
(1,"JAVA", "Porque utilizar JavaScript","<main> CORPO DA POSTAGEM SOBRE JAVA</main>","2022-11-19T13:00:00");
#CATEGORIA POSTAGEM
insert into postagem_categorias(id_postagem,id_categoria) values (1,1),(1,5),(2,1),(2,3),(3,1),(3,4),(4,1),(1,2);
#COMENTARIO
insert into comentario(id_postagem, id_usuario, comentario, create_data) values
(1,2,"Otimo conteudo de JAVA SCRIPT", "2022-11-19T13:00:00"),
(2,2,"Otimo conteudo de HTML", "2022-11-19T13:00:00"),
(3,2,"Otimo conteudo de CSS", "2022-11-19T13:00:00"),
(4,2,"Otimo conteudo de JAVA", "2022-11-19T13:00:00"),
(1,1,"eu que fiz JAVA SCRIPT", "2022-11-19T13:00:00"),
(2,1,"eu que fiz HTML", "2022-11-19T13:00:00"),
(3,1,"eu que fiz CSS", "2022-11-19T13:00:00"),
(4,1,"eu que fiz JAVA", "2022-11-19T13:00:00");
