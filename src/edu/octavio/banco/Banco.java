package edu.octavio.banco;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public class Banco {
    @Setter
    private String nome;
    private final List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void addConta(Conta conta) {
        contas.add(conta);
    }

    public void addContas(List<Conta> contas) {
        this.contas.addAll(contas);
    }

    public void listarContasPorNome() {
        contas.stream().sorted(Comparator.comparing(c -> c.getCliente().getNome())).forEach(System.out::println);
    }

    public void listarContasPorNumero() {
        contas.stream().sorted().forEach(System.out::println);
    }

    public void listarContasPorSaldo() {
        contas.stream().sorted(Comparator.comparingDouble(Conta::getSaldo)).forEach(System.out::println);
    }

    public void listarClientes() {
        List<String> nomesJaListados = new ArrayList<>();
        List<Cliente> clientesParaImprimir = new ArrayList<>();
        contas.forEach(c -> {
            String nome = c.getCliente().getNome();
            if(!nomesJaListados.contains(nome)) {
                nomesJaListados.add(nome);
                clientesParaImprimir.add(c.getCliente());
            }
        });

        clientesParaImprimir.stream().sorted().forEach(System.out::println);
    }
}
