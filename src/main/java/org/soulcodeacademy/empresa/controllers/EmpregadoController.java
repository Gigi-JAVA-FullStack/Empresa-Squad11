package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpregadoController {
    @Autowired
    private EmpregadoService empregadoService;


}
