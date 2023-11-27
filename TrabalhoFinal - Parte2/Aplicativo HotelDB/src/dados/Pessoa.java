package dados;

public class Pessoa {
    private int codPessoa;
    private String nome;
    private String cpf;
    private String sexo;
    private String cep;
    private String telefone;

    public int getCodPessoa() {
        return codPessoa;
    }
    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getSexo() {
        return sexo;
    }
    public String getCep() {
        return cep;
    }
    public String getTelefone() {
        return telefone;
    }

    public Pessoa(String nome, String cpf, String sexo, String cep, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.cep = cep;
        this.telefone = telefone;
    }
}
