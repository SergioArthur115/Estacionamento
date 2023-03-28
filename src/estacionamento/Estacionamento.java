package estacionamento;

public class Estacionamento {
    public static void Menu() { // Inicio MENU
        System.out.println("+--------------------+");
        System.out.println("|   ESTACIONAMENTO   |");
        System.out.println("+--------------------+");
        System.out.println("|                    |");
        System.out.println("| 1 - Ger. Cliente   |");
        System.out.println("| 2 - Ger. Carro     |");
        System.out.println("| 1 - Listar dados   |");
        System.out.println("|                    |");
        System.out.println("+--------------------+");
        System.out.print("  Escolha uma opção: ");
    }// Fim MENU

    public static void SubMenu(int op) {// Inicio SUBMENU
        String tpger = null;
        switch (op) {
            case 1:
                tpger = "Cliente";
                break;
            case 2:
                tpger = "Carro";
                break;
        }
        System.out.println("+--------------------+");
        System.out.println("|   GERENCIAMENTO    |");
        System.out.println("+--------------------+");
        System.out.println("|                    |");
        System.out.println("| 1 - Cadastrar " + tpger + "|");
        System.out.println("| 1 - Editar " + tpger + "|");
        System.out.println("| 1 - Listar " + tpger + "|");
        System.out.println("| 1 - Remover " + tpger + "|");
        System.out.println("+--------------------+");
        System.out.print("  Escolha uma opção: ");
    }// Fim SUBMENU

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
