package com.postapp.postapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping("/home")
  public String Home() {
    return "home/home";
  }

  @GetMapping("/home-logoff")
  public String LogOff() {
    return "home/home-logoff";
  }
}
