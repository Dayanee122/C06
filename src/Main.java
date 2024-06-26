import br.inatel.c06.exceptions.SemEstoqueException;
import br.inatel.c06.produtos.*;
import br.inatel.c06.user.Cliente;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int opcao = 0, cont = 0;
        boolean start = true, sair = true;
        String nome, senha, cpf, telefone;

        Set<Cliente> clienteSet = new HashSet<>();
        Set<Mercadoria> mercadorias = new HashSet<>();
        Scanner cin = new Scanner(System.in);
        Map<String, Integer> mapaCarrinhodeCompras = new HashMap<>();

        Cliente cliente = new Cliente(null, null, null, mapaCarrinhodeCompras, null);

        clienteSet.add(new Cliente("teste", "cpf", "telefone", mapaCarrinhodeCompras, "123"));

        while (sair) {
            System.out.println("=============================================================================\n");
            if (start) {
                System.out.println("Bem Vindo!");
                start = false;
            }
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("9 - Sair");
            opcao = cin.nextInt();
            System.out.println("\n=============================================================================");

            switch (opcao) {
                case 1:
                    while (true) {
                        if (cont != 0) {
                            System.out.println("Digite 1 para iniciar uma nova tentativa de login ou 9 para voltar ao menu inicial");
                            opcao = cin.nextInt();

                            while (opcao != 1 && opcao != 9) {
                                System.out.println("Valor inserido invalido! Tente novamente...");
                                opcao = cin.nextInt();
                            }

                            if (opcao == 9) {
                                cont = 0;
                                break;
                            }

                        }
                        cont++;
                        System.out.println("\nDigite o nome do cliente: ");
                        nome = cin.next();

                        //busca no hash set Cliente - clientes com login
                        for (Cliente i : clienteSet) {
                            // Verificacao se o cliente existe
                            if (Objects.equals(i.getNome(), nome)) {
                                System.out.println("\nDigite a senha do cliente: ");
                                senha = cin.next();
                                cont = 0;
                                // Verificacao da senha do cliente
                                while (true) {
                                    if (Objects.equals(i.getSenha(), senha)) {
                                        opcao = 0;
                                        break;
                                    } else {
                                        System.out.println("\nSenha incorreta...\nDigite a senha novamente:");
                                        senha = cin.next();
                                    }
                                }
                                cliente = i;
                                break;
                            }
                        }
                        if (opcao == 0) {
                            System.out.println("\nSeja bem vindo " + nome);
                            break;
                        }
                        System.out.println("\nCliente nao encontrado. Tente novamente...");
                    }
                    break;

                case 2:
                    //dados do cliente
                    System.out.println("\nDigite o nome do cliente: ");
                    nome = cin.next();
                    System.out.println("\nDigite o CPF do cliente: ");
                    cpf = cin.next();
                    System.out.println("\nDigite o telefone do cliente: ");
                    telefone = cin.next();
                    System.out.println("\nCrie uma senha para o cliente: ");
                    senha = cin.next();

                    // ADICIONAR VERIFICACAO DE EXISTENCIA DE USUARIO

                    clienteSet.add(new Cliente(nome, cpf, telefone, mapaCarrinhodeCompras, senha));
                    break;

                case 9:
                    System.out.println("\nO atendimento está sendo finalizado...");
                    sair = false;
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    opcao = 9;
                    break;
            }

            //definição das quantidades disponíveis de cada mercadoria
            mercadorias.add(new PaoFrances(250));
            mercadorias.add(new Paodequeijo(18));
            mercadorias.add(new Biscoito(20));
            mercadorias.add(new Broa(10));

            while (opcao != 9) {

                System.out.println("\nDigite a opção desejada:" +
                        "\n1 - Selecionar produtos" +
                        "\n9 - Voltar ao menu");

                opcao = cin.nextInt();

                switch (opcao) {
                    case 1:
                        cont = 0;
                        while (cont == 0) {
                            System.out.println("\nDigite a opção de mercadoria desejada:");
                            System.out.println("1 - Pão Francês");
                            System.out.println("2 - Pão de Queijo");
                            System.out.println("3 - Biscoito");
                            System.out.println("4 - Broa");

                            opcao = cin.nextInt();

                            switch (opcao) {
                                case 1: {

                                    String item = "Pão Francês";
                                    addMercadoria(mercadorias, item, cliente);
                                    cont++;
                                    break;
                                }
                                case 2: {
                                    String item = "Pão de Queijo";
                                    addMercadoria(mercadorias, item, cliente);
                                    cont++;
                                    break;
                                }
                                case 3: {
                                    String item = "Biscoito";
                                    addMercadoria(mercadorias, item, cliente);
                                    cont++;
                                    break;
                                }
                                case 4: {
                                    String item = "Broa";
                                    addMercadoria(mercadorias, item, cliente);
                                    cont++;
                                    break;

                                }
                                default:
                                    System.out.println("\nOpção inválida. Tente novamente.");
                            }

                        }
                        break;

                        case 9:
                            break;

                        default:
                            System.out.println("\nOpção inválida. Tente novamente.");
                }//switch
            }//while escolha da mercadoria
        }//whilhe menu inicial
        //saída de dados - TESTAR
        System.out.println("=============================================================================\n");
        for (Cliente clientes : clienteSet){
            System.out.println("Dados do cliente: ");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Carrinho de compras: ");
            mapaCarrinhodeCompras.forEach((chave, valor) -> {
            System.out.println("Mercadoria: " + chave);
            System.out.println("Quantidade: " + valor);
            System.out.println("=============================================================================\n");
        });

        }
    }//main

//        System.out.println("Cliente: " + cliente.getNome());
//        System.out.println("CPF: " + cliente.getCpf());
//        System.out.println("Telefone: " + cliente.getTelefone());


        /*for (Map.Entry<Mercador, Integer> entry : cliente.getCompras().entrySet()) {
            Mercadoria mercadoria = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println(mercadoria.descricao() + " - Quantidade: " + quantidade);
        }*/

//        System.out.println("O carrinho de compras foi finalizado!");
//        mapaCarrinhodeCompras.forEach((chave, valor) -> {
//            System.out.println("Mercadoria: " + chave);
//            System.out.println("Quantidade: " + valor);
//        });
    private static void addMercadoria(Set<Mercadoria> mercadorias, String item, Cliente cliente) {
        int qnt;
        Scanner cin = new Scanner(System.in);
        for(Mercadoria i:mercadorias){
            if (Objects.equals(i.getNome(), item)) {
                try {
                    System.out.println("Veja o que temos em estoque hoje");
                    System.out.println(i.getNome() + ": " + i.getQuantidade());
                    System.out.println("Digite a quantidade de " + item + " que deseja adicionar ao carrinho:");
                    qnt = cin.nextInt();
                    cliente.adicionarCompra(i, qnt);
                    System.out.println("O valor acrescido no carrinho é de R$ " + i.calculaPreco(qnt));
                    cliente.calcularValorTotal(i, qnt);
                }catch (SemEstoqueException e){
                    System.out.println(e);
                }
                break;
            }

        }
    }
}
//A fazer:
//escrita no arquivo (externamente) e leitura do arquivo de gerenciamento de estoque - "alterar definição das quantidades disponíveis de cada mercadoria"
//escrita e leitura do arquivo dos logins dos clientes
//escrita do arquivo do carrinho de compras dos clientes
//saída de dados: saída dos carrinhos de compras gerados durante a rodagem do código - hashMap
//calcula valor total do carrinho
//fazer interface