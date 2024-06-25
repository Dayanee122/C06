import br.inatel.c06.exceptions.SemEstoqueException;
import br.inatel.c06.produtos.*;
import br.inatel.c06.user.Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;

        Map<String, Integer> mapaCarrinhodeCompras = new HashMap<>();
        //definição das quantidades disponíveis de cada mercadoria
        PaoFrances paoFrances = new PaoFrances(250);
        Paodequeijo paoDeQueijo = new Paodequeijo(18);
        Broa broa = new Broa(10);
        Biscoito biscoito = new Biscoito(20);

        //dados do cliente
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nome = entrada.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        String cpf = entrada.nextLine();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = entrada.nextLine();

        Cliente cliente = new Cliente(nome, cpf, telefone, mapaCarrinhodeCompras);

        while (opcao != 2){
            System.out.println("Digite 1 para adicionar produtos ao carrinho ou 2 para finalizar o atendimento");
            int escolha1 = entrada.nextInt();
            opcao = escolha1;
            switch (opcao){
                case 1:
                {
                    System.out.println("Digite a opção de mercadoria desejada:");
                    System.out.println("1 - Pão Francês");
                    System.out.println("2 - Pão de Queijo");
                    System.out.println("3 - Biscoito");
                    System.out.println("4 - Broa");
                    int escolha2 = entrada.nextInt();
                    opcao = escolha2;
                    switch (opcao){
                        case 1:
                        {
                            System.out.println("Digite a quantidade de Pães Francês que deseja adicionar ao carrinho:");
                            int quantia = entrada.nextInt();
                            cliente.adicionarCompra(paoFrances, quantia);
                            System.out.println("O valor acrescido no carrinho é de R$ " + paoFrances.calculaPreco(quantia));
                            break;
                        }
                        case 2:
                        {
                            System.out.println("Digite a quantidade de Pães de Queijo que deseja adicionar ao carrinho:");
                            int quantia = entrada.nextInt();
                            cliente.adicionarCompra(paoDeQueijo, quantia);
                            System.out.println("O valor acrescido no carrinho é de R$ " + paoDeQueijo.calculaPreco(quantia));
                            break;
                        }
                        case 3:{
                            System.out.println("Digite a quantidade de Biscoitos que deseja adicionar ao carrinho:");
                            int quantia = entrada.nextInt();
                            cliente.adicionarCompra(biscoito, quantia);
                            System.out.println("O valor acrescido no carrinho é de R$ " + biscoito.calculaPreco(quantia));
                            break;
                        }
                        case 4:{
                            System.out.println("Digite a quantidade de Broas que deseja adicionar ao carrinho:");
                            int quantia = entrada.nextInt();
                            cliente.adicionarCompra(paoDeQueijo, quantia);
                            System.out.println("O valor acrescido no carrinho é de R$ " + broa.calculaPreco(quantia));
                            break;

                        }
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                    //verificação - exceção
                    //testar
                    break;
                }
                case 2:
                {
                    System.out.println("O atendimento está sendo finalizado...");
                    break;
                }
                default:
                {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }

        /*
        try{
            cliente.adicionarCompra(paoDeQueijoSimples, 4);
            cliente.adicionarCompra(broaDeMilho, 2);
            cliente.adicionarCompra(biscoito, 3);
        } catch (SemEstoqueException e){
            System.out.println(e.getMessage());
        }
        */

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Telefone: " + cliente.getTelefone());


        /*for (Map.Entry<Mercador, Integer> entry : cliente.getCompras().entrySet()) {
            Mercadoria mercadoria = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println(mercadoria.descricao() + " - Quantidade: " + quantidade);
        }*/

        System.out.println("O carrinho de compras foi finalizado!");
        mapaCarrinhodeCompras.forEach((chave, valor) -> {
            System.out.println("Mercadoria: " + chave);
            System.out.println("Quantidade: " +valor);
        });
    }
}