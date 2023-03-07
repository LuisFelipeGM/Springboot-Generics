package com.alunos.alunosfiap.services;

import com.alunos.alunosfiap.models.AlunosModel;
import com.alunos.alunosfiap.repositories.AlunosRepository;
import org.springframework.stereotype.Service;


@Service
public class AlunosService extends MyService<AlunosModel> {

    public AlunosService(AlunosRepository repository) {super(repository);}
}