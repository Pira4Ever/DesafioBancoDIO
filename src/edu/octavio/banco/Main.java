package edu.octavio.banco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banco bancoX = new Banco();

        Cliente octavio = new Cliente("Octavio", 1234567890L, LocalDate.of(2007, 6, 3));
        Conta correnteOctavio = new ContaCorrente(octavio);
        Conta poupancaOctavio = new ContaPoupanca(octavio);

        Cliente joao = new Cliente("João", 85860704089L, LocalDate.of(2007, 6, 16));
        Conta correnteJoao = new ContaCorrente(joao);
        Conta poupancaJoao = new ContaPoupanca(joao);

        Cliente lucas = new Cliente("João", 18478162070L, LocalDate.of(1996, 2, 2));
        Conta correnteLucas = new ContaCorrente(lucas);
        Conta poupancaLucas = new ContaPoupanca(lucas);

        Cliente maria = new Cliente("Maria", 65388580075L, LocalDate.of(1983, 7, 4));
        maria.setNome("Maria");
        Conta correnteMaria = new ContaCorrente(maria);
        Conta poupancaMaria = new ContaPoupanca(maria);

        List<Conta> contasParaAdicionar = new ArrayList<>();
        contasParaAdicionar.add(correnteOctavio);
        contasParaAdicionar.add(poupancaOctavio);
        contasParaAdicionar.add(correnteJoao);
        contasParaAdicionar.add(poupancaJoao);
        contasParaAdicionar.add(correnteLucas);
        contasParaAdicionar.add(poupancaLucas);
        contasParaAdicionar.add(correnteMaria);
        contasParaAdicionar.add(poupancaMaria);

        bancoX.addContas(contasParaAdicionar);

        try {
            Cliente cleber = new Cliente("Cleber", 12398745647L, LocalDate.of(2010, 9, 13));
            Conta correnteCleber = new ContaCorrente(cleber);
            Conta poupancaCleber = new ContaPoupanca(cleber);
            bancoX.addConta(correnteCleber);
            bancoX.addConta(poupancaCleber);

        } catch (RuntimeException e) {
            System.out.println("CPF inválido");
        }

        correnteOctavio.depositar(100);
        correnteOctavio.transferir(100, poupancaOctavio);

        correnteOctavio.imprimirExtrato();
        poupancaOctavio.imprimirExtrato();
        System.out.println("==============================");
        bancoX.listarContasPorNome();
        System.out.println("==============================");
        bancoX.listarContasPorNumero();
        System.out.println("==============================");
        bancoX.listarContasPorSaldo();
        System.out.println("==============================");
        bancoX.listarClientes();
    }
}
