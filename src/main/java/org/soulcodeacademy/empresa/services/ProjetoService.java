package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.DTO.ProjetoDTO;
import org.soulcodeacademy.empresa.domain.Empregado;

import org.soulcodeacademy.empresa.domain.Projeto;

import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.soulcodeacademy.empresa.services.errors.RecursoNãoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {


    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private EmpregadoRepository empregadoRepository;





    public List<Projeto> listarProjetos() {
        return this.projetoRepository.findAll();
    }

    public Projeto getProjeto(Integer idProjeto){
        Optional<Projeto> projeto = this.projetoRepository.findById(idProjeto);
        if (projeto.isEmpty()) {
            throw new RecursoNãoEncontradoError("O projeto não foi encontrado");
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
        List<Empregado> empregadosNoProjeto =this.empregadoRepository.findByProjetos(projeto);
        for (Empregado empr : empregadosNoProjeto ){
            empr.getProjetos().remove(projeto);
            this.empregadoRepository.save(empr);
        }
        this.projetoRepository.delete(projeto);
    }


}
