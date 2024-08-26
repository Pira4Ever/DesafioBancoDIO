package edu.octavio.banco;

public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;

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

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s\n", cliente.getNome());
        System.out.printf("Agência: %d\n", agencia);
        System.out.printf("Conta: %d\n", numero);
        System.out.printf("Saldo: %.2f\n", saldo);
    }
}
