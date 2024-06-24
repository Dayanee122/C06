package com.produtos;

public class Broa extends Mercadoria {
    public Broa(int quantidade) {
        super("Broa", 2.00, quantidade);
    }

    @Override
    public String descricao() {
        return getNome() + " - Preço: R$" + String.format("%.2f", getPreco()) + " - Quantidade: " + getQuantidade();
    }
}
