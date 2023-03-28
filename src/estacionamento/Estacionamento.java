package estacionamento;

import java.util.Scanner;

public class Estacionamento {// Inicio CLASS
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
        System.out.println("\n+-----------------------+");
        System.out.println("|     GERENCIAMENTO     |");
        System.out.println("+-----------------------+");
        System.out.println("|        " + tpger + "        |");
        System.out.println("+--+-----------------+--+");
        System.out.println("|  | 1 - Cadastrar   |  |");
        System.out.println("|  | 2 - Editar      |  |");
        System.out.println("|  | 3 - Listar      |  |");
        System.out.println("|  | 4 - Remover     |  |");
        System.out.println("|  | 0 - Voltar      |  |");
        System.out.println("+--+-----------------+--+");
        System.out.print("  Escolha uma opção: ");
    }// Fim SUBMENU
     // MENUS

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

                                }
                                if (tpger.equals("Carro")) {

                                }
                                break;
                            case 2:
                                if (tpger.equals("Cliente")) {

                                }
                                if (tpger.equals("Carro")) {

                                }
                                break;
                            case 3:
                                if (tpger.equals("Cliente")) {

                                }
                                if (tpger.equals("Carro")) {

                                }
                                break;
                            case 4:
                                if (tpger.equals("Cliente")) {

                                }
                                if (tpger.equals("Carro")) {

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
