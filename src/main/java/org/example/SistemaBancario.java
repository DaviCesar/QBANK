package org.example;

import java.util.HashMap;
import java.util.Map;

public class SistemaBancario {
    private Map<String, Conta> contas = new HashMap<>();
    private Map<String, Emprestimo> emprestimos = new HashMap<>();

    // Criar uma nova conta
    public void criarConta(String numeroConta, String nomeCliente, String endereco, String telefone,
            double saldoInicial) {
        if (contas.containsKey(numeroConta)) {
            System.out.println("Conta já existe.");
            return;
        }
        Conta novaConta = new Conta(numeroConta, nomeCliente, endereco, telefone, saldoInicial);
        contas.put(numeroConta, novaConta);
        System.out.println("Conta criada com sucesso!");
    }

    // Visualizar todas as contas
    public void visualizarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            contas.values().forEach(System.out::println);
        }
    }

    // Atualizar dados de uma conta
    public void atualizarConta(String numeroConta, String novoEndereco, String novoTelefone) {
        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        conta.setEndereco(novoEndereco);
        conta.setTelefone(novoTelefone);
        System.out.println("Dados atualizados com sucesso!");
    }

    // Excluir uma conta
    public void excluirConta(String numeroConta) {
        if (contas.remove(numeroConta) != null) {
            System.out.println("Conta excluída com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Transferências entre contas próprias
    public void transferirEntreContasProprias(String contaOrigem, String contaDestino, double valor) {
        Conta origem = contas.get(contaOrigem);
        Conta destino = contas.get(contaDestino);

        if (origem == null || destino == null) {
            System.out.println("Conta de origem ou destino não encontrada.");
            return;
        }

        try {
            origem.debitar(valor);
            destino.creditar(valor);
            System.out.println("Transferência realizada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na transferência: " + e.getMessage());
        }
    }

    // Transferências para terceiros
    public void transferirParaTerceiros(String contaOrigem, String contaDestino, double valor) {
        transferirEntreContasProprias(contaOrigem, contaDestino, valor);
    }

    // Transferências para outro banco
    public void transferirParaOutroBanco(String contaOrigem, String bancoDestino, String contaDestinoOutroBanco,
            double valor) {
        Conta origem = contas.get(contaOrigem);

        if (origem == null) {
            System.out.println("Conta de origem não encontrada.");
            return;
        }

        try {
            origem.debitar(valor);
            System.out.println("Transferência para o banco " + bancoDestino + " realizada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na transferência: " + e.getMessage());
        }
    }

    // Solicitar um empréstimo
    public void solicitarEmprestimo(String numeroConta, double valorEmprestimo, int parcelas, double taxaJuros) {
        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        // Calcular o valor mensal e o total do empréstimo
        double taxaMensal = taxaJuros / 12 / 100;
        double valorParcela = (valorEmprestimo * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -parcelas));
        double valorTotal = valorParcela * parcelas;

        // Registrar o empréstimo
        Emprestimo emprestimo = new Emprestimo(numeroConta, valorEmprestimo, parcelas, taxaJuros, valorParcela,
                valorTotal);
        emprestimos.put(numeroConta, emprestimo);

        // Adicionar o valor do empréstimo ao saldo da conta
        conta.creditar(valorEmprestimo);

        System.out.println("Empréstimo aprovado!");
        System.out.println("Valor do Empréstimo: R$" + String.format("%.2f", valorEmprestimo));
        System.out.println("Número de Parcelas: " + parcelas);
        System.out.println("Valor da Parcela: R$" + String.format("%.2f", valorParcela));
        System.out.println("Valor Total a Pagar: R$" + String.format("%.2f", valorTotal));
    }

    // Pagar uma parcela de empréstimo
    public void pagarParcelaEmprestimo(String numeroConta, int numeroParcela, double valorParcela) {
        Emprestimo emprestimo = emprestimos.get(numeroConta);
        if (emprestimo == null) {
            System.out.println("Nenhum empréstimo encontrado para esta conta.");
            return;
        }

        if (numeroParcela > emprestimo.getParcelasPagas() + 1) {
            System.out.println("Parcela inválida. Pagamento fora de ordem.");
            return;
        }

        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        try {
            conta.debitar(valorParcela);
            emprestimo.pagarParcela();
            System.out.println("Parcela paga com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no pagamento: " + e.getMessage());
        }
    }

    // Visualizar detalhes de um empréstimo
    public void visualizarEmprestimo(String numeroConta) {
        Emprestimo emprestimo = emprestimos.get(numeroConta);
        if (emprestimo == null) {
            System.out.println("Nenhum empréstimo encontrado para esta conta.");
        } else {
            System.out.println(emprestimo);
        }
    }
}
