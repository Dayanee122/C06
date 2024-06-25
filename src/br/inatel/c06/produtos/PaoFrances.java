package br.inatel.c06.produtos;

public class PaoFrances extends Mercadoria{
    public PaoFrances(int quantidade) {
        super("Pão Francês", quantidade);
    }
    @Override
    public double calculaPreco (int quantia){
        return (quantia * 0.60);
    }
    /*@Override
    public String descricao() {
        return getNome() + " - Preço: R$" + String.format("%.2f", getPreco()) + " - Quantidade: " + getQuantidade();
    }*/
}
