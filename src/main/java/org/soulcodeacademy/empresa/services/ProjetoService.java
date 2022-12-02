package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.DTO.EnderecoDTO;
import org.soulcodeacademy.empresa.domain.DTO.ProjetoDTO;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarProjetos() {
        return this.projetoRepository.findAll();
    }

    public Projeto getProjeto(Integer idProjeto){
        Optional<Projeto> projeto = this.projetoRepository.findById(idProjeto);
        if (projeto.isEmpty()) {
            throw new RuntimeException("O projeto não foi encontrado");
        } else {
            return projeto.get(); // get() extrai o projeto
        }
    }

    public Projeto salvar(ProjetoDTO novoProjeto){
        Projeto projeto = new Projeto(null, novoProjeto.getNome(), novoProjeto.getOrcamento(), novoProjeto.getDescricao());
        return this.projetoRepository.save(projeto);
    }

    public Projeto atualizar(Integer idProjeto, ProjetoDTO projetoAtualizado){
        Projeto projetoAtual = this.getProjeto(idProjeto);

        projetoAtual.setNome(projetoAtualizado.getNome());
        projetoAtual.setOrcamento(projetoAtualizado.getOrcamento());
        projetoAtual.setDescricao(projetoAtualizado.getDescricao());

        return this.projetoRepository.save(projetoAtual);
    }

    public void deletar(Integer idProjeto){
        Projeto projeto = this.getProjeto(idProjeto);
        this.projetoRepository.delete(projeto);
    }


}
