package lab2;

import java.util.Arrays;

/**
 * Representa o acompanhamento do desempenho acadêmico em uma disciplina.
 * Armazena informações sobre o nome da disciplina, horas de estudo dedicadas,
 * notas obtidas e pesos correspondentes.
 *
 * @author Pedro Henrique Gouveia de Medeiros
 */
public class Disciplina {
    /**
     * Nome da disciplina.
     */
    private String nome;

    /**
     * Quantidade total de notas avaliadas na disciplina.
     */
    private int qtdeNotas;

    /**
     * Array contendo as notas do aluno na disciplina.
     */
    private double[] notas = new double[qtdeNotas];

    /**
     * Quantidade acumulada de horas dedicadas aos estudos da disciplina.
     */
    private int horasEstudo;

    /**
     * Array contendo os pesos respectivos de cada nota.
     */
    private int[] pesoNotas;

    /**
     * Constrói uma disciplina informando apenas o seu nome.
     * Por padrão, a disciplina possui 4 notas com peso 1 cada.
     *
     * @param nome Nome da disciplina.
     */
    public Disciplina(String nome) {
        this.nome = nome;
        this.qtdeNotas = 4;
        this.pesoNotas = new int[] {1, 1, 1, 1};
    }

    /**
     * Constrói uma disciplina informando o nome, a quantidade de notas e os respectivos pesos.
     *
     * @param nome      Nome da disciplina.
     * @param qtdeNotas Quantidade total de notas da disciplina.
     * @param pesoNotas Array com os pesos de cada nota.
     */
    public Disciplina(String nome, int qtdeNotas, int[] pesoNotas) {
        this.nome = nome;
        this.qtdeNotas = qtdeNotas;
        this.pesoNotas = pesoNotas;
    }

    /**
     * Registra ou atualiza as horas de estudo dedicadas à disciplina.
     *
     * @param novoValor Quantidade de horas a ser cadastrada.
     */
    public void cadastraHoras(int novoValor) {
        this.horasEstudo = novoValor;
    }

    /**
     * Cadastra a nota de uma avaliação específica (1-indexada).
     *
     * @param nota      O índice da nota (ex: 1 para a primeira nota, 2 para a segunda).
     * @param valorNota O valor numérico da nota obtida.
     */
    public void cadastrarNota(int nota, double valorNota) {
        nota -= 1;
        notas[nota] = valorNota;
    }

    /**
     * Calcula a média ponderada das notas cadastradas com base nos pesos definidos.
     *
     * @return Média ponderada das notas.
     */
    public double calculaMedia() {
        double soma = 0;
        for (int i = 0; i < pesoNotas.length; i++) {
            soma += pesoNotas[i] * notas[i];
        }
        return soma / Arrays.stream(pesoNotas).sum();
    }

    /**
     * Verifica se o aluno foi aprovado na disciplina.
     * O aluno é considerado aprovado se obtiver média maior ou igual a 7.0.
     *
     * @return {@code true} se o aluno foi aprovado; {@code false} caso contrário.
     */
    public boolean aprovado() {
        return !(this.calculaMedia() < 7.0);
    }

    /**
     * Retorna uma representação em formato de texto da disciplina,
     * incluindo o nome, horas de estudo, média calculada e o conjunto de notas.
     *
     * @return String formatada contendo as informações da disciplina.
     */
    @Override
    public String toString() {
        return nome + " " + 4 + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
}