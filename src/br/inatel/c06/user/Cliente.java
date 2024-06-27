package br.inatel.c06.user;

import br.inatel.c06.exceptions.SemEstoqueException;
import br.inatel.c06.produtos.Mercadoria;

import java.util.HashMap;
import java.util.Map;

public class Cliente {
    // Atributos
    private String cpf, nome, telefone,  senha;
    private double totalCompra = 0;
    Map<String,Integer> comprasMap;

    // Construtor
    public Cliente(String nome, String cpf, String telefone, Map<String, Integer> comprasMap ,String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.comprasMap = comprasMap;
        this.senha = senha;
    }
    // Getters
    public Map<String, Integer> getComprasMap() {
        return comprasMap;
    }
    public String getCpf() {
        return cpf;
    }

    public double getTotalCompra() {  return totalCompra; }

    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }
    public String getTelefone() {
        return telefone;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

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
    double total = 0;
    public void calcularValorTotal(Mercadoria item, int qnt) {
        this.totalCompra += item.calculaPreco(qnt);
    }
    public void getCarrinho(){
//        for (Map.Entry<Mercadoria, Integer> entry : comprasMap.entrySet()) {
//            Mercadoria mercadoria = entry.getKey();
//            int quantidade = entry.getValue();
//        }
    }
}
