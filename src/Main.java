import br.inatel.c06.exceptions.SemEstoqueException;
import br.inatel.c06.produtos.*;
import br.inatel.c06.user.Cliente;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int opcao = 0;
        Cliente cliente = new Cliente(null,null,null,null,null);
        String nome, senha, cpf, telefone;

        Set<Cliente> clienteSet = new HashSet<>();
        Set<Mercadoria> mercadorias = new HashSet<>();
        Scanner cin = new Scanner(System.in);
        Map<String, Integer> mapaCarrinhodeCompras = new HashMap<>();

        while (opcao != 9){
            System.out.println("=============================================================================\n");
            System.out.println("Bem Vindo!");
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Login:");
            System.out.println("2 - Cadastro");
            System.out.println("9 - Sair");
            System.out.println("\n=============================================================================");
            opcao = cin.nextInt();

            switch (opcao){
                case 1:
                    while (true){
                        System.out.println("\nDigite o nome do cliente: ");
                        nome = cin.nextLine();
                        System.out.println("\nDigite a senha do cliente: ");
                        senha = cin.nextLine();

                        for(Cliente i : clienteSet){
                            if (Objects.equals(i.getNome(), nome)){
                                while (true){
                                    if (Objects.equals(i.getSenha(), senha))
                                    {
                                        opcao = 0;
                                        break;
                                    }else{
                                        System.out.println("\nSenha incorreta...\nDigite a senha novamente:");
                                        senha = cin.nextLine();
                                    }
                                }
                                cliente = i;
                                break;
                            }
                        }

                        if (opcao == 0){
                            System.out.println("\nbem vindo " + nome);
                            break;
                        }

                        System.out.println("\nCliente nao encontrado. Tente novamente...");
                    }
                    break;

                case 2:
                    //dados do cliente

                    System.out.println("\nDigite o nome do cliente: ");
                    nome = cin.nextLine();
                    System.out.println("\nDigite o CPF do cliente: ");
                    cpf = cin.nextLine();
                    System.out.println("\nDigite o telefone do cliente: ");
                    telefone = cin.nextLine();
                    System.out.println("\nCrie uma senha para o cliente: ");
                    senha = cin.nextLine();

                    // ADICIONAR VERIFICACAO DE EXISTENCIA DE USUARIO

                    clienteSet.add(new Cliente(nome,cpf,telefone,mapaCarrinhodeCompras, senha));
                    break;

                case 9:
                    System.out.println("\nO atendimento está sendo finalizado...");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }
            
            while (opcao != 9) {

                //definição das quantidades disponíveis de cada mercadoria
                mercadorias.add(new PaoFrances(250));
                mercadorias.add(new Paodequeijo(18));
                mercadorias.add(new Biscoito(20));
                mercadorias.add(new Broa(10));

//                PaoFrances paoFrances = new PaoFrances(250);
//                Paodequeijo paoDeQueijo = new Paodequeijo(18);
//                Broa broa = new Broa(10);
//                Biscoito biscoito = new Biscoito(20);

                while (opcao != 2){
                    System.out.println("Veja o que temos em estoque Hoje");
                    for (Mercadoria i : mercadorias){
                        System.out.println(i.getNome() + ": " + i.getQuantidade());
                    }

                    System.out.println("\nDigite a opção desejada:" +
                            "\n1 - Selecionar produtos" +
                            "\n9 - Voltar");

                    opcao = cin.nextInt();

                    switch (opcao){
                        case 1:
                        {
                            System.out.println("\nDigite a opção de mercadoria desejada:");
                            System.out.println("1 - Pão Francês");
                            System.out.println("2 - Pão de Queijo");
                            System.out.println("3 - Biscoito");
                            System.out.println("4 - Broa");
                            opcao = cin.nextInt();

                            switch (opcao){
                                case 1:
                                {
                                    String item = "Pão Francês";
                                    addMercadoria(mercadorias,item,cliente);
                                    break;
                                }
                                case 2:
                                {
                                    String item = "Pão de Queijo";
                                    addMercadoria(mercadorias,item,cliente);
                                    break;
                                }
                                case 3:{
                                    String item = "Biscoito";
                                    addMercadoria(mercadorias,item,cliente);
                                    break;
                                }
                                case 4:{
                                    String item = "Broa";
                                    addMercadoria(mercadorias,item,cliente);
                                    break;

                                }
                                default:
                                    System.out.println("\nOpção inválida. Tente novamente.");
                            }
                            //verificação - exceção
                            //testar
                            break;
                        }
                        case 9:
                        {
                            System.out.println("\nO atendimento está sendo finalizado...");
                            break;
                        }
                        default:
                        {
                            System.out.println("\nOpção inválida. Tente novamente.");
                        }
                    }
                }

            }

        }

//        Scanner entrada = new Scanner(System.in);
//        Cliente cliente = new Cliente(nome, cpf, telefone, mapaCarrinhodeCompras);


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

//        System.out.println("O carrinho de compras foi finalizado!");
//        mapaCarrinhodeCompras.forEach((chave, valor) -> {
//            System.out.println("Mercadoria: " + chave);
//            System.out.println("Quantidade: " + valor);
//        });
    }

    private static void addMercadoria(Set<Mercadoria> mercadorias, String item, Cliente cliente) {
        int qnt;
        Scanner cin = new Scanner(System.in);

        for(Mercadoria i:mercadorias){
            if (Objects.equals(i.getNome(), item)){
                System.out.println("Digite a quantidade de " + item + " que deseja adicionar ao carrinho:");
                qnt = cin.nextInt();
                cliente.adicionarCompra(i, qnt);
                System.out.println("O valor acrescido no carrinho é de R$ " + i.calculaPreco(qnt));

                break;
            }
        }
    }


}

