package com.postapp.postapp.repository;

import com.postapp.postapp.model.Postagem;
import com.postapp.postapp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
                    postagem.setId_usuario(usuarioRepository.findById(rs.getInt("id_usuario")));
                    return postagem;
                },usuario.getId());
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
                    postagem.setId_usuario(usuarioRepository.findById(rs.getInt("id_usuario")));
                    return postagem;
                },id);
        return post;
    }

}
