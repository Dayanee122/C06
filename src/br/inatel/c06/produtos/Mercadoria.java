package br.inatel.c06.produtos;

public abstract class Mercadoria {
    // Atributos
    protected String nome;
    protected double preco;
    protected int quantidade; // quantidade disponível

    // Construtor
    public Mercadoria(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    //setters
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public abstract double calculaPreco (int quantia);

}
