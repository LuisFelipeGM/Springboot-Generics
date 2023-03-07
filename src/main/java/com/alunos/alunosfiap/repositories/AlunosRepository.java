package com.alunos.alunosfiap.repositories;

import com.alunos.alunosfiap.models.AlunosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunosRepository extends JpaRepository<AlunosModel, Long> {
}
