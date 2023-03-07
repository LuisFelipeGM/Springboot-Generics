package com.alunos.alunosfiap.models;

import com.alunos.alunosfiap.annotations.StringAlunos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_ALUNOS")
public class AlunosModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Campo não deve estar em branco")
    @Size(max = 20)
    private String Nome;

    @Column(nullable = false, unique = true, length = 10)
    @StringAlunos()
    private String RM;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<EnderecoModel> enderecos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getRM() {
        return RM;
    }

    public void setRM(String RM) {
        this.RM = RM;
    }

    public List<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }
}
