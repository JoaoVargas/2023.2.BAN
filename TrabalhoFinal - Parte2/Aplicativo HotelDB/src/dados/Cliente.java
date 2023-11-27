package dados;

public class Cliente {
    private int codCliente;
    private int codPessoa;
    private String emailPessoal;

    public int getCodCliente() {
        return codCliente;
    }
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    public int getCodPessoa() {
        return codPessoa;
    }
    public String getEmailPessoal() {
        return emailPessoal;
    }

    public Cliente(int codPessoa, String emailPessoal) {
        this.codPessoa = codPessoa;
        this.emailPessoal = emailPessoal;
    }
}
