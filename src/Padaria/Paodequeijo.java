package Padaria;

public class Paodequeijo extends Mercadoria {
    public Paodequeijo(int quantidade) {
        super("Pão de queijo", 1.25, quantidade);
    }

    @Override
    public String descricao() {
        return getNome() + " - Preço: R$" + String.format("%.2f", getPreco()) + " - Quantidade: " + getQuantidade();
    }
}
