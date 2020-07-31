package com.wandson.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wandson.api.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
