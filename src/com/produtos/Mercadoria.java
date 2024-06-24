package com.produtos;

public abstract class Mercadoria {
    // Atributos
    protected String nome;
    protected double preco;
    protected int quantidade; // quantidade disponível

    // Construtor
    public Mercadoria(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularTotalPreco() {
        return preco * quantidade;
    }

    public abstract String descricao();
}
