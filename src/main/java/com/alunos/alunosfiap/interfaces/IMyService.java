package com.alunos.alunosfiap.interfaces;

import jakarta.transaction.Transactional;

public interface IMyService<T> {

    @Transactional
    T GetAll();

    @Transactional
    T Save(T object);

    @Transactional
    void DeleteById (Long id);

    @Transactional
    T FindById(Long id);

}
