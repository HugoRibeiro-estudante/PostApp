package com.postapp.postapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroController {

  @GetMapping("/cadastro")
  public String Cadastro() {
    return "cadastro";
  }
    
}
