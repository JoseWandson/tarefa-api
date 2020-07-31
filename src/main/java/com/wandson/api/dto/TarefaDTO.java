package com.wandson.api.dto;

import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;

import com.wandson.api.model.Tarefa;

import lombok.Getter;
import lombok.Setter;

public class TarefaDTO {

	@Getter
	@Setter
	@NotBlank
	private String descricao;

	public Tarefa toTarefa() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, Tarefa.class);
	}

}
