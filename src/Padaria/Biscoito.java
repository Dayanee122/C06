package Padaria;

public class Biscoito extends Mercadoria {
    public Biscoito(int quantidade) {
        super("Biscoito", 1.50, quantidade);
    }

    @Override
    public String descricao() {
        return getNome() + " - Preço: R$" + String.format("%.2f", getPreco()) + " - Quantidade: " + getQuantidade();
    }
}
