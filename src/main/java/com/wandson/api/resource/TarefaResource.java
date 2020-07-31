package com.wandson.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wandson.api.dto.TarefaDTO;
import com.wandson.api.model.Tarefa;
import com.wandson.api.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaResource {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping
	public List<Tarefa> listar() {
		return tarefaService.listar();
	}

	@PostMapping
	public ResponseEntity<Tarefa> criar(@Valid @RequestBody TarefaDTO tarefaDTO) {
		Tarefa tarefa = tarefaDTO.toTarefa();
		Tarefa tarefaSalva = tarefaService.criar(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
	}

}
