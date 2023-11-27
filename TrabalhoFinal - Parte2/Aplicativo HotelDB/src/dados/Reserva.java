package dados;

public class Reserva {
    private int codReserva;
    private String dataRealizada;

    public int getCodReserva() {
        return codReserva;
    }
    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }
    public String getDataRealizada() {
        return dataRealizada;
    }

    public Reserva(String dataRealizada) {
        this.dataRealizada = dataRealizada;
    }
}
