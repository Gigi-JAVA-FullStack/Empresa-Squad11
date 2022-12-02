package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.DTO.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpregadoService {

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
        return this.serviceEmpregado.findById(idEmpregado).orElseThrow(()-> new RuntimeException("Empregado não encontrado!"));

    }
    public Empregado salvar(EmpregadoDTO dto) {
        // Verificar se existe um cliente com este ID
        Empregado newEmpregado = new Empregado(dto.getNome(), dto.getEmail(), dto.getSalario());
        return this.serviceEmpregado.save(newEmpregado);
    }
    public Empregado atualizar(Integer idEmpregado, EmpregadoDTO dto){
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);
        Endereco enderecoNovo = this.enderecoService.getEndereco(dto.getEndereco());

        Projeto projetoNovo = this.projetoService.getProjeto(dto.getIdProjeto());
        empregadoAtual.setNome(dto.getNome());
        empregadoAtual.setEndereco(enderecoNovo);
        empregadoAtual.setProjetos(List.of(projetoNovo));

        empregadoAtual.setEmail(dto.getEmail());
        empregadoAtual.setSalario(dto.getSalario());
        Empregado atualizado = this.serviceEmpregado.save(empregadoAtual);
        return atualizado;
    }
    public void deletar(Integer idEmpregado) {
        Empregado cargo = this.getEmpregado(idEmpregado);

        this.serviceEmpregado.delete(cargo);
    }
}
