package estacionamento;

import java.util.Scanner;
import model.Pessoa;
import util.Validadores;
import model.Carro;
import controller.CCarro;
import controller.CPessoa;
import util.Validadores;

public class Estacionamento {// Inicio CLASS
    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();
    public static Scanner ler = new Scanner(System.in);
    public static String tpger = null;

    // LER
    public static int lerNum() {// Inicio LerNUM
        Scanner ler = new Scanner(System.in);
        try {
            return ler.nextInt();
        } catch (Exception e) {
            System.out.println("Tente novamente!.");
            lerNum();
        }
        return 0;
    }// Fim LerNUM
     // LER

    // MENUS
    public static void Menu() { // Inicio MENU
        System.out.println("+--------------------+");
        System.out.println("|   ESTACIONAMENTO   |");
        System.out.println("+--------------------+");
        System.out.println("|                    |");
        System.out.println("| 1 - Ger. Cliente   |");
        System.out.println("| 2 - Ger. Veiculo   |");
        System.out.println("| 3 - Listar dados   |");
        System.out.println("|                    |");
        System.out.println("+--------------------+");
        System.out.print("  Escolha uma opção: ");
    }// Fim MENU

    public static void Submenu(int op) {// Inicio SUBMENU
        tpger = null;
        switch (op) {
            case 1:
                tpger = "Cliente";
                break;
            case 2:
                tpger = "Veiculo";
                break;
        }

        System.out.println("+-----------------------+");
        System.out.println("|        " + tpger + "        |");
        System.out.println("+--+-----------------+--+");
        System.out.println("|  | 1 - Cadastrar   |  |");
        System.out.println("|  | 2 - Remover     |  |");
        System.out.println("|  | 3 - Editar      |  |");
        System.out.println("|  | 4 - Listar      |  |");
        System.out.println("|  | 0 - Voltar      |  |");
        System.out.println("+--+-----------------+--+");
        System.out.print("  Escolha uma opção: ");
    }// Fim SUBMENU
     // MENUS

    // CLIENTES
    public static void cadastrocliente() {// Inicio CADASTRO-CLIENTE
        String nomePessoa;
        String cpf;
        String endereco;
        String telefone;
        int idCliente;
        int idadePessoa;

        System.out.println("\n+----------------------------+");
        System.out.println("|                            |");
        System.out.println("|    Cadastro de clientes    |");
        System.out.println("|                            |");
        System.out.println("+----------------------------+");
        System.out.print(" Informe o CPF: ");
        boolean cpfis;
        int opCPF = 0;
        do {
            cpf = ler.nextLine();
            cpfis = Validadores.isCPF(cpf);
            if (!cpfis) {
                System.out.println("CPF Inválido \nDeseja tentar novamente ? 1- Sim | 2- Não");
                opCPF = lerNum();

                if (opCPF == 1) {
                    System.out.println("Informe o CPF: ");
                }
                if (opCPF == 2) {
                    System.out.println("Cadastro cancelado pelo usuário!");
                    return;
                }
            }
        } while (!Validadores.isCPF(cpf));
        if (cadPessoa.getPessoaCPF(cpf) != null) {
            System.out.println("Cliente já cadastro!.");
        } else {
            System.out.print("Informe o nome: ");
            nomePessoa = ler.nextLine();
            System.out.print("Informe a idade: ");
            idadePessoa = ler.nextInt();
            System.out.print("Informe o telefone: ");
            telefone = ler.nextLine();
            System.out.print("Informe o endereço: ");
            endereco = ler.nextLine();
            idCliente = cadPessoa.geraID();
            Pessoa pes = new Pessoa(idadePessoa, idadePessoa, null, null, cpf, nomePessoa, endereco, telefone);
            cadPessoa.addPessoa(pes);
            System.out.println("Cliente cadastrado com sucesso!.");
        }
    }// Fim CADASTRO-CLIENTE

    public static void deletarcliente() {// Inicio DELETA-CLIENTE
        System.out.println("\n+----------------------------+");
        System.out.println("|                            |");
        System.out.println("|     Remoção de clientes    |");
        System.out.println("|                            |");
        System.out.println("+----------------------------+");
        System.out.print(" Informe o CPF: ");
        String cpf = ler.next();
        if (Validadores.isCPF(cpf)) {
            Pessoa pes = cadPessoa.getPessoaCPF(cpf);
            if (pes != null) {
                System.out.println("Cliente deletado com sucesso!.");
            } else {
                System.out.println("Cliente não consta na base de dados!.");
            }
        } else
            System.out.println("CPF inválido!.");
    }// Fim DELETA-CLIENTE

    public static void editarcliente() {// Inicio EDITA-CLIENTE
        System.out.println("\n+----------------------------+");
        System.out.println("|                            |");
        System.out.println("|      Edição de clientes    |");
        System.out.println("|                            |");
        System.out.println("+----------------------------+");
        System.out.print(" Informe o CPF: ");
        String cpf = ler.nextLine();
        if (Validadores.isCPF(cpf)) {
            Pessoa pes = cadPessoa.getPessoaCPF(cpf);
            if (pes != null) {
                System.out.println(" 1 - Nome: \t" + pes.getNomePessoa());
                System.out.println(" 2 - Idade: \t" + pes.getIdadePessoa());
                System.out.println(" 3 - Telefone: \t" + pes.getTelefone());
                System.out.println(" 4 - Endereço: \t" + pes.getEndereco());
                System.out.println(" 5 - Todos acima \t");
                System.out.print("Qual campo gostaria de alterar ?: ");
                int opEd = lerNum();
                if (opEd == 1 || opEd == 5) {
                    System.out.print("Informe o nome: ");
                    pes.setNomePessoa(ler.nextLine());
                }
                if (opEd == 2 || opEd == 5) {
                    System.out.print("Informe a idade: ");
                    pes.setIdadePessoa(ler.nextInt());
                }
                if (opEd == 3 || opEd == 5) {
                    System.out.print("Informe o telefone: ");
                    pes.setTelefone(ler.nextLine());
                }
                if (opEd == 4 || opEd == 5) {
                    System.out.print("Informe o endereço: ");
                    pes.setEndereco(ler.nextLine());
                }
            } else {
                System.out.println("Cliente não consta na base de dados!.");
            }
        }
    }// Fim EDITA-CLIENTE

    public static void listarcliente() {// Inicio LISTA-CLIENTE
        for (Pessoa pes : cadPessoa.getPessoas()) {
            System.out.println("+-------------------------------------+");
            System.out.println("CPF: " + pes.getCpf());
            System.out.println("Nome: " + pes.getNomePessoa());
            System.out.println("Idade: " + pes.getIdadePessoa());
            System.out.println("Telefone: " + pes.getTelefone());
            System.out.println("Endereço: " + pes.getEndereco());
        }
    }// Fim LISTA-CLIENTE
     // CLIENTES

    // VEICULOS
    public static void cadastroveiculo() {// Inicio CADASTRO-VEICULO

    }// Fim CADASTRO-VEICULO

    public static void deletarveiculo() {// Inicio DELETA-VEICULO
    }// Fim DELETA-VEICULO

    public static void editarveiculo() {// Inicio EDITA-VEICULO
    }// Fim EDITA-VEICULO

    public static void listarveiculo() {// Inicio LISTA-VEICULO
    }// Fim LISTA-VEICULO
     // VEICULOS

    public static void main(String[] args) {// Inicio MAIN
        int opM;
        do {
            Menu();
            opM = lerNum();
            switch (opM) {
                case 1:
                case 2:
                    int opSM;
                    do {
                        Submenu(opM);
                        opSM = lerNum();
                        switch (opSM) {
                            case 1:
                                if (tpger.equals("Cliente")) {
                                    cadastrocliente();
                                }
                                if (tpger.equals("Carro")) {
                                    cadastroveiculo();
                                }
                                break;
                            case 2:
                                if (tpger.equals("Cliente")) {
                                    deletarcliente();
                                }
                                if (tpger.equals("Carro")) {
                                    deletarveiculo();
                                }
                                break;
                            case 3:
                                if (tpger.equals("Cliente")) {
                                    editarcliente();
                                }
                                if (tpger.equals("Carro")) {
                                    editarveiculo();
                                }
                                break;
                            case 4:
                                if (tpger.equals("Cliente")) {
                                    listarcliente();
                                }
                                if (tpger.equals("Carro")) {
                                    listarveiculo();
                                }
                                break;
                            case 0:
                                opM = 99;
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!.");
                                break;
                        }
                    } while (opSM != 0);
                    break;
                case 4:

                    break;
            }
        } while (opM != 0);
    }// Fim MAIN

}// Fim CLASS
