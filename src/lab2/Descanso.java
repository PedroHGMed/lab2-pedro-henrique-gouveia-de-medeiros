package lab2;

public class Descanso {
    private int horasDescanso;
    private int numSemanas;

    public Descanso() {
        this.horasDescanso = 0;
        this.numSemanas = 1;
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
