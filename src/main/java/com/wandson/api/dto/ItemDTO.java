package com.wandson.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.wandson.api.model.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

	@NotBlank
	private String descricao;

	@NotNull
	private Long tarefaId;

	public Item toItem() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.typeMap(ItemDTO.class, Item.class).addMappings(mapper -> mapper.skip(Item::setId)).map(this);
	}

}
