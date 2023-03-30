package estacionamento;

import java.util.Scanner;
import model.Pessoa;
import util.Validadores;
import model.Carro;
import controller.CCarro;
import controller.CPessoa;

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
        System.out.println("\n+--------------------+");
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

        System.out.println("\n+-----------------------+");
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
        String endereco = null;
        String telefone = null;
        int idadePessoa;
        int idPessoa;

        System.out.println("\n+----------------------------+");
        System.out.println("|                            |");
        System.out.println("|    Cadastro de clientes    |");
        System.out.println("|                            |");
        System.out.println("+----------------------------+");
        System.out.print("Informe o CPF: ");
        boolean cpfis;
        boolean telefoneis;
        boolean idadeis;
        int op = 0;
        do {
            cpf = ler.nextLine();
            cpfis = Validadores.isCPF(cpf);
            if (!cpfis) {
                System.out.println("CPF Inválido \nDeseja tentar novamente ? 1- Sim | 2- Não");
                op = lerNum();

                if (op == 1) {
                    System.out.print("Informe o CPF: ");
                }
                if (op == 2) {
                    System.out.println("Cadastro cancelado pelo usuário!");
                    return;
                }
            }
        } while (!Validadores.isCPF(cpf));
        if (cadPessoa.getPessoaCPF(cpf) != null) {
            System.out.println("Cliente já cadastrado!.");
        } else {
            System.out.print("Informe o nome: ");
            nomePessoa = ler.nextLine();
            if (nomePessoa.isEmpty()) {
                System.out.println("O nome não pode ser vazio");
                System.out.print("Informe o nome: ");
                nomePessoa = ler.nextLine();
            }
            System.out.print("Informe o telefone: ");
            do {
                telefone = ler.nextLine();
                telefoneis = Validadores.validarTelefone(telefone);
                if (!telefoneis) {
                    System.out.println("Telefone inválido \nDeseja tentar novamente ? 1 - Sim | 2 - Não");
                    op = lerNum();

                    if (op == 1) {
                        System.out.print("Informe o telefone: ");
                    }
                    if (op == 2) {
                        System.out.println("Cadastro cancelado pelo usuário!");
                        return;
                    }
                }
            } while (!Validadores.validarTelefone(telefone));
            System.out.print("Informe a idade: ");
            idadePessoa = lerNum();
            idadeis = Validadores.validarIdade(idadePessoa);
            do {
                if (!idadeis) {
                    System.out.println("Idade inválida \nDeseja tentar novamente ? 1 - Sim | 2 - Não");
                    op = lerNum();

                    if (op == 1) {
                        System.out.println("Informe a idade(Faixa de idade 18 a 100 anos): ");
                        idadePessoa = lerNum();
                    }
                    if (op == 2) {
                        System.out.println("Cadastro cancelado pelo usuário!");
                        return;
                    }
                }
            } while (!Validadores.validarIdade(idadePessoa));
            idPessoa = cadPessoa.geraID();
            System.out.print("Informe o endereço: ");
            endereco = ler.nextLine();
            if (endereco.isEmpty()) {
                System.out.println("O endedreço não pode ser vazio");
                System.out.print("Informe o endereço: ");
                endereco = ler.nextLine();
            }
            Pessoa pes = new Pessoa(idPessoa, idadePessoa, null, null, cpf, nomePessoa, endereco, telefone);
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
        System.out.print("Informe o CPF: ");
        String cpf = ler.next();
        int op = 0;
        if (Validadores.isCPF(cpf)) {
            Pessoa pes = cadPessoa.getPessoaCPF(cpf);
            if (pes != null) {
                System.out.println("CPF: " + pes.getCpf());
                System.out.println("Nome: " + pes.getNomePessoa());
                System.out.println("Idade: " + pes.getIdadePessoa());
                System.out.println("Telefone: " + pes.getTelefone());
                System.out.println("Deseja excluir o usuário ? 1 - Sim | 2 - Não");
                op = lerNum();
                if (op == 1) {
                    cadPessoa.removePessoa(pes);
                    System.out.println("Cliente deletado com sucesso!.");
                }
                if (op == 2) {
                    System.out.println("Remoção cancelada pelo usuário!");
                    return;
                }
            } else {
                System.out.println("Cliente não consta na base de dados!.");
            }
        } else {
            System.out.println("CPF inválido!.");
        }
    }// Fim DELETA-CLIENTE

    public static void editarcliente() {// Inicio EDITA-CLIENTE
        System.out.println("\n+----------------------------+");
        System.out.println("|                            |");
        System.out.println("|      Edição de clientes    |");
        System.out.println("|                            |");
        System.out.println("+----------------------------+");
        System.out.print("Informe o CPF: ");
        String cpf = ler.nextLine();
        int op = 0;
        if (Validadores.isCPF(cpf)) {
            Pessoa pes = cadPessoa.getPessoaCPF(cpf);
            if (pes != null) {
                System.out.println(" 1 - Nome: \t" + pes.getNomePessoa());
                System.out.println(" 2 - Idade: \t" + pes.getIdadePessoa());
                System.out.println(" 3 - Telefone: \t" + pes.getTelefone());
                System.out.println(" 4 - Endereço: \t" + pes.getEndereco());
                System.out.println(" 5 - Todos acima \t");
                System.out.print("Qual campo gostaria de alterar: ");
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
                System.out.println("Deseja cadastra-lo ? 1 - Sim | 2 - Não");
                op = lerNum();
                if (op == 1) {
                    cadastrocliente();
                }
                if (op == 2) {
                    return;
                }
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
        int idCarro;
        String cpf;
        String placa = null;
        String cor = null;
        String modelo = null;
        Pessoa idPessoa = null;
        String renavam;
        boolean renavamis;
        boolean cpfis;
        int opRN = 0;
        System.out.println("\n+----------------------------+");
        System.out.println("|                            |");
        System.out.println("|    Cadastro de veiculos    |");
        System.out.println("|                            |");
        System.out.println("+----------------------------+");
        System.out.print("Informe o CPF: ");
        do {
            cpf = ler.nextLine();
            if (Validadores.isCPF(cpf)) {
                idPessoa = cadPessoa.getPessoaCPF(cpf);
                if (idPessoa == null) {
                    System.out.println("Cliente não cadastrado!.");
                    System.out.println("Deseja cadastra-lo ? 1 - Sim | 2 - Não");
                    opRN = lerNum();
                    if (opRN == 1) {
                        cadastrocliente();
                    }
                    if (opRN == 2) {
                        return;
                    }
                }
            } else {
                cpf = ler.nextLine();
                cpfis = Validadores.isCPF(cpf);
                if (!cpfis) {
                    System.out.println("CPF Inválido \nDeseja tentar novamente ? 1- Sim | 2- Não");
                    opRN = lerNum();

                    if (opRN == 1) {
                        System.out.println("Informe o CPF: ");
                    }
                    if (opRN == 2) {
                        System.out.println("Cadastro cancelado pelo usuário!");
                        return;
                    }
                }
            }

        } while (!Validadores.isCPF(cpf));
        System.out.print("Informe o Renavam: ");
        do {
            renavam = ler.nextLine();
            renavamis = Validadores.validarRenavam(renavam);
            if (!renavamis) {
                System.out.println("Renavam Inválido \nDeseja tentar novamente ? 1- Sim | 2- Não");
                opRN = lerNum();

                if (opRN == 1) {
                    System.out.print("Informe o renavam: ");
                }
                if (opRN == 2) {
                    System.out.println("Cadastro cancelado pelo usuário!");
                    return;
                }
            }
        } while (!Validadores.validarRenavam(renavam));
        if (cadCarro.getCarro(renavam) != null) {
            System.out.println("Veiculo já cadastro!.");
        } else {
            System.out.print("Informe a placa: ");
            placa = ler.nextLine();
            System.out.print("Informe a cor: ");
            cor = ler.nextLine();
            System.out.print("Informe o modelo: ");
            modelo = ler.nextLine();
        }
        idCarro = cadCarro.geraID();
        Carro car = new Carro(idCarro, placa, cor, modelo, idPessoa, renavam);
        cadCarro.addCarro(car);
        System.out.println("Carro cadastrado com sucesso!.");

    }// Fim CADASTRO-VEICULO

    public static void deletarVeiculo() {// Inicio DELETA-VEICULO
        System.out.println("\n+----------------------------+");
        System.out.println("|                            |");
        System.out.println("|     Remover de veiculos    |");
        System.out.println("|                            |");
        System.out.println("+----------------------------+");
        System.out.print("Informe o Renavam: ");
        String renav1 = ler.nextLine();
        if (Validadores.validarRenavam(renav1)) {
            Carro car = cadCarro.getCarro(renav1);
            if (car != null) {
                cadCarro.removeCliente(car);
                System.out.println("Carro deletado com sucesso!");
            } else {
                System.out.println("Renavam não consta na base de dados!");
            }
        } else {
            System.out.println("Renavam inválido!");
        }
    }// Fim DELETA-VEICULO

    public static void editarveiculo() {// Inicio EDITA-VEICULO
        System.out.println("\n+----------------------------+");
        System.out.println("|                            |");
        System.out.println("|      Editar de veiculos    |");
        System.out.println("|                            |");
        System.out.println("+----------------------------+");
        System.out.print("Informe o Renavam: ");
        String ren1v = ler.nextLine();
        Carro car = cadCarro.getCarro(ren1v);
        if (car != null) {
            System.out.println("1 - Cor : " + car.getCor());
            System.out.println("2 - Modelo : " + car.getModelo());
            System.out.println("3 - Placa: " + car.getPlaca());
            System.out.println("4 - Todos as campos acima");
            System.out.print("Informe o campo a qual deseja alterar: ");
            int opEditar = lerNum();

            if (opEditar == 1 || opEditar == 4) {
                System.out.print("Informe a nova Cor: ");
                car.setCor(ler.nextLine());
            }
            if (opEditar == 2 || opEditar == 4) {
                System.out.print("Informe o novo Modelo:  ");
                car.setModelo(ler.nextLine());
            }
            if (opEditar == 3 || opEditar == 4) {
                System.out.print("Informe a nova placa: ");
                car.setPlaca(ler.nextLine());
            }
            if (opEditar < 1 || opEditar > 4) {
                System.out.println("Opção inválida");
            }
        } else {
            System.out.println("Renavam não cadastrado!");
        }
    }// Fim EDITA-VEICULO

    public static void listarveiculo() {// Inicio LISTA-VEICULO
        for (Carro car : cadCarro.getCarros()) {
            System.out.println("+-------------------------------------+");
            System.out.println("Renavam: " + car.getRenavam());
            System.out.println("Modelo: " + car.getModelo());
            System.out.println("Placa : " + car.getPlaca());
            System.out.println("Cor: " + car.getCor());
        }
    }// Fim LISTA-VEICULO

    public static void listagem() {// Inicio LISTAGEM
        int op;
        System.out.println("+--------------------------+");
        System.out.println("|         LISTAGEM         |");
        System.out.println("+--------------------------+");
        System.out.println("|                          |");
        System.out.println("| 1 - Global               |");
        System.out.println("| 2 - Cliente              |");
        System.out.println("| 3 - Veiculo              |");
        System.out.println("| 4 - Veiculos por cliente |");
        System.out.println("| 0 - Menu Principal       |");
        System.out.println("|                          |");
        System.out.println("+--------------------------+");
        System.out.print("Escolha uma opção: ");
        op = lerNum();

        if (op == 1) {
            System.out.println("+----------------------------+");
            System.out.println("|      LISTAGEM GLOBAL       |");
            System.out.println("+----------------------------+");
            for (Pessoa pes : cadPessoa.getPessoas()) {
                System.out.println("+-------------------------------------+");
                System.out.println("CPF: " + pes.getCpf());
                System.out.println("Nome: " + pes.getNomePessoa());
                System.out.println("Idade: " + pes.getIdadePessoa());
                System.out.println("Telefone: " + pes.getTelefone());
                System.out.println("Endereço: " + pes.getEndereco());
            }
            for (Carro car : cadCarro.getCarros()) {
                System.out.println("+-------------------------------------+");
                System.out.println("Renavam: " + car.getRenavam());
                System.out.println("Modelo: " + car.getModelo());
                System.out.println("Placa : " + car.getPlaca());
                System.out.println("Cor: " + car.getCor());
            }
        }
        if (op == 2) {
            System.out.println("+----------------------------+");
            System.out.println("|      LISTAGEM CLIENTES     |");
            System.out.println("+----------------------------+");
            for (Pessoa pes : cadPessoa.getPessoas()) {
                System.out.println("+-------------------------------------+");
                System.out.println("CPF: " + pes.getCpf());
                System.out.println("Nome: " + pes.getNomePessoa());
                System.out.println("Idade: " + pes.getIdadePessoa());
                System.out.println("Telefone: " + pes.getTelefone());
                System.out.println("Endereço: " + pes.getEndereco());
            }
        }
        if (op == 3) {
            System.out.println("+----------------------------+");
            System.out.println("|      LISTAGEM VEICULOS     |");
            System.out.println("+----------------------------+");
            for (Carro car : cadCarro.getCarros()) {
                System.out.println("+-------------------------------------+");
                System.out.println("Renavam: " + car.getRenavam());
                System.out.println("Modelo: " + car.getModelo());
                System.out.println("Placa : " + car.getPlaca());
                System.out.println("Cor: " + car.getCor());
            }
        }
        if (op == 4) {
            for (Pessoa pes : cadPessoa.getPessoas()) {
                for (Carro car : cadCarro.getCarros()) {
                    if (car.getIdPessoa().equals(pes.getIdPessoa())) {
                        System.out.println("+-------------------------------------+");
                        System.out.println("CPF: " + pes.getCpf());
                        System.out.println("Nome: " + pes.getNomePessoa());
                        System.out.println("Idade: " + pes.getIdadePessoa());
                        System.out.println("Renavam: " + car.getRenavam());
                        System.out.println("Modelo: " + car.getModelo());
                        System.out.println("Placa : " + car.getPlaca());
                        System.out.println("Cor: " + car.getCor());
                    }
                }
            }
        }
        if (op == 0) {
            return;
        }
    }// Fim LISTAGEM

    public static void main(String[] args) {// Inicio MAIN
        cadPessoa.mockPessoas();
        cadCarro.mockCarro();
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
                                if (tpger.equals("Veiculo")) {
                                    cadastroveiculo();
                                }
                                break;
                            case 2:
                                if (tpger.equals("Cliente")) {
                                    deletarcliente();
                                }
                                if (tpger.equals("Veiculo")) {
                                    deletarVeiculo();
                                }
                                break;
                            case 3:
                                if (tpger.equals("Cliente")) {
                                    editarcliente();
                                }
                                if (tpger.equals("Veiculo")) {
                                    editarveiculo();
                                }
                                break;
                            case 4:
                                if (tpger.equals("Cliente")) {
                                    listarcliente();

                                }
                                if (tpger.equals("Veiculo")) {
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
                case 3:
                    listagem();
                    break;
            }
        } while (opM != 0);
    }// Fim MAIN

}// Fim CLASS
