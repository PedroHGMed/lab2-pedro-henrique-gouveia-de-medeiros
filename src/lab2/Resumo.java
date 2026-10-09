package lab2;

/**
 * Representa um resumo individual de estudos, composto por um tema e seu respectivo conteúdo.
 *
 * @author Pedro Henrique Gouveia de Medeiros
 */
public class Resumo {
    /**
     * Tema ou título do resumo.
     */
    private String tema;

    /**
     * Conteúdo descritivo do resumo.
     */
    private String conteudo;

    /**
     * Constrói um resumo com tema e conteúdo especificados.
     *
     * @param tema     O tema ou título do resumo.
     * @param conteudo O texto do resumo.
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema ou título do resumo.
     *
     * @return O tema do resumo.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Retorna o conteúdo descritivo do resumo.
     *
     * @return O conteúdo do resumo.
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Retorna o tema do resumo.
     *
     * @return O tema do resumo.
     */
    @Override
    public String toString() {
        return this.tema;
    }
}