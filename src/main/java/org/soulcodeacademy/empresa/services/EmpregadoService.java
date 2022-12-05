package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.DTO.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private EmpregadoRepository serviceEmpregado;
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ProjetoService projetoService;


    public List<Empregado> listarTodos(){

        return this.serviceEmpregado.findAll();
    }
    public Empregado getEmpregado(Integer idEmpregado){
        //return this.serviceEmpregado.findById(idEmpregado).orElseThrow(()-> new RuntimeException("Empregado não encontrado!"));
        Optional<Empregado> empregado = this.serviceEmpregado.findById(idEmpregado);

        if (empregado.isEmpty()) {
            // lançar exceção
            throw new RuntimeException("Empregado não encontrado!");
        } else {
            return empregado.get();
        }
    }

    public Empregado salvar(EmpregadoDTO dto) {
        // Verificar se existe um cliente com este ID
        Empregado newEmpregado = new Empregado(dto.getNome(), dto.getEmail(), dto.getSalario());
        return this.serviceEmpregado.save(newEmpregado);
    }
    public Empregado atualizar(Integer idEmpregado, EmpregadoDTO dto){
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);

      Endereco enderecoNovo = this.enderecoService.getEndereco(dto.getEndereco());


        empregadoAtual.setNome(dto.getNome());
        empregadoAtual.setEndereco(enderecoNovo);


        empregadoAtual.setEmail(dto.getEmail());
        empregadoAtual.setSalario(dto.getSalario());
        Empregado atualizado = this.serviceEmpregado.save(empregadoAtual);
        return atualizado;
    }
    public Empregado inserirNoProjeto(Integer idEmpregado,EmpregadoDTO dto){
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);
        Projeto projetoNovo = this.projetoService.getProjeto(dto.getProjetos());
        empregadoAtual.setProjetos(projetoNovo);
        return this.serviceEmpregado.save(empregadoAtual);
    }
    public Empregado retirarDoProjeto(Integer idEmpregado, Integer idProjeto){
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);
        Projeto projeto = this.projetoService.getProjeto(idProjeto);

        empregadoAtual.getProjetos().remove(projeto);
        return this.serviceEmpregado.save(empregadoAtual);

    }
    public void deletar(Integer idEmpregado) {

        Empregado empregado = this.getEmpregado(idEmpregado);
        empregado.getProjetos().clear();
        List<Dependente> dependentes = this.dependenteRepository.findByResponsavel(empregado);


        this.dependenteRepository.deleteAll(dependentes);
        this.serviceEmpregado.delete(empregado);
    }
}
