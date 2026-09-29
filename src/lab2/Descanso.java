package lab2;

public class Descanso {
    private int horasDescanso;
    private int numSemanas;

    public Descanso() {

    }

    public String getStatusGeral() {
        if (horasDescanso / numSemanas < 26) {
            return "cansado";
        } else {
            return "descansado";
        }
    }

    public void defineHorasDescanso(int horas) {
        horasDescanso = horas;
    }

    public void defineNumeroSemanas(int semanas) {
        numSemanas = semanas;
    }
}
