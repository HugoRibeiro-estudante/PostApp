package com.postapp.postapp.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.postapp.postapp.model.Categoria;
import com.postapp.postapp.model.Usuario;
import com.postapp.postapp.repository.CategoriaRepository;
import com.postapp.postapp.repository.UsuarioRepository;

@Controller
public class CriarPost {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/criarpost")
    public String Criacao(Model model, HttpServletRequest request) {
      List<Categoria> listCategoria = categoriaRepository.findAll();
      model.addAttribute("categorias", listCategoria);

      try {
        Principal principal = request.getUserPrincipal();
        Usuario usr = usuarioRepository.findByUsername(principal.getName()).get();
        model.addAttribute("userlog", usr);
      } catch (Exception e) {
          System.out.println(e);
      }

      return "post/criarpost";
    }    
}
