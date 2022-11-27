package com.postapp.postapp.controller;

import com.postapp.postapp.model.Categoria;
import com.postapp.postapp.model.Comentario;
import com.postapp.postapp.model.Postagem;
import com.postapp.postapp.repository.CategoriaRepository;
import com.postapp.postapp.repository.ComentarioRepository;
import com.postapp.postapp.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostagemController {
    @Autowired
    PostagemRepository postagemRepository;

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/{id}")
    public String ListOnePost(@PathVariable int id, Model model) {
        Postagem post = postagemRepository.findById(id);
        List<Comentario> list = comentarioRepository.findBy(post);
        List<Categoria> categorias = categoriaRepository.findBy(post);

        model.addAttribute("post", post);
        model.addAttribute("usuario", post.getId_usuario());
        model.addAttribute("comentario", list);
        model.addAttribute("categorias", categorias);
        return "post/post";
    }
}
