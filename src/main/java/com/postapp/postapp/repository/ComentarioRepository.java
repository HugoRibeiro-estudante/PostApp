package com.postapp.postapp.repository;

import com.postapp.postapp.model.Comentario;
import com.postapp.postapp.model.Postagem;
import com.postapp.postapp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComentarioRepository {
    @Autowired
    JdbcTemplate db;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PostagemRepository postagemRepository;

    public List<Comentario> findBy(Postagem postagem){
        List<Comentario> list = db.query(
                "select * from comentario where id_postagem = ?;",
                (rs, rowNum) -> {
                   Comentario comentario = new Comentario();
                   comentario.setId(rs.getInt("id"));
                   comentario.setComentario(rs.getString("comentario"));
                   comentario.setId_usuario(usuarioRepository.findById(rs.getInt("id_usuario")));
                   return comentario;
                },postagem.getId());
        return list;
    }
}
