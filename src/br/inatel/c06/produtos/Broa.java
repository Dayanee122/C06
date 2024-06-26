package br.inatel.c06.produtos;

public class Broa extends Mercadoria {
    public Broa(int quantidade) {
        super("Broa", quantidade);
    }
    @Override
    public double calculaPreco (int quantia){
        return (quantia * 0.90);
    }
}
