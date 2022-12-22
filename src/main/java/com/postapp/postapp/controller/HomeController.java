package com.postapp.postapp.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.postapp.postapp.model.Usuario;
import com.postapp.postapp.repository.UsuarioRepository;

@Controller
public class HomeController {
  @Autowired
  UsuarioRepository usuarioRepository;
  
  @Autowired
  JdbcTemplate db;

  @GetMapping("/")
  public String HomeController(Model model, HttpServletRequest request) {

    try {
      Principal principal = request.getUserPrincipal();
      Usuario usuario = usuarioRepository.findByUsername(principal.getName()).get();
      System.out.println(usuario.getFoto());
      model.addAttribute("userlog", usuario);
    } catch (Exception e) {
      System.out.println(e);
    }

    return "home/home";
  }
  
  @GetMapping("/home")
  public String Home(Model model, HttpServletRequest request) {

    try {
      Principal principal = request.getUserPrincipal();
      Usuario usuario = usuarioRepository.findByUsername(principal.getName()).get();
      System.out.println(usuario.getFoto());
      model.addAttribute("userlog", usuario);
    } catch (Exception e) {
      System.out.println(e);
    }

    return "home/home";
  }

  @GetMapping("/home-logoff")
  public String LogOff() {
    return "home/home-logoff";
  }

  // @GetMapping("/perfil")
  // public String Perfil(Model model, HttpServletRequest request) {

  //   try {
  //     Principal principal = request.getUserPrincipal();
  //     Usuario usr = usuarioRepository.findByUsername(principal.getName()).get();
  //     model.addAttribute("userlog", usr);
  //   } catch (Exception e) {
  //       System.out.println(e);
  //   }
  //   return "perfil";
  // }

  @GetMapping("/perfil")
  public String Perfil(@RequestParam(value = "id", required = true) Integer cod, Model model) {
      Usuario usuario = db.queryForObject(
              "select * from usuario where id = ?",
              (rs, rowNum) -> {
                  Usuario usr = new Usuario();
                  usr.setId(rs.getInt("id"));
                  usr.setEmail(rs.getString("email"));
                  usr.setTelefone(rs.getString("telefone"));
                  return usr;
              },
              cod);
      model.addAttribute("user", usuario);
      return "perfil";
  }

  // @PostMapping("/gravauseralterado")
  // public String gravaUserAlterado(Usuario usuario) {
    
  //     db.update("update usuario set telefone=?, email=? where id = ?", 
  //                 usuario.getId(), 
  //                 usuario.getEmail(), 
  //                 usuario.getTelefone());
  //     return "redirect:/perfil";
  // }   
  
}
