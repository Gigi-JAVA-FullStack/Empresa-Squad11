package org.soulcodeacademy.empresa.services;


import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;


}
