package lab2;

import java.util.Arrays;

/**
 * Gerencia uma coleção de resumos de estudos armazenados em um limite fixo.
 * Quando o limite de resumos é alcançado, novos resumos sobrescrevem os mais antigos em ciclo.
 *
 * @author Pedro Henrique Gouveia de Medeiros
 */
public class RegistroResumos {
    /**
     * Capacidade máxima de resumos suportada pelo registro.
     */
    private int len;

    /**
     * Array com os resumos cadastrados.
     */
    private Resumo[] Registro;

    /**
     * Índice atual onde o próximo resumo será cadastrado.
     */
    private int iResumo = 0;

    /**
     * Quantidade total de resumos únicos cadastrados até o momento (limitado ao valor de len).
     */
    private int numeroDeElementos = 0;

    /**
     * Flag que indica se o repositório já atingiu a capacidade máxima e começou a sobrescrever.
     */
    private boolean jaMudou = false;

    /**
     * Constrói um gerenciador de resumos indicando a capacidade máxima suportada.
     *
     * @param num Capacidade máxima de resumos a serem armazenados.
     */
    public RegistroResumos(int num) {
        this.len = num;
        Registro = new Resumo[len];
    }

    /**
     * Adiciona um novo resumo informando o tema e o conteúdo.
     * Se já existir um resumo com o mesmo tema, o novo não será inserido.
     * Se a capacidade máxima for atingida, a inserção sobrescreverá os registros mais antigos.
     *
     * @param tema     O tema do resumo.
     * @param conteudo O conteúdo textual do resumo.
     */
    public void adiciona(String tema, String conteudo) {
        if (!temResumo(tema)) {
            Registro[iResumo] = new Resumo(tema, conteudo);
            if (iResumo + 1 == len) {
                iResumo = 0;
                if (!jaMudou) {
                    numeroDeElementos++;
                }
                jaMudou = true;
            } else {
                iResumo++;
                if (!jaMudou) {
                    numeroDeElementos++;
                }
            }
        }
    }

    /**
     * Retorna um array com a representação textual de cada resumo no formato "Tema: Conteúdo".
     *
     * @return Array de Strings com os resumos armazenados.
     */
    public String[] pegaResumos() {
        String[] arrayResumos = new String[numeroDeElementos];
        for (int i = 0; i < numeroDeElementos; i++) {
            arrayResumos[i] = Registro[i].getTema() + ": " + Registro[i].getConteudo();
        }
        return arrayResumos;
    }

    /**
     * Retorna a quantidade atual de resumos armazenados.
     *
     * @return Número de resumos presentes no registro.
     */
    public int contaResumos() {
        return numeroDeElementos;
    }

    /**
     * Retorna uma String formatada contendo a quantidade de resumos cadastrados
     * e a lista de seus temas separados por barra vertical.
     *
     * @return String formatada com a visão geral dos resumos.
     */
    public String imprimeResumos() {
        String buffer = "- ";
        buffer += numeroDeElementos;
        buffer += " resumo(s) cadastrado(s)\n- ";
        for (int i = 0; i < numeroDeElementos; i++) {
            buffer += Registro[i];
            buffer += " | ";
        }
        buffer = buffer.substring(0, buffer.length() - 3);
        return buffer;
    }

    /**
     * Verifica se existe algum resumo cadastrado com o tema informado.
     *
     * @param tema O tema a ser pesquisado.
     * @return {@code true} se o tema estiver presente; {@code false} caso contrário.
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < numeroDeElementos; i++) {
            if (Registro[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Realiza uma busca nos resumos cadastrados verificando se o termo/subcadena informada
     * está contida no conteúdo do resumo. Retorna os temas dos resumos encontrados ordenados alfabeticamente.
     *
     * @param chaveDeBusca O termo/substring a ser pesquisado no conteúdo.
     * @return Array de Strings contendo os temas dos resumos encontrados, ordenados sem diferenciação de caixa.
     */
    public String[] busca(String chaveDeBusca) {
        String[] tempArray = new String[0];
        int indexArray = 0;
        for (Resumo i : Registro) {
            if (i == null) break;

            if (i.getConteudo().contains(chaveDeBusca)) {
                tempArray = Arrays.copyOf(tempArray, indexArray + 1);
                tempArray[indexArray++] = i.getTema();
            }
        }
        Arrays.sort(tempArray, String.CASE_INSENSITIVE_ORDER);
        return tempArray;
    }
}