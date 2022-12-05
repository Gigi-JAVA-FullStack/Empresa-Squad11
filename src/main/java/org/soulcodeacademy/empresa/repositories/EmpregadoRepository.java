package org.soulcodeacademy.empresa.repositories;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {

}
