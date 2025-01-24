import java.util.Scanner;

import utils.Utils;

import utils.Logg;
import view.Listagem;

import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        menu(scanner);

        scanner.close();
    }

    public static void menu(Scanner scanner) {
        int opcao = 0;

        do {
            Utils.clearScreen();
            Logg.info("--- Bem vindo ao menu principal ---");
            System.out.println("1. Ir para o menu de produtos");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                if (scanner.hasNextInt())
                    scanner.nextLine();
                switch (opcao) {
                    case 1:
                       Listagem.listagemDeProdutos(scanner);
                       break;
                    case 2:
                        Logg.info("Saindo...");
                        break;
                    default:
                        Logg.warning("Opção inválida, tente novamente.");
                }

            } catch (NumberFormatException e) {
                Logg.warning("Informe somente números para a opção.");
            } catch (InputMismatchException e) {
                Logg.warning("Erro: informe um valor válido.");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            } catch (Exception e) {
                Logg.severe("Erro inesperado: " + e.getMessage());
            }
        }while (opcao != 3);
    }
}
