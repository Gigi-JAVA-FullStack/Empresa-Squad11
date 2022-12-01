package org.soulcodeacademy.empresa.controllers;


import org.soulcodeacademy.empresa.domain.DTO.EnderecoDTO;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/enderecos")
    public List<Endereco> listarEnderecos(){
        return this.enderecoService.listarEnderecos();
    }

    @GetMapping("/enderecos/{idEndereco}")
    public Endereco getEndereco(@PathVariable Integer idEndereco){
        return this.enderecoService.getEndereco(idEndereco);
    }

    @PostMapping("/enderecos")
    public Endereco salvarEndereco(@RequestBody EnderecoDTO endereco){
        Endereco enderecoSalvo = this.enderecoService.salvar(endereco);
        return enderecoSalvo;
    }

    @PutMapping("/enderecos/{idEndereco}")
    public Endereco atualizarEndereco(@PathVariable Integer idEndereco, @RequestBody EnderecoDTO endereco){
        Endereco enderecoAtualizado = this.enderecoService.atualizar(idEndereco, endereco);
        return enderecoAtualizado;
    }

    @DeleteMapping("/enderecos/{idEndereco}")
    public void deletar(@PathVariable Integer idEndereco){
        this.enderecoService.deletar(idEndereco);
    }


}
