package com.postapp.postapp.repository;

import com.postapp.postapp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {
    @Autowired
    JdbcTemplate db;

    //Buscar todos os usuario
    public List<Usuario> findAll(){
        List<Usuario> list = db.query(
                "select * from usuario;",
                (rs, rowNum) -> {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setFoto(rs.getString("foto"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setPerfil(rs.getString("perfil"));
                    usuario.setTelefone(rs.getString("telefone"));
                    usuario.setUsername(rs.getString("username"));
                    return  usuario;
                }
        );
        return list;
    }
    public Usuario findById(int id){
        Usuario user = db.queryForObject(
            "select * from usuario where id = ?;",
                (rs, rowNum) -> {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setFoto(rs.getString("foto"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setPerfil(rs.getString("perfil"));
                    usuario.setTelefone(rs.getString("telefone"));
                    usuario.setUsername(rs.getString("username"));
                    return  usuario;
                },
                id);
        return user;
    }
    public Usuario findBy(String username){
        Usuario user = db.queryForObject(
                "select * from usuario where username = ?;",
                (rs, rowNum) -> {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setFoto(rs.getString("foto"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setPerfil(rs.getString("perfil"));
                    usuario.setTelefone(rs.getString("telefone"));
                    usuario.setUsername(rs.getString("username"));
                    return  usuario;
                },
                username);
        return user;
    }
    public void save(Usuario usuario) {
        db.update("insert into usuario(nome, telefone, email, senha, username, foto, perfil) values (?, ?, ?,?,?, ?,?);",
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getUsername(),
                usuario.getFoto(),
                usuario.getPerfil()
                );
    }
    public void update(Usuario usuario){
        db.update(
                "update usuario set nome=?, telefone=?, email=?, senha=?, username=?, foto=?, perfil=? where id = ?",
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getUsername(),
                usuario.getFoto(),
                usuario.getPerfil(),
                usuario.getId()
        );
    }

}
