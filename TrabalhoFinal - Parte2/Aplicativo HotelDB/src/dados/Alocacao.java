package dados;

public class Alocacao {
    private int codReserva;
    private int codQuarto;
    private String dataCheckIn;
    private String dataCheckOut;

    public int getCodReserva() {
        return codReserva;
    }
    public int getCodQuarto() {
        return codQuarto;
    }
    public String getDataCheckIn() {
        return dataCheckIn;
    }
    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public Alocacao(int codReserva, int codQuarto, String dataCheckIn, String dataCheckOut) {
        this.codReserva = codReserva;
        this.codQuarto = codQuarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }
}
