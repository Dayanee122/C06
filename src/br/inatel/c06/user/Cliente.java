package br.inatel.c06.user;

import br.inatel.c06.exceptions.SemEstoqueException;
import br.inatel.c06.produtos.Mercadoria;

import java.util.HashMap;
import java.util.Map;

public class Cliente {
    // Atributos
    private String cpf, nome, telefone,  senha;
    Map<String,Integer> comprasMap;

    // Construtor
    public Cliente(String nome, String cpf, String telefone, Map<String, Integer> comprasMap ,String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.comprasMap = comprasMap;
        this.senha = senha;
    }

    /*public double calcularValorTotal() {
        double total = 0;
        for (Map.Entry<Mercadoria, Integer> entry : comprasMap.entrySet()) {
            Mercadoria mercadoria = entry.getKey();
            int quantidade = entry.getValue();
            total += mercadoria.getPreco() * quantidade;
        }
        return total;
    }*/
    public void adicionarCompra(Mercadoria item, int qnt){
        //add ao carrinho de compras e verificando se tem em estoque com exception
        if (item.getQuantidade() >= qnt) {
            this.comprasMap.put(item.getNome(), qnt);
            item.setQuantidade(item.getQuantidade() - qnt);
            System.out.println("Adicionando " + qnt + " unidasdes no carrinho;");
        }
        else
            throw new SemEstoqueException("A quatidade solicitada esta acima da quantidade em estoque!");
    }

    // Getters
    public Map<String, Integer> getComprasMap() {
        return comprasMap;
    }
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }
    public void getCarrinho(){
//        for (Map.Entry<Mercadoria, Integer> entry : comprasMap.entrySet()) {
//            Mercadoria mercadoria = entry.getKey();
//            int quantidade = entry.getValue();
//        }
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
