package com.example.petShop.petShop.dominio.produto.repository;

import com.example.petShop.petShop.dominio.produto.entity.Produto;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public class ProdutoRepository implements IProdutoRepository {

    private static Set<Produto> produtos;

    static {
        produtos = new LinkedHashSet<>();

        Produto produto1 = new Produto("produto 1", "Shapoo derruba juba", "URL da Imagem", 52.50);
        Produto produto2 = new Produto("produto 2", "Ração sem marca", "URL da Imagem", 45.00);

        produtos.add(produto1);
        produtos.add(produto2);
    }

    @Override
    public Optional<Produto> findById(UUID id) {
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Set<Produto> findAll() {
        return produtos;
    }

    @Override
    public Produto save(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    @Override
    public Produto update(UUID id, Produto produto) {
        var produtoEditado = produtos.stream().filter(p -> p.getId().equals(id)).findFirst().get();
        produtoEditado.setNome(produto.getNome());
        produtoEditado.setDescricao(produto.getDescricao());
        produtoEditado.setUrlImagem(produto.getUrlImagem());
        produtoEditado.setPreco(produto.getPreco());

        return produtoEditado;
    }

    @Override
    public void delete(UUID id) {
        produtos.removeIf(p -> p.getId().equals(id));
    }
}
