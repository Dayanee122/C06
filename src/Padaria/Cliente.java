package Padaria;

import java.util.HashMap;
import java.util.Map;

public class Cliente {
    // Atributos
    private String cpf;
    private String nome;
    private String telefone;
    private final Map<Mercadoria, Integer> compras;

    // Construtor
    public Cliente(String nome, String cpf, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.compras = new HashMap<>();
    }


    public double calcularValorTotal() {
        double total = 0;
        for (Map.Entry<Mercadoria, Integer> entry : compras.entrySet()) {
            Mercadoria mercadoria = entry.getKey();
            int quantidade = entry.getValue();
            total += mercadoria.getPreco() * quantidade;
        }
        return total;
    }

    // Getters
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public Map<Mercadoria, Integer> getCompras() {
        return compras;
    }
}
