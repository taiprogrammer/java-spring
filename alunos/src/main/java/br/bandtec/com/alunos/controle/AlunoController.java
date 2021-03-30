package br.bandtec.com.alunos.controle;

import br.bandtec.com.alunos.entity.Aluno;
import br.bandtec.com.alunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public ResponseEntity postAluno(@RequestBody @Valid Aluno novoAluno) {
        repository.save(novoAluno);
        return ResponseEntity.status(201).build();
    }
}
