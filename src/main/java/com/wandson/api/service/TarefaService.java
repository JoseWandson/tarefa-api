package com.wandson.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandson.api.model.Tarefa;
import com.wandson.api.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	public Tarefa criar(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	public List<Tarefa> listar() {
		return tarefaRepository.findAll();
	}

	public Optional<Tarefa> buscarPeloId(Long id) {
		return tarefaRepository.findById(id);
	}

}
