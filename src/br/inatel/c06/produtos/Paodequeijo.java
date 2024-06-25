package br.inatel.c06.produtos;

public class Paodequeijo extends Mercadoria {
    public Paodequeijo(int quantidade) {
        super("Pão de queijo", quantidade);
    }
    public double calculaPreco (int quantia){
        return (quantia * 1.50);
    }

    /*@Override
    public String descricao() {
        return getNome() + " - Preço: R$" + String.format("%.2f", getPreco()) + " - Quantidade: " + getQuantidade();
    }*/

}
