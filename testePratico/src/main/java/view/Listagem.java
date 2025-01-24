package view;

import control.ProdutoController;
import model.Produtos;
import utils.Logg;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.InputMismatchException;

public class Listagem {

    private static List<Produtos> produtos = new ArrayList<>();

    public static void listagemDeProdutos(Scanner scanner) {
        int opcao = 0;
        boolean sair = false;

        try {
            do {
                Logg.info("--- Menu de Produtos ---");
                System.out.println("1. Adicionar produto");
                System.out.println("2. Listar produtos");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        adicionarProduto(scanner);
                        break;
                    case 2:
                        listarProdutos(scanner);
                        break;
                    case 3:
                        Logg.info("Saindo do sistema.");
                        sair = true;
                        break;
                    default:
                        Logg.warning("Opção inválida! Tente novamente.");
                        break;
                }
            } while (!sair);
        } catch (IllegalArgumentException e) {
            Logg.warning("Erro: " + e.getMessage());
            Logg.info("Por Favor, tente novamente.");
        } catch (InputMismatchException e) {
            Logg.warning("Erro: informe um valor válido.");
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        } catch (Exception e) {
            Logg.severe("Erro inesperado: " + e.getMessage());
        }
    }

    private static void adicionarProduto(Scanner scanner) {
        boolean produtoCadastrado = false;

        while (!produtoCadastrado) {
            try {
                Logg.info("--- Adicionar produto ---");
                System.out.print("Informe o nome do produto: ");
                String nome = scanner.nextLine();

                System.out.print("Descrição do produto: ");
                String descricao = scanner.nextLine();

                System.out.print("Informe o valor do produto: ");
                double valor = scanner.nextDouble();

                System.out.print("Disponibilidade do produto: ");
                boolean disponibilidade = scanner.nextBoolean();

                ProdutoController.criaProduto(nome, descricao, valor, disponibilidade);
                Logg.info("Produto adicionado com sucesso!");
                produtoCadastrado = true;
            } catch (IllegalArgumentException e) {
                Logg.warning("Erro: " + e.getMessage());
                Logg.info("Por Favor, tente novamente.");
            }
        }
    }

    private static void listarProdutos(Scanner scanner) {
        if(produtos.isEmpty()) {
            Logg.info("\nNão há produtos cadastrados.");
            return;
        }
        try {
            Logg.info("--- Listagem de Produtos ---");
            produtos.sort(Comparator.comparingDouble(Produtos::getValorDoProduto));
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println(produtos.get(i).toString());
            }
        }catch (Exception e) {
            Logg.severe("Erro: " + e.getMessage());
            Logg.info("Por Favor, tente novamente.");
        }
    }
}
