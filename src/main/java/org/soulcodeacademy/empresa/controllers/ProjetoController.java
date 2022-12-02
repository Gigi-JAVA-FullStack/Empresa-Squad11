package org.soulcodeacademy.empresa.controllers;


import org.soulcodeacademy.empresa.domain.DTO.ProjetoDTO;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/projetos")
    public List<Projeto> listarProjetos(){

        return this.projetoService.listarProjetos();
    }

    @GetMapping("/projetos/{idProjeto}")
    public Projeto getProjeto(@PathVariable Integer idProjeto){
        return this.projetoService.getProjeto(idProjeto);
    }

    @PostMapping("/projetos")
    public Projeto salvarProjeto(@RequestBody ProjetoDTO projeto){
        Projeto projetoSalvo = this.projetoService.salvar(projeto);
        return projetoSalvo;
    }

    @PutMapping("/projetos/{idProjeto}")
    public Projeto atualizarProjeto(@PathVariable Integer idProjeto, @RequestBody ProjetoDTO projeto){
        Projeto projetoAtualizado = this.projetoService.atualizar(idProjeto, projeto) ;
        return projetoAtualizado;
    }

    @DeleteMapping("/projetos/{idProjeto}")
    public void deletar(@PathVariable Integer idProjeto){

        this.projetoService.deletar(idProjeto);
    }
}
