package dados;

public class Quarto {
    private int codQuarto;
    private String numeroQuarto;
    private boolean tipoLuxo;
    private boolean emManutencao;

    public int getCodQuarto() {
        return codQuarto;
    }
    public void setCodQuarto(int codQuarto) {
        this.codQuarto = codQuarto;
    }
    public String getNumeroQuarto() {
        return numeroQuarto;
    }
    public boolean isTipoLuxo() {
        return tipoLuxo;
    }
    public boolean isEmManutencao() {
        return emManutencao;
    }

    public Quarto(String numeroQuarto, boolean tipoLuxo, boolean emManutencao) {
        this.numeroQuarto = numeroQuarto;
        this.tipoLuxo = tipoLuxo;
        this.emManutencao = emManutencao;
    }
}
