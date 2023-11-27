package dados;

public class Hospede {
    private Cliente cliente;
    private Reserva reserva;

    public Cliente getCliente() {
        return cliente;
    }
    public Reserva getReserva() {
        return reserva;
    }

    public Hospede(Cliente cliente, Reserva reserva) {
        this.cliente = cliente;
        this.reserva = reserva;
    }
}
