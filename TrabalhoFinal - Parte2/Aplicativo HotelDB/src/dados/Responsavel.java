package dados;

public class Responsavel {
    private Cliente cliente;
    private Reserva reserva;

    public Cliente getCliente() {
        return cliente;
    }
    public Reserva getReserva() {
        return reserva;
    }

    public Responsavel(Cliente cliente, Reserva reserva) {
        this.cliente = cliente;
        this.reserva = reserva;
    }
}
