import com.produtos.*;
import com.user.Cliente;

import java.util.Map;

public class Padaria {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Chris", "123.456.789.00", "99988-7766");

        Paodequeijo paoDeQueijoSimples = new Paodequeijo(18);
        Broa broaDeMilho = new Broa(10);
        Biscoito biscoito = new Biscoito(20);

        cliente.adicionarCompra(paoDeQueijoSimples, 4);
        cliente.adicionarCompra(broaDeMilho, 2);
        cliente.adicionarCompra(biscoito, 3);

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Compras:");


        for (Map.Entry<Mercadoria, Integer> entry : cliente.getCompras().entrySet()) {
            Mercadoria mercadoria = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println(mercadoria.descricao() + " - Quantidade: " +quantidade);
        }
    }
}
