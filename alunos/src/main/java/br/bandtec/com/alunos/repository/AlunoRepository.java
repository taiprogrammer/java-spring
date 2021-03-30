package br.bandtec.com.alunos.repository;

import br.bandtec.com.alunos.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
