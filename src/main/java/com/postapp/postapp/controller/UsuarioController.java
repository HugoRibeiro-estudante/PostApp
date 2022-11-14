package com.postapp.postapp.controller;

import com.postapp.postapp.model.Postagem;
import com.postapp.postapp.model.Usuario;
import com.postapp.postapp.repository.PostagemRepository;
import com.postapp.postapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PostagemRepository postagemRepository;


    @GetMapping("/{username}")
    public String postUser(@PathVariable String username, Model model){
        System.out.println(username);
        Usuario usuario = usuarioRepository.findBy(username);
        List<Postagem> postagems = postagemRepository.findBy(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("postagems",postagems);
        System.out.println(usuario);
        System.out.println(postagems);
        return "postagems_usuario";
    }
}
