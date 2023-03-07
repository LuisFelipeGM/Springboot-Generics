package com.alunos.alunosfiap.controllers;

import com.alunos.alunosfiap.services.TurmaService;
import com.alunos.alunosfiap.models.TurmaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class TurmaController {

    final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }


    @GetMapping("")
    public String Get(){
        return "Ola";
    }

    @PostMapping()
    public ResponseEntity<Object> saveTurma(@RequestBody TurmaModel turmaModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.Save(turmaModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaModel> getTurmaById(@PathVariable Long id) {
        // Pesquisa o objeto TurmasModel no repositório usando o método findById()
        Optional<TurmaModel> optionalTurmas = Optional.ofNullable(turmaService.FindById(id));

        // Verifica se o objeto TurmasModel foi encontrado e retorna um ResponseEntity correspondente
        if (optionalTurmas.isPresent()) {
            return ResponseEntity.ok(optionalTurmas.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /Turmas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurmas(@PathVariable Long id) {
        turmaService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }
}
