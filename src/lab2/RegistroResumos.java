package lab2;

public class RegistroResumos {
    private int len;
    private Resumo[] Registro;
    private int iResumo = 0;
    private int numeroDeElementos = 0;
    private boolean jaMudou = false;

    public RegistroResumos(int num) {
        this.len = num;
        Registro = new Resumo[len];
    }

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

    public String[] pegaResumos() {
        String[] arrayResumos = new String[numeroDeElementos];
        for (int i = 0; i < numeroDeElementos; i++) {
            arrayResumos[i] = Registro[i].tema + ": " + Registro[i].conteudo;
        }
        return arrayResumos;
    }

    public int conta() {
        return numeroDeElementos;
    }

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

    public boolean temResumo(String tema) {
        for (int i = 0; i < numeroDeElementos; i++) {
            if (Registro[i].tema.equals("tema")) {
                return true;
            }
        }
        return false;
    }
}
