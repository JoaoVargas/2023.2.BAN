package dados;

public class Responsavel {
    private int codCliente;
    private int codReserva;

    public int getCodCliente() {
        return codCliente;
    }
    public int getCodReserva() {
        return codReserva;
    }

    public Responsavel(int codCliente, int codReserva) {
        this.codCliente = codCliente;
        this.codReserva = codReserva;
    }
}
