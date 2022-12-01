package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.DTO.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpregadoController {
    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping("/empregados")
    public List<Empregado> listarTodos(){
        return this.empregadoService.listarTodos();

    }
    @GetMapping("/empregado/{id}")
public Empregado EmpregadoPorId(@PathVariable Integer id){
        return this.empregadoService.getEmpregado(id);
    }
    @PostMapping("/newEmpregado")
    public Empregado NewEmpregado(@RequestBody EmpregadoDTO dto){
        return this.empregadoService.salvar(dto);

    }
    @PutMapping("/Empregado/{id}")
    public  Empregado AtualizarEmpregado(@PathVariable Integer id,@RequestBody EmpregadoDTO dto){
        return  this.empregadoService.atualizar(id, dto);
    }
    @DeleteMapping("/Empregado/{id}")
    public void deletarFuncionario(@PathVariable Integer id){
        this.empregadoService.deletar(id);
    }

}
