package br.inatel.c06.produtos;

public class Broa extends Mercadoria {
    public Broa(int quantidade) {
        super("Broa", quantidade);
    }
    public double calculaPreco (int quantia){
        return (quantia * 0.90);
    }

   /* @Override
    public String descricao() {
        return getNome() + " - Preço: R$" + String.format("%.2f", getPreco()) + " - Quantidade: " + getQuantidade();
    }*/
}
