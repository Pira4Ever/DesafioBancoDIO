package edu.octavio.banco;

import java.time.LocalDate;

public class Cliente implements Comparable<Cliente> {
    private String nome;
    private final long cpf;
    private final LocalDate nascimento;

    public Cliente(String nome, long cpf, LocalDate nascimento) {
        if (!validarCPF(cpf))
            throw new RuntimeException("Esse CPF é inválido");
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    private boolean validarCPF(long cpf) {
        int[] numeros = new int[11];
        int primeiroVerificador, segundoVerificador;
        int counter = 10;
        while (cpf > 0) {
            numeros[counter] = (int)(cpf % 10);
            cpf /= 10;
            counter--;
        }

        primeiroVerificador = numeros[9];
        segundoVerificador = numeros[10];

        counter = 0;
        int multiplier = 10;
        int soma = 0;

        while (multiplier >= 2) {
            soma += numeros[counter] * multiplier;
            multiplier--;
            counter++;
        }

        soma = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (soma != primeiroVerificador)
            return false;

        soma = 0;
        counter = 0;
        multiplier = 11;

        while (multiplier >= 2) {
            soma += numeros[counter] * multiplier;
            multiplier--;
            counter++;
        }

        soma = soma % 11 < 2 ? 0 : 11 - soma % 11;
        return soma == segundoVerificador;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", nascimento=" + nascimento +
                '}';
    }

    @Override
    public int compareTo(Cliente cliente) {
        return nome.compareTo(cliente.getNome());
    }
}
