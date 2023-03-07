package com.alunos.alunosfiap.alunosDtos;

import com.alunos.alunosfiap.annotations.StringAlunos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class AlunoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O RM é obrigatório")
    @Size(max = 10, message = "O RM deve ter no maximo 10 caracteres")
    private String rm;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }
}
