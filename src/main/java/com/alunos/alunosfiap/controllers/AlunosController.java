package com.alunos.alunosfiap.controllers;

import com.alunos.alunosfiap.alunosDtos.AlunoDto;
import com.alunos.alunosfiap.models.AlunosModel;
import com.alunos.alunosfiap.services.AlunosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/alunos")
public class AlunosController {

    final
    AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @GetMapping("")
    public String Get(){
        return "Ola";
    }

    @PostMapping()
    public ResponseEntity<Object> saveAluno(@RequestBody AlunosModel alunosModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunosService.Save(alunosModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunosModel> getAlunosById(@PathVariable Long id) {
        // Pesquisa o objeto AlunosModel no repositório usando o método findById()
        Optional<AlunosModel> optionalAlunos = Optional.ofNullable(alunosService.FindById(id));

        // Verifica se o objeto AlunosModel foi encontrado e retorna um ResponseEntity correspondente
        if (optionalAlunos.isPresent()) {
            return ResponseEntity.ok(optionalAlunos.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /alunos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunosService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }
}
