package lab2;

/**
 * Controla a quantidade de tempo online investido por um aluno em uma disciplina específica.
 * Permite comparar o tempo praticado com uma meta ou expectativa de estudo online.
 *
 * @author Pedro Henrique Gouveia de Medeiros
 */
public class RegistroTempoOnline {
    /**
     * Nome da disciplina associada ao registro.
     */
    private String nomeDisciplina;

    /**
     * Tempo online esperado (em horas) a ser dedicado à disciplina.
     */
    private int tempoOnlineEsperado;

    /**
     * Tempo online efetivamente investido (em horas).
     */
    private int tempoOnlineInvestido;

    /**
     * Constrói o registro de tempo online para uma disciplina com um tempo esperado customizado.
     *
     * @param nomeDisciplina      Nome da disciplina.
     * @param tempoOnlineEsperado Tempo online esperado (meta de horas).
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Constrói o registro de tempo online para uma disciplina assumindo
     * a meta padrão de 120 horas esperadas.
     *
     * @param nomeDisciplina Nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * Adiciona horas de estudo ao tempo online investido na disciplina.
     *
     * @param horas Quantidade de horas online a ser incrementada.
     */
    public void adicionaTempoOnline(int horas) {
        tempoOnlineInvestido += horas;
    }

    /**
     * Verifica se a meta de tempo online esperada foi atingida ou ultrapassada.
     *
     * @return {@code true} se o tempo investido for maior ou igual ao tempo esperado;
     *         {@code false} caso contrário.
     */
    public boolean atingiuMetaTempoOnline() {
        if (tempoOnlineInvestido >= tempoOnlineEsperado) {
            return true;
        }
        return false;
    }

    /**
     * Retorna a representação em texto do registro no formato "NOME_DISCIPLINA INVESTIDO/ESPERADO".
     *
     * @return String com o nome da disciplina, tempo investido e tempo esperado.
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnlineInvestido + "/" + tempoOnlineEsperado;
    }
}