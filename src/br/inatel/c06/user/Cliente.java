package br.inatel.c06.user;

import br.inatel.c06.exceptions.SemEstoqueException;
import br.inatel.c06.produtos.Mercadoria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cliente {
    // Atributos
    private String cpf, nome, telefone,  senha;
    private double totalCompra = 0;
    Map<String,Integer> comprasMap;

    // Construtor
    public Cliente(String nome, String cpf, String telefone, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.comprasMap = new HashMap<>();
        this.senha = senha;
    }
    // Getters
    public Map<String, Integer> getComprasMap() {
        return comprasMap;
    }
    public void getCarrinho(){
        int qnt;
        this.comprasMap.forEach((chave, valor) -> {
            System.out.println("Mercadoria: " + chave);
            System.out.println("Quantidade: " + valor);
        });
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
    //adiconando mercadoria ao carrinho de compras
    public void adicionarCompra(Mercadoria item, int qnt){
        int qntItem;
        //verificando se há quantidade disponível em estoque
        if (item.getQuantidade() >= qnt) {
            if (comprasMap.get(item.getNome())!=null) {
                qntItem = (comprasMap.get(item.getNome()) + qnt);
            }else{
                qntItem = qnt;
            }
            this.comprasMap.put(item.getNome(), qntItem);
            item.setQuantidade(item.getQuantidade() - qnt);
            System.out.println("Adicionando " + qnt + " unidades no carrinho");
        }
        //Exceção quando a quantidade solicitada é acima da disponível
        else
            throw new SemEstoqueException("A quatidade solicitada esta acima da quantidade em estoque!");
    }
    public void calcularValorTotal(Mercadoria item, int qnt) {
        this.setTotalCompra(getTotalCompra() + item.calculaPreco(qnt));
    }
}
