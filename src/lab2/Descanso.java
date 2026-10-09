package lab2;

/**
 * Representa o controle da rotina de descanso de um aluno.
 * Acompanha as horas de descanso acumuladas e a quantidade de semanas
 * para determinar se o aluno está descansado ou cansado.
 *
 * @author Pedro Henrique Gouveia de Medeiros
 */
public class Descanso {
    /**
     * Quantidade total de horas de descanso registradas.
     */
    private int horasDescanso;

    /**
     * Número de semanas consideradas no cálculo do descanso.
     */
    private int numSemanas;

    /**
     * Constrói uma nova instância de Descanso.
     * Por padrão, inicia com 0 horas de descanso e 1 semana.
     */
    public Descanso() {
        this.horasDescanso = 0;
        this.numSemanas = 1;
    }

    /**
     * Retorna o status geral da rotina de descanso do aluno.
     * O aluno é considerado "descansado" se a média de descanso for de pelo menos 26 horas por semana;
     * caso contrário, é considerado "cansado".
     *
     * @return {@code "descansado"} se a média de horas por semana for maior ou igual a 26,
     *         ou {@code "cansado"} caso contrário.
     */
    public String getStatusGeral() {
        if (horasDescanso / numSemanas < 26) {
            return "cansado";
        } else {
            return "descansado";
        }
    }

    /**
     * Define a quantidade total de horas de descanso.
     *
     * @param horas Quantidade de horas de descanso a ser registrada.
     */
    public void defineHorasDescanso(int horas) {
        horasDescanso = horas;
    }

    /**
     * Define a quantidade de semanas a ser considerada no cálculo do descanso.
     *
     * @param semanas Número de semanas acumuladas.
     */
    public void defineNumeroSemanas(int semanas) {
        numSemanas = semanas;
    }
}