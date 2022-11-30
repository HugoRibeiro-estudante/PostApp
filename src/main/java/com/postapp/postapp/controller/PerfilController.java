package com.postapp.postapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {
  @GetMapping("/perfil")
  public String Perfil() {
    return "perfil";
  }
}
