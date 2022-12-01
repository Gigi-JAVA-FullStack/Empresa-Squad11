package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository serviceEmpregado;

    public List<Empregado> listarTodos(){
        return this.serviceEmpregado.findAll();
    }
    public Empregado getEmpregado(Integer idEmpregado){
        return this.serviceEmpregado.findById(idEmpregado).orElseThrow(()->)
                .
    }
}
