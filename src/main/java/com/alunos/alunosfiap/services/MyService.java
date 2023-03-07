package com.alunos.alunosfiap.services;

import com.alunos.alunosfiap.interfaces.IMyService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

public class MyService<T> implements IMyService<T> {
    final JpaRepository<T, Long> repository;

    MyService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public T GetAll() {
        return (T) repository.findAll();
    }

    @Transactional
    public T Save(T object) {
        return repository.save(object);
    }

    @Transactional
    public void DeleteById(Long id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new NoSuchElementException("Registro não encontrado com o ID fornecido: " + id);
        }
    }

    @Transactional
    public T FindById(Long id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("Registro não encontrado com o ID fornecido: " + id);
        }
    }
}
