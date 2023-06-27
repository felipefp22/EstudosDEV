package com.example.petShop.petShop.dominio.produto.repository;

import com.example.petShop.petShop.dominio.produto.entity.Produto;

import java.util.Optional;
import java.util.UUID;
import java.util.Set;

public interface IProdutoRepository {

    Optional<Produto> findById(UUID id);

    Set<Produto> findAll();

    Produto save(Produto produto);

    Produto update(UUID id, Produto produto);

    void delete(UUID id);
}
