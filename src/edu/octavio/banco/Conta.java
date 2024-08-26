package edu.octavio.banco;

import java.util.Objects;

public abstract class Conta implements IConta, Comparable<Conta>{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    private final Cliente cliente;

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    public Conta(Cliente cliente) {
        agencia = AGENCIA_PADRAO;
        numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s\n", cliente.getNome());
        System.out.printf("Agência: %d\n", agencia);
        System.out.printf("Conta: %d\n", numero);
        System.out.printf("Saldo: %.2f\n", saldo);
    }

    @Override
    public int compareTo(Conta conta) {
        return Integer.compare(getNumero(), conta.getNumero());
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return getNumero() == conta.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNumero());
    }
}