package edu.octavio.banco;

public class Main {
    public static void main(String[] args) {
        Cliente octavio = new Cliente();
        octavio.setNome("Octavio");
        Conta corrente = new ContaCorrente(octavio);
        Conta poupanca = new ContaPoupanca(octavio);

        corrente.depositar(100);
        corrente.transferir(100, poupanca);

        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
