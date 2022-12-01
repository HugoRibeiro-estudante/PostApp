package com.postapp.postapp.repository;

import com.postapp.postapp.model.Categoria;
import com.postapp.postapp.model.Postagem;
import com.postapp.postapp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class PostagemRepository {
    @Autowired
    JdbcTemplate db;
    @Autowired
    UsuarioRepository usuarioRepository;

    

    public List<Postagem> findAll(){
        List<Postagem> list = db.query(
                "select * from postagem;",
                (rs, rowNum) -> {
                    Postagem postagem = new Postagem();
                    postagem.setId(rs.getInt("id"));
                    postagem.setTitulo(rs.getString("titulo"));
                    postagem.setCorpo(rs.getString("corpo"));
                    postagem.setSubtitulo(rs.getString("subtitulo"));
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime localDateTime = LocalDateTime.parse(rs.getString("create_data"), dateTimeFormatter);
                    postagem.setCreate_data(localDateTime);
                    postagem.setId_usuario(usuarioRepository.findById(rs.getInt("id_usuario")));
                    return postagem;
                }
        );
        return list;
    }

    public List<Postagem> findBy(Usuario usuario){
        List<Postagem> list = db.query(
                "select * from postagem where id_usuario = ?;",
                (rs, rowNum) -> {
                    Postagem postagem = new Postagem();
                    postagem.setId(rs.getInt("id"));
                    postagem.setTitulo(rs.getString("titulo"));
                    postagem.setCorpo(rs.getString("corpo"));
                    postagem.setSubtitulo(rs.getString("subtitulo"));
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime localDateTime = LocalDateTime.parse(rs.getString("create_data"), dateTimeFormatter);
                    postagem.setCreate_data(localDateTime);
                    postagem.setId_usuario(usuarioRepository.findById(rs.getInt("id_usuario")));
                    return postagem;
                },usuario.getId());
        return list;
    }
    

    public List<Postagem> findBy(Usuario usuario, int limit, int current){
        List<Postagem> list = db.query(
                "select id, titulo, subtitulo from postagem where id_usuario = ? and id != ? order by rand() limit ?;",
                (rs, rowNum) -> {
                    Postagem postagem = new Postagem();
                    postagem.setId(rs.getInt("id"));
                    postagem.setTitulo(rs.getString("titulo"));
                    postagem.setSubtitulo(rs.getString("subtitulo"));
                    return postagem;
                },usuario.getId(),current, limit);
        return list;
    }

    public List<Postagem> findBy(List<Categoria> cat, int limit){
        Object[] categorias = cat.stream().map(x -> x.getId()).toArray();

        List<Postagem> list = db.query(
                "select p.id, p.titulo, p.subtitulo from postagem_categorias join postagem p on postagem_categorias.id_postagem = p id where id_categoria in (?) order by rand() limit ?;",
                (rs, rowNum) -> {
                    Postagem postagem = new Postagem();
                    postagem.setId(rs.getInt("id"));
                    postagem.setTitulo(rs.getString("titulo"));
                    postagem.setSubtitulo(rs.getString("subtitulo"));
                    return postagem;
                },categorias, limit);
        return list;
    }

   

    public Postagem findById(int id){
       Postagem post = db.queryForObject(
                "select * from postagem where id = ?;",
                (rs, rowNum) -> {
                    Postagem postagem = new Postagem();
                    postagem.setId(rs.getInt("id"));
                    postagem.setTitulo(rs.getString("titulo"));
                    postagem.setCorpo(rs.getString("corpo"));
                    postagem.setSubtitulo(rs.getString("subtitulo"));
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime localDateTime = LocalDateTime.parse(rs.getString("create_data"), dateTimeFormatter);
                    postagem.setCreate_data(localDateTime);
                    postagem.setId_usuario(usuarioRepository.findById(rs.getInt("id_usuario")));
                    return postagem;
                },id);
        return post;
    }

}
