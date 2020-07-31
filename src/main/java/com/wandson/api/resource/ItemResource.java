package com.wandson.api.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wandson.api.dto.ItemDTO;
import com.wandson.api.model.Item;
import com.wandson.api.service.ItemService;

@RestController
@RequestMapping("/itens")
public class ItemResource {

	@Autowired
	private ItemService itemService;

	@PostMapping
	public ResponseEntity<Item> criar(@Valid @RequestBody ItemDTO itemDTO) {
		Item item = itemDTO.toItem();
		Item itemSalvo = itemService.criar(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemSalvo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		itemService.remover(id);
	}

	@PutMapping("/{id}/concluido")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeConcluido(@PathVariable Long id, @RequestBody Boolean concluido) {
		itemService.atualizarPropriedadeConcluido(id, concluido);
	}

}
