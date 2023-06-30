package com.example.petShop.petShop.dominio.produto.controller;

import com.example.petShop.petShop.dominio.produto.entity.Produto;
import com.example.petShop.petShop.dominio.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Collection<Produto>> findAll(){
        var produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable UUID id){
        var produtos = produtoService.findById(id);

        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        var produtoSaved = produtoService.save(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand((produtoSaved.getId())).toUri();

        return ResponseEntity.created(uri).body(produtoSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable UUID id, @RequestBody Produto produto){
        var produtoUpdated = produtoService.update(id, produto);

        return ResponseEntity.ok(produtoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        produtoService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
