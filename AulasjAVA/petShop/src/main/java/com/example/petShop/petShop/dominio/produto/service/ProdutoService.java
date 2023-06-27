package com.example.petShop.petShop.dominio.produto.service;

import com.example.petShop.petShop.dominio.produto.entity.Produto;
import com.example.petShop.petShop.dominio.produto.repository.IProdutoRepository;
import com.example.petShop.petShop.dominio.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Qualifier("produtoRepository")
    @Autowired
    private IProdutoRepository repo;

    public Collection<Produto> findAll(){
        var produtos = repo.findAll();

        return produtos;
    }

    public Optional<Produto> findById(UUID id){
        var produto = repo.findById(id);

        return produto;
    }

    public Produto save(Produto produto) {
        var produtoSaved = repo.save(produto);
        return produto;
    }

    public Optional<Produto> update(UUID id, Produto produto){
        Optional<Produto> buscarProduto = this.findById(id);

        if(buscarProduto.isPresent()){
            Produto produtoUpdate = repo.update(id, produto);
            return Optional.of(produtoUpdate);
        }

        return Optional.empty();
    }

    public void delete(UUID id) {
        repo.delete(id);
    }
}
