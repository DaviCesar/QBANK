package org.example;

public class Emprestimo {
  private String numeroConta;
  private double valorEmprestimo;
  private int parcelas;
  private double taxaJurosAnual;
  private double valorParcela;
  private double valorTotal;
  private int parcelasPagas;

  // Construtor
  public Emprestimo(String numeroConta, double valorEmprestimo, int parcelas, double taxaJurosAnual,
      double valorParcela, double valorTotal) {
    this.numeroConta = numeroConta;
    this.valorEmprestimo = valorEmprestimo;
    this.parcelas = parcelas;
    this.taxaJurosAnual = taxaJurosAnual;
    this.valorParcela = valorParcela;
    this.valorTotal = valorTotal;
    this.parcelasPagas = 0; // Inicialmente nenhuma parcela foi paga
  }

  // Getters e Setters
  public String getNumeroConta() {
    return numeroConta;
  }

  public double getValorEmprestimo() {
    return valorEmprestimo;
  }

  public int getParcelas() {
    return parcelas;
  }

  public double getTaxaJurosAnual() {
    return taxaJurosAnual;
  }

  public double getValorParcela() {
    return valorParcela;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public int getParcelasPagas() {
    return parcelasPagas;
  }

  // Métodos de Operação
  public void pagarParcela() {
    if (parcelasPagas >= parcelas) {
      throw new IllegalStateException("Todas as parcelas já foram pagas.");
    }
    parcelasPagas++;
  }

  public double calcularSaldoRestante() {
    return valorTotal - (valorParcela * parcelasPagas);
  }

  @Override
  public String toString() {
    return "Emprestimo{" +
        "Conta='" + numeroConta + '\'' +
        ", Valor Emprestado=R$" + String.format("%.2f", valorEmprestimo) +
        ", Parcelas=" + parcelas +
        ", Juros Anual=" + String.format("%.2f", taxaJurosAnual) + "%" +
        ", Valor da Parcela=R$" + String.format("%.2f", valorParcela) +
        ", Valor Total=R$" + String.format("%.2f", valorTotal) +
        ", Parcelas Pagas=" + parcelasPagas +
        ", Saldo Restante=R$" + String.format("%.2f", calcularSaldoRestante()) +
        '}';
  }
}
