package lab2;

import java.util.Arrays;

public class Disciplina {
    private String nome;
    private double[] notas = new double[4];
    private int horas;
    public Disciplina(String nome) {
        this.nome = nome;
    }
    public void cadastraHoras(int i) {
        horas = i;
    }

    public void cadastraNota(int nota, double valorNota) {
        nota -= 1;
        notas[nota] = valorNota;
    }
    public double calculaMedia() {
        return Arrays.stream(notas).sum();
    }
    public boolean aprovado() {
        if (this.calculaMedia() < 7.0) {
            return false;
        }
        return true;
    }
}
