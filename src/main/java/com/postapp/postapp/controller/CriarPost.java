package com.postapp.postapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CriarPost {
    @GetMapping("/criarpost")
    public String Criacao() {
      return "post/criarpost";
    }    
}
