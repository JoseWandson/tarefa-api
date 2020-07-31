package com.wandson.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wandson.api.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
