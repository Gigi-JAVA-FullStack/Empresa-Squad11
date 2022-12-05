package org.soulcodeacademy.empresa.services;


import org.soulcodeacademy.empresa.domain.DTO.DependenteDTO;
import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.services.errors.RecursoNãoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;
    @Autowired
    private EmpregadoService empregadoService;


    public List<Dependente> listar() {
        return this.dependenteRepository.findAll();
    }

    public Dependente getDependente(Integer idDependente) {
        Optional<Dependente> dependente = this.dependenteRepository.findById(idDependente);

        if(dependente.isEmpty()) {
            throw  new RecursoNãoEncontradoError("O dependente não foi encontrado!");
        }else {
            return dependente.get();
        }
    }

    public Dependente salvar(DependenteDTO dto) {
        Empregado empregado = this.empregadoService.getEmpregado(dto.getResponsavel());
        Dependente dependente = new Dependente(null, dto.getNome(), dto.getIdade());
        dependente.setResponsavel(empregado);
        Dependente dependenteSalvo = this.dependenteRepository.save(dependente);
        return dependenteSalvo;
    }

    public Dependente atualizar(Integer idDependente, DependenteDTO dto) {
      Dependente dependenteAtual = getDependente(idDependente);
      Empregado responsavel = this.empregadoService.getEmpregado(dto.getResponsavel());
      dependenteAtual.setResponsavel(responsavel);
      dependenteAtual.setNome(dto.getNome());
      dependenteAtual.setIdade(dto.getIdade());

      return this.dependenteRepository.save(dependenteAtual);
    }

    public void deletar(Integer idDependente) {
        Dependente dependente = this.getDependente(idDependente);
        this.dependenteRepository.delete(dependente);
    }
}
