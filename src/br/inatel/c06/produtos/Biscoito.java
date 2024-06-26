package br.inatel.c06.produtos;

public class Biscoito extends Mercadoria {
    public Biscoito(int quantidade) {
        super("Biscoito", quantidade);
    }
    @Override
    public double calculaPreco (int quantia){
        return (quantia * 2.00);
    }

}
