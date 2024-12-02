package org.example;

import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {

    private List<ContaBancaria> contas;

    public SistemaBancario() {
        contas = new ArrayList<>();
    }

    // Criar nova conta
    public void criarConta(String numeroConta, String nomeCliente, String endereco, String telefone, double saldo) {
        ContaBancaria novaConta = new ContaBancaria(numeroConta, nomeCliente, endereco, telefone, saldo);
        contas.add(novaConta);
        System.out.println("Conta criada com sucesso!");
    }

    // Visualizar todas as contas
    public void visualizarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (ContaBancaria conta : contas) {
                System.out.println(conta);
                System.out.println("--------------------------");
            }
        }
    }

    // Atualizar dados da conta
    public void atualizarConta(String numeroConta, String novoEndereco, String novoTelefone) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                conta.setEndereco(novoEndereco);
                conta.setTelefone(novoTelefone);
                System.out.println("Dados da conta atualizados com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    // Excluir conta
    public void excluirConta(String numeroConta) {
        ContaBancaria contaToRemove = null;
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                contaToRemove = conta;
                break;
            }
        }

        if (contaToRemove != null) {
            contas.remove(contaToRemove);
            System.out.println("Conta excluída com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Buscar conta por número
    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }
}
