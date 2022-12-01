package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.DTO.EnderecoDTO;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Método para listar todos os endereços cadastrados
    public List<Endereco> listarEnderecos() {
        return this.enderecoRepository.findAll();
    }

    // Método para buscar um Endereço pelo id
    public Endereco getEndereco(Integer idEndereco) {
        Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);
        if (endereco.isEmpty()) {
            throw new RuntimeException("O endereço não foi encontrado");
        } else {
            return endereco.get(); // get() extrai o cargo do optional
        }
    }

    // Método para salvar um novo endereço
    public Endereco salvar(EnderecoDTO novoEndereco){
        Endereco endereco = new Endereco(null, novoEndereco.getCidade(), novoEndereco.getUf());
        return this.enderecoRepository.save(endereco);
    }

    // Método para atualizar o endereço
    public Endereco atualizar(Integer idEndereco, EnderecoDTO enderecoAtualizado){
        Endereco enderecoAtual = this.getEndereco(idEndereco);

        enderecoAtual.setCidade(enderecoAtualizado.getCidade());
        enderecoAtual.setUf(enderecoAtualizado.getUf());

        return this.enderecoRepository.save(enderecoAtual);
    }

    // Método para deletar o endereço
    public void deletar(Integer idEndereco){
        Endereco endereco = this.getEndereco(idEndereco);
        this.enderecoRepository.delete(endereco);
    }

}
