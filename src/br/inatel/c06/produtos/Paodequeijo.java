package br.inatel.c06.produtos;

public class Paodequeijo extends Mercadoria {
    public Paodequeijo(int quantidade) {
        super("Pão de Queijo", quantidade);
    }
    @Override
    public double calculaPreco (int quantia){
        return (quantia * 1.25);
    }

}
