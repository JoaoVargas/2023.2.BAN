package dados;

public class Hospede {
    private int codCliente;
    private int codReserva;

    public int getCodCliente() {
        return codCliente;
    }
    public int getCodReserva() {
        return codReserva;
    }

    public Hospede(int codCliente, int codReserva) {
        this.codCliente = codCliente;
        this.codReserva = codReserva;
    }
}
