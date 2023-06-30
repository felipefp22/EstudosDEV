package com.example.petShop.petShop.dominio.produto.service;

import com.example.petShop.petShop.dominio.produto.entity.Produto;
import com.example.petShop.petShop.dominio.produto.repository.IProdutoRepository;
import com.example.petShop.petShop.dominio.produto.service.exception.ControllerNotFoundException;
import com.example.petShop.petShop.dominio.produto.service.exception.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private IProdutoRepository repo;

    public Collection<Produto> findAll(){
        var produtos = repo.findAll();

        return produtos;
    }

    public Produto findById(UUID id){
        var produto = repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não Encontrado"));

        return produto;
    }

    public Produto save(Produto produto) {
        var produtoSaved = repo.save(produto);
        return produto;
    }

    public Produto update(UUID id, Produto produto){
        try {
            Produto buscaProduto = repo.getOne(id);

            buscaProduto.setNome(produto.getNome());
            buscaProduto.setDescricao(produto.getDescricao());
            buscaProduto.setUrlImagem(produto.getUrlImagem());
            buscaProduto.setPreco(produto.getPreco());

            buscaProduto = repo.save(buscaProduto);

            return buscaProduto;
        }catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Produto não Encontrado");
        }
    }

    public void delete(UUID id) {
        try{
            repo.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Violação de Integridade da Base - ID: " + id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Violação de Integridade da Base");
        }
    }
}
