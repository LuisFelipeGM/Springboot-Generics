package com.alunos.alunosfiap.services;


import com.alunos.alunosfiap.models.TurmaModel;
import com.alunos.alunosfiap.repositories.TurmaRepository;
import org.springframework.stereotype.Service;

@Service
public class TurmaService extends MyService<TurmaModel> {

    public TurmaService(TurmaRepository repository) {super(repository);}
}
