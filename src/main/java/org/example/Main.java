package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaBancario sistema = new SistemaBancario();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Visualizar contas");
            System.out.println("3. Atualizar dados da conta");
            System.out.println("4. Excluir conta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    String numeroConta = scanner.nextLine();
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = scanner.nextDouble();
                    sistema.criarConta(numeroConta, nomeCliente, endereco, telefone, saldo);
                    break;

                case 2:
                    sistema.visualizarContas();
                    break;

                case 3:
                    System.out.print("Número da conta para atualizar: ");
                    String contaAtualizar = scanner.nextLine();
                    System.out.print("Novo endereço: ");
                    String novoEndereco = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    sistema.atualizarConta(contaAtualizar, novoEndereco, novoTelefone);
                    break;

                case 4:
                    System.out.print("Número da conta para excluir: ");
                    String contaExcluir = scanner.nextLine();
                    sistema.excluirConta(contaExcluir);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}