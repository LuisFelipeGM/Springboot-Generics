package com.alunos.alunosfiap.repositories;

import com.alunos.alunosfiap.models.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, Long> {
}
