package dados;

public class Alocacao {
    private Reserva reserva;
    private Quarto quarto;
    private String dataCheckIn;
    private String dataCheckOut;

    public Reserva getReserva() {
        return reserva;
    }
    public Quarto getQuarto() {
        return quarto;
    }
    public String getDataCheckIn() {
        return dataCheckIn;
    }
    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public Alocacao(Reserva reserva, Quarto quarto, String dataCheckIn, String dataCheckOut) {
        this.reserva = reserva;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }
}
