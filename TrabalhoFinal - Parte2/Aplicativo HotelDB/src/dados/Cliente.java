package dados;

public class Cliente {
    private int codCliente;
    private Pessoa pessoa;
    private String emailPessoal;

    public int getCodCliente() {
        return codCliente;
    }
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public String getEmailPessoal() {
        return emailPessoal;
    }

    public Cliente(String emailPessoal, Pessoa pessoa) {
        this.emailPessoal = emailPessoal;
        this.pessoa = pessoa;
    }
}
