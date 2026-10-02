package lab2;

public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnlineEsperado;
    private int tempoOnlineInvestido;

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    public void adicionaTempoOnline(int i) {
        tempoOnlineInvestido += i;
    }

    public boolean atingiuMetaTempoOnline() {
        if (tempoOnlineInvestido >= tempoOnlineEsperado) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnlineInvestido + "/" + tempoOnlineEsperado;
    }
}
