package com.wandson.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wandson.api.model.Item;
import com.wandson.api.model.Tarefa;
import com.wandson.api.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private TarefaService tarefaService;

	public Item criar(Item item) {
		Tarefa tarefa = tarefaService.buscarPeloId(item.getTarefa().getId()).orElseThrow();
		item.setTarefa(tarefa);
		item.setConcluido(false);
		return itemRepository.save(item);
	}

	public void remover(Long codigo) {
		itemRepository.deleteById(codigo);
	}

	public void atualizarPropriedadeConcluido(Long codigo, Boolean concluido) {
		Item itemSalvo = buscarItemPeloCodigo(codigo);
		itemSalvo.setConcluido(concluido);
		itemRepository.save(itemSalvo);
	}

	private Item buscarItemPeloCodigo(Long codigo) {
		return itemRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
