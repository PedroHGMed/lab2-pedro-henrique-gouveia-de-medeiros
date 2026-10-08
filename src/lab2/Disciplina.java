package lab2;

import java.util.Arrays;

public class Disciplina {
    private String nome;
    private int qtdeNotas;
    private double[] notas = new double[qtdeNotas];
    private int horas;
    private int[] pesoNotas;

    public Disciplina(String nome) {
        this.nome = nome;
        this.qtdeNotas = 4;
        this.pesoNotas = new int[] {1, 1, 1, 1};
    }

    public Disciplina(String nome, int qtdeNotas, int[] pesoNotas) {
        this.nome = nome;
        this.qtdeNotas = qtdeNotas;
        this.pesoNotas = pesoNotas;
    }

    public void cadastraHoras(int novoValor) {
        this.horas = novoValor;
    }

    public void cadastraNota(int nota, double valorNota) {
        nota -= 1;
        notas[nota] = valorNota;
    }
    public double calculaMedia() {
        double soma = 0;
        for (int i = 0; i < pesoNotas.length; i++) {
            soma += pesoNotas[i] * notas[i];
        }
        return soma / Arrays.stream(pesoNotas).sum();
    }
    public boolean aprovado() {
        return !(this.calculaMedia() < 7.0);
    }
    @Override
    public String toString() {
        return nome + " " + 4 + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
}
