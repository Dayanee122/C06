package br.inatel.c06.produtos;

public class Biscoito extends Mercadoria {
    public Biscoito(int quantidade) {
        super("Biscoito", quantidade);
    }
    public double calculaPreco (int quantia){
        return (quantia * 2.00);
    }

    /*@Override
    public String descricao() {
        return getNome() + " - Preço: R$" + String.format("%.2f", getPreco()) + " - Quantidade: " + getQuantidade();
    }*/
}
