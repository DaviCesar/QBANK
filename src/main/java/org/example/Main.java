package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaBancario sistema = new SistemaBancario();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Visualizar contas");
            System.out.println("3. Atualizar dados da conta");
            System.out.println("4. Excluir conta");
            System.out.println("5. Transferências");
            System.out.println("6. Empréstimos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer do scanner

            switch (opcao) {
                case 1: // Criar nova conta
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

                case 2: // Visualizar contas
                    sistema.visualizarContas();
                    break;

                case 3: // Atualizar dados da conta
                    System.out.print("Número da conta para atualizar: ");
                    String contaAtualizar = scanner.nextLine();
                    System.out.print("Novo endereço: ");
                    String novoEndereco = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    sistema.atualizarConta(contaAtualizar, novoEndereco, novoTelefone);
                    break;

                case 4: // Excluir conta
                    System.out.print("Número da conta para excluir: ");
                    String contaExcluir = scanner.nextLine();
                    sistema.excluirConta(contaExcluir);
                    break;

                case 5: // Transferências
                    System.out.println("1. Entre contas próprias");
                    System.out.println("2. Para terceiros");
                    System.out.println("3. Para outro banco");
                    System.out.print("Escolha uma opção: ");
                    int tipoTransferencia = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    System.out.print("Número da conta de origem: ");
                    String contaOrigem = scanner.nextLine();
                    System.out.print("Valor a transferir: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer

                    switch (tipoTransferencia) {
                        case 1: // Entre contas próprias
                            System.out.print("Número da conta de destino: ");
                            String contaDestino = scanner.nextLine();
                            sistema.transferirEntreContasProprias(contaOrigem, contaDestino, valor);
                            break;
                        case 2: // Para terceiros
                            System.out.print("Número da conta de destino: ");
                            String contaDestinoTerceiro = scanner.nextLine();
                            sistema.transferirParaTerceiros(contaOrigem, contaDestinoTerceiro, valor);
                            break;
                        case 3: // Para outro banco
                            System.out.print("Banco de destino: ");
                            String bancoDestino = scanner.nextLine();
                            System.out.print("Número da conta de destino: ");
                            String contaDestinoOutroBanco = scanner.nextLine();
                            sistema.transferirParaOutroBanco(contaOrigem, bancoDestino, contaDestinoOutroBanco, valor);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 6: // Empréstimos
                    System.out.println("1. Solicitar empréstimo");
                    System.out.println("2. Pagar parcela de empréstimo");
                    System.out.println("3. Visualizar empréstimo");
                    System.out.print("Escolha uma opção: ");
                    int opcaoEmprestimo = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    switch (opcaoEmprestimo) {
                        case 1: // Solicitar empréstimo
                            System.out.print("Número da conta: ");
                            String contaEmprestimo = scanner.nextLine();
                            System.out.print("Valor do empréstimo: ");
                            double valorEmprestimo = scanner.nextDouble();
                            System.out.print("Número de parcelas: ");
                            int parcelas = scanner.nextInt();
                            System.out.print("Taxa de juros anual (em %): ");
                            double taxaJuros = scanner.nextDouble();
                            sistema.solicitarEmprestimo(contaEmprestimo, valorEmprestimo, parcelas, taxaJuros);
                            break;

                        case 2: // Pagar parcela de empréstimo
                            System.out.print("Número da conta: ");
                            String contaPagamento = scanner.nextLine();
                            System.out.print("Número da parcela: ");
                            int numeroParcela = scanner.nextInt();
                            System.out.print("Valor da parcela: ");
                            double valorParcela = scanner.nextDouble();
                            sistema.pagarParcelaEmprestimo(contaPagamento, numeroParcela, valorParcela);
                            break;

                        case 3: // Visualizar empréstimo
                            System.out.print("Número da conta: ");
                            String contaVisualizar = scanner.nextLine();
                            sistema.visualizarEmprestimo(contaVisualizar);
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 7: // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default: // Opção inválida
                    System.out.println("Opção inválida!");
            }
        }
    }
}
