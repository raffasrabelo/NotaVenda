package view;

import entidade.Produto; // Certifique-se de que o caminho está correto
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite o nome do produto (ou 'sair' para encerrar): ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite a quantidade de " + nome + ": ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite o preço unitário de " + nome + ": R$ ");
            double precoUnitario = Double.parseDouble(scanner.nextLine());
            produtos.add(new Produto(nome, quantidade, precoUnitario));
        }

        exibirNotaVenda(produtos);
    }

    private static void exibirNotaVenda(List<Produto> produtos) {
        System.out.println("\n=== Nota de Venda ===");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Produto", "Quantidade", "Preço Unit.", "Total");
        System.out.println("-".repeat(60));

        double valorTotal = 0;

        for (Produto produto : produtos) {
            double total = produto.calcularTotal();
            valorTotal += total;
            System.out.printf("%-20s %-10d R$ %-9.2f R$ %-10.2f%n", 
                              produto.getNome(), 
                              produto.getQuantidade(), 
                              produto.getPrecoUnitario(), 
                              total);
        }

        System.out.println("-".repeat(60));
        System.out.printf("Valor Total da Venda: R$ %.2f%n", valorTotal);
        System.out.println("=======================");
    }
}
