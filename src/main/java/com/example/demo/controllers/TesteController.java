package com.example.demo.controllers;

import com.example.demo.services.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @Autowired
    private ServiceTest service;

    @GetMapping("/teste")
    public String teste(){

      service.executeProc();

      return "ok";

    }

}
