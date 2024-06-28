import br.inatel.c06.exceptions.SemEstoqueException;
import br.inatel.c06.produtos.*;
import br.inatel.c06.user.Cliente;

import javax.swing.plaf.IconUIResource;
import java.awt.datatransfer.FlavorListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int opcao = 0, cont = 0;
        boolean start = true, sair = true;
        String nome, senha, cpf, telefone;
        Scanner cin = new Scanner(System.in);

        //arquivos
        Path arquivoADM = Paths.get("AdministracaoEstoque.txt"); //arquivo controle de estoque
        Path arquivoCliente = Paths.get("Clientes.txt"); //arquivo login clientes
        Path arquivoCozinha = Paths.get("Cozinha.txt"); //arquivo direcionado a cozinha

        Set<Cliente>  clienteSet= new HashSet<>(); //armazena os dados dos clientes
        Set<Mercadoria> estoque = new HashSet<>(); //armazena a quantidade em estoque das mercadorias produzidas
        Set<Mercadoria> cozinha = new HashSet<>(); //armazena a quantidade total de itens pedidos

        //leitura dos arquivos
        lerEstoque(estoque, cozinha);
        lerCliente(clienteSet);

        while (sair) {
            System.out.println("=============================================================================\n");
            if (start) {
                System.out.println("Bem Vindo!");
                start = false;
            }
            //menu inicial
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("9 - Sair");
            opcao = cin.nextInt();
            System.out.println("\n=============================================================================");
            Cliente cliente = new Cliente(null, null, null, null);
            switch (opcao) {
                //login
                case 1:
                    cont = 0;
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
                            // Verificacao se o cliente existe no banco de dados
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
                //cadastro
                case 2: {
                    //dados do cliente
                    System.out.println("\nDigite o nome do cliente: ");
                    nome = cin.next();
                    System.out.println("\nDigite o CPF do cliente: ");
                    cpf = cin.next();
                    //Verificação de existência do usuário
                    for (Cliente i : clienteSet) {
                        if (Objects.equals(i.getCpf(), cpf)) {
                            System.out.println("\nUsuário já existente.");
                            System.out.println("Retornando ao menu incial para login.");
                            opcao = 9;
                            break;
                        } else {
                            System.out.println("\nDigite o telefone do cliente: ");
                            telefone = cin.next();
                            System.out.println("\nCrie uma senha para o cliente: ");
                            senha = cin.next();
                            clienteSet.add(cliente = new  Cliente(nome, cpf, telefone, senha));
                            break;
                        }
                    }
                    break;
                }
                //finalização do atendimento
                case 9:
                    System.out.println("\nO atendimento está sendo finalizado...\n");
                    sair = false;
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    opcao = 9;
                    break;
            }

            while (opcao != 9) {
                System.out.println("\nDigite a opção desejada:" +
                        "\n1 - Selecionar produtos" +
                        "\n9 - Voltar ao menu");

                opcao = cin.nextInt();

                switch (opcao) {
                    //escolhendo a mercadoria - montando o carrinho de compras
                    case 1:
                        cont = 0;
                        while (cont == 0) {
                            System.out.println("\nDigite a opção de mercadoria desejada:");
                            System.out.println("1 - Pão Francês");
                            System.out.println("2 - Pão de Queijo");
                            System.out.println("3 - Biscoito");
                            System.out.println("4 - Broa");

                            opcao = cin.nextInt();
                            //adicionando mercadoria
                            switch (opcao) {
                                case 1: {

                                    String item = "Pão Francês";
                                    for(Mercadoria i: cozinha)
                                    {
                                        if (Objects.equals(i.getNome(), item))
                                        {
                                            i.setQuantidade(addMercadoria(estoque,item,cliente) + i.getQuantidade());
                                        }
                                    }
                                    cont++;
                                    break;
                                }
                                case 2: {
                                    String item = "Pão de Queijo";
                                    for(Mercadoria i: cozinha)
                                    {
                                        if (Objects.equals(i.getNome(), item))
                                        {
                                            i.setQuantidade(addMercadoria(estoque,item,cliente) + i.getQuantidade());
                                        }
                                    }
                                    cont++;
                                    break;
                                }
                                case 3: {
                                    String item = "Biscoito";
                                    for(Mercadoria i: cozinha)
                                    {
                                        if (Objects.equals(i.getNome(), item))
                                        {
                                            i.setQuantidade(addMercadoria(estoque,item,cliente) + i.getQuantidade());
                                        }
                                    }
                                    cont++;
                                    break;
                                }
                                case 4: {
                                    String item = "Broa";
                                    for(Mercadoria i: cozinha)
                                    {
                                        if (Objects.equals(i.getNome(), item))
                                        {
                                            i.setQuantidade(addMercadoria(estoque,item,cliente) + i.getQuantidade());
                                        }
                                    }
                                    cont++;
                                    break;
                                }
                                default:
                                    System.out.println("\nOpção inválida. Tente novamente.");
                            }
                        }
                        break;
                        case 9:
                            //saída de dados a cada login/cadastro
                            System.out.println("\n=============================================================================\n");
                            System.out.println("Dados do cliente ");
                            System.out.println("Nome: " + cliente.getNome());
                            System.out.println("CPF: " + cliente.getCpf());
                            System.out.println("Telefone: " + cliente.getTelefone());
                            System.out.println("Carrinho de compras: ");
                            System.out.println("O valor total do carrinho de compras de " + cliente.getNome() + " é de R$ " + cliente.getTotalCompra());
                            System.out.println("\n=============================================================================\n");
                            break;
                        default:
                            System.out.println("\nOpção inválida. Tente novamente.");
                }
            }
        }
        //saida do arquivo Pedidos
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(arquivoCozinha)))){
            for(Mercadoria i:cozinha) {
                bw.write(i.getNome() + ":" + i.getQuantidade());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //atualizando o arquivo de Estoque
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(arquivoADM)))){
            for(Mercadoria i:estoque) {
                bw.write(i.getNome() + ":" + i.getQuantidade());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //atualizando o arquivo de Clientes
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(arquivoCliente)))){
            for(Cliente i:clienteSet) {
                bw.write(i.getNome() + "|" + i.getCpf() + "|" + i.getTelefone() + "|" + i.getSenha());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Montagem do carrinho de compras
    private static int addMercadoria(Set<Mercadoria> mercadorias, String item, Cliente cliente) {
        int qnt = 0;
        double total;
        Scanner cin = new Scanner(System.in);
        for(Mercadoria k:mercadorias){
            if (Objects.equals(k.getNome(), item)) {
                //verifica se a quantidade de mercadoria disponível em estoque é suficiente para o pedido do cliente
                try {
                    System.out.println("Veja o que temos em estoque hoje");
                    System.out.println(k.getNome() + ": " + k.getQuantidade());
                    System.out.println("Digite a quantidade de " + item + " que deseja adicionar ao carrinho:");
                    qnt = cin.nextInt();
                    cliente.adicionarCompra(k, qnt);
                    cliente.calcularValorTotal(k, qnt);
                    System.out.println("O valor acrescido no carrinho é de R$ " + k.calculaPreco(qnt));
                }catch (SemEstoqueException e){
                    System.out.println(e); //tratando exceção
                }
                break;
            }
        }
        return qnt;
    }
    private static void lerCliente(Set<Cliente>  clienteSet){
        // Leitura do arquivo de estoque e salvamento no hashset de mercadorias
        try (BufferedReader br = new BufferedReader(new FileReader("Clientes.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linha, "|");
                String nome = st.nextToken();
                String cpf = st.nextToken();
                String tel = st.nextToken();
                String senha = st.nextToken();
                clienteSet.add(new  Cliente(nome, cpf, tel, senha));
            }
        } catch (IOException e) {
            e.printStackTrace(); //tratando exceção
        }
    }
    private static void lerEstoque(Set<Mercadoria> mercadorias, Set<Mercadoria> cozinha){
        // Leitura do arquivo de estoque e salvamento no hashset de mercadorias
        try (BufferedReader br = new BufferedReader(new FileReader("AdministracaoEstoque.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linha, ":");
                String produto = st.nextToken();
                int qnt = Integer.parseInt(st.nextToken());

                if (Objects.equals(produto, "Pão Francês"))
                {
                    cozinha.add(new PaoFrances(0));
                    mercadorias.add(new PaoFrances(qnt));
                }else if(Objects.equals(produto, "Pão de Queijo")){
                    cozinha.add(new Paodequeijo(0));
                    mercadorias.add(new Paodequeijo(qnt));
                }else if(Objects.equals(produto, "Biscoito")){
                    cozinha.add(new Biscoito(0));
                    mercadorias.add(new Biscoito(qnt));
                }else if(Objects.equals(produto, "Broa")){
                    cozinha.add(new Broa(0));
                    mercadorias.add(new Broa(qnt));
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); //tratando exceção
        }
    }
}