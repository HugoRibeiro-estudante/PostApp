package com.postapp.postapp.controller;

import com.postapp.postapp.model.Categoria;
import com.postapp.postapp.model.Postagem;
import com.postapp.postapp.model.Usuario;
import com.postapp.postapp.repository.CategoriaRepository;
import com.postapp.postapp.repository.PostagemRepository;
import com.postapp.postapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PostagemRepository postagemRepository;
    @Autowired
    CategoriaRepository categoriaRepository;


    @GetMapping("/{username}")
    public String postsUser(@PathVariable String username, Model model){
        System.out.println(username);
        Usuario usuario = usuarioRepository.findBy(username);
        List<Postagem> postagems = postagemRepository.findBy(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("postagems",postagems);
        System.out.println(usuario);
        System.out.println(postagems);
        return "posts_for_user";
    }

    @GetMapping("/cadastrar")
    public String SaveUser(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastra_usuario";
    }

    @PostMapping("/cadastrar")
    public String novoTipo(Usuario usuario, Model model) {
        usuarioRepository.save(usuario);
        List<Categoria> categorias = categoriaRepository.findAll();

        model.addAttribute("usuario", usuario);
        model.addAttribute("categorias", categorias);

        List<Categoria> cat = new ArrayList<>();
        model.addAttribute("cat", new Categoria());
        return "usuario/usuario_categoria";
    }
    @PostMapping("/cadastrarUsuarioCategorias")
    public String cadastrarCategorias(Categoria cat, Model model) {
        System.out.println(cat);
        return "home";
    }

}
