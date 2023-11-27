package negocio;

import dados.*;
import database.FuncoesDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.LinkedList;

public class Sistema {
    private LinkedList<Pessoa> listaPessoas = new LinkedList<>();
    private LinkedList<Cliente> listaClientes = new LinkedList<>();
    private LinkedList<Hospede> listaHospedes = new LinkedList<>();
    private LinkedList<Responsavel> listaResponsaveis = new LinkedList<>();
    private LinkedList<Reserva> listaReservas = new LinkedList<>();
    private LinkedList<Quarto> listaQuartos = new LinkedList<>();
    private LinkedList<Alocacao> listaAlocacoes = new LinkedList<>();

    FuncoesDB db = new FuncoesDB();
    Connection con = db.conectarDB("HotelDB-JoaoGuilhermeVargas", "postgres", "230505");

    public Sistema(){
        inicializarListas();
    }

    public void inicializarListas(){
        inicializarPessoas();
        inicializarClientes();
        inicializarHospedes();
        inicializarResponsaveis();
        inicializarReservas();
        inicializarQuartos();
        inicializarAlocacoes();
    }
    private void inicializarPessoas() {
        try {
            ResultSet rs = db.listarTabela(con, "Pessoas", "codPessoa");

            if (rs == null){
                System.out.println("Erro: ResultSet vazio, inicializarPessoas()");
                return;
            }

            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                listaPessoas.add(criarPessoa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void inicializarClientes() {
        try {
            ResultSet rs = db.listarTabela(con, "Clientes", "codCliente");

            if (rs == null){
                System.out.println("Erro: ResultSet vazio, inicializarClientes()");
                return;
            }

            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                listaClientes.add(criarCliente(rs.getInt(1), acharPessoa(rs.getInt(2)), rs.getString(3)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void inicializarHospedes() {
        try {
            ResultSet rs = db.listarTabela(con, "Hospedes", "codReserva");

            if (rs == null){
                System.out.println("Erro: ResultSet vazio, inicializarHospedes()");
                return;
            }

            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                listaHospedes.add(criarHospede(acharCliente(rs.getInt(1)), acharReserva(rs.getInt(2))));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void inicializarResponsaveis() {
        try {
            ResultSet rs = db.listarTabela(con, "Responsaveis", "codReserva");

            if (rs == null){
                System.out.println("Erro: ResultSet vazio, inicializarResponsaveis()");
                return;
            }

            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                listaResponsaveis.add(criarResponsavel(acharCliente(rs.getInt(1)), acharReserva(rs.getInt(2))));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void inicializarReservas() {
        try {
            ResultSet rs = db.listarTabela(con, "Reservas", "codReserva");

            if (rs == null){
                System.out.println("Erro: ResultSet vazio, inicializarReservas()");
                return;
            }

            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                listaReservas.add(criarReserva(rs.getInt(1), rs.getString(2)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void inicializarQuartos() {
        try {
            ResultSet rs = db.listarTabela(con, "Quartos", "codQuarto");

            if (rs == null){
                System.out.println("Erro: ResultSet vazio, inicializarQuartos()");
                return;
            }

            ResultSetMetaData md = rs.getMetaData();

//            while (rs.next()) {
//                for (int i = 1; i <= md.getColumnCount(); i++) {
//                    System.out.print(rs.getString(i) + " ");
//                }
//                System.out.println();
//            }

            while (rs.next()) {
                listaQuartos.add(criarQuarto(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getBoolean(4)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void inicializarAlocacoes() {
        try {
            ResultSet rs = db.listarTabela(con, "Alocacoes", "codReserva");

            if (rs == null){
                System.out.println("Erro: ResultSet vazio, inicializarAlocacoes()");
                return;
            }

            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                listaAlocacoes.add(criarAlocacao(acharReserva(rs.getInt(1)), acharQuarto(rs.getInt(2)), rs.getString(3), rs.getString(4)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private Pessoa criarPessoa(int codPessoa, String nome, String cpf, String sexo, String cep, String telefone){
        Pessoa p = new Pessoa(nome, cpf, sexo, cep, telefone);
        p.setCodPessoa(codPessoa);

        return p;
    }
    private Cliente criarCliente(int codCliente, Pessoa pessoa, String emailPessoal){
        Cliente c = new Cliente(emailPessoal, pessoa);
        c.setCodCliente(codCliente);

        return c;
    }
    private Hospede criarHospede(Cliente cliente, Reserva reserva){
        Hospede h = new Hospede(cliente, reserva);

        return h;
    }
    private Responsavel criarResponsavel(Cliente cliente, Reserva reserva){
        Responsavel r = new Responsavel(cliente, reserva);

        return r;

    }
    private Reserva criarReserva(int codReserva, String dataRealizada){
        Reserva r = new Reserva(dataRealizada);
        r.setCodReserva(codReserva);

        return r;
    }
    private Quarto criarQuarto(int codQuarto, String numeroQuarto, boolean tipoLuxo, boolean emManutencao) {
        Quarto q = new Quarto(numeroQuarto, tipoLuxo, emManutencao);
        q.setCodQuarto(codQuarto);

        return q;
    }
    private Alocacao criarAlocacao(Reserva reserva, Quarto quarto, String dataCheckIn, String dataCheckOut){
        Alocacao a = new Alocacao(reserva, quarto, dataCheckIn, dataCheckOut);

        return a;
    }

    private Pessoa acharPessoa(int codPessoa){
        for (Pessoa p : listaPessoas) {
            if (p.getCodPessoa() == codPessoa) {
                return p;
            }
        }

        return null;
    }
    private Cliente acharCliente(int codCliente){
        for (Cliente c : listaClientes) {
            if (c.getCodCliente() == codCliente) {
                return c;
            }
        }

        return null;
    }
    private Reserva acharReserva(int codReserva){
        for (Reserva r : listaReservas) {
            if (r.getCodReserva() == codReserva) {
                return r;
            }
        }

        return null;
    }
    private Quarto acharQuarto(int codQuarto){
        for (Quarto q : listaQuartos) {
            if (q.getCodQuarto() == codQuarto) {
                return q;
            }
        }

        return null;
    }

    public void listarPessoas(){
        for (Pessoa p : listaPessoas) {
//            System.out.println(p.getCodPessoa() + " " + p.getCpf() + " " + p.getNome());
            System.out.println("[%s] %s - %s". formatted(p.getCodPessoa(), p.getCpf(), p.getNome()));
        }
    }
    public void listarClientes(){
        for (Cliente c : listaClientes) {
//            System.out.println(c.getCodCliente() + " " + c.getPessoa().getCodPessoa() + " " + c.getPessoa().getCpf() + " " + c.getPessoa().getNome());
            System.out.println("[%s] ([%s] %s - %s)". formatted(c.getCodCliente(), c.getPessoa().getCodPessoa(), c.getPessoa().getCpf(), c.getPessoa().getNome()));
        }
    }
    public void listarHospedes(){
        for (Hospede h : listaHospedes) {
            System.out.println(h.getCliente().getCodCliente() + " " + h.getReserva().getCodReserva());
        }
    }
    public void listarResponsaveis(){
        for (Responsavel r : listaResponsaveis) {
            System.out.println(r.getCliente().getCodCliente() + " " + r.getReserva().getCodReserva());
        }
    }
    public void listarReservas(){
        for (Reserva r : listaReservas) {
            System.out.println(r.getCodReserva() + " " + r.getDataRealizada());
        }
    }
    public void listarQuartos(){
        for (Quarto q : listaQuartos) {
            System.out.println("[%s] %s". formatted(q.getCodQuarto(), q.getNumeroQuarto()));
        }
    }
    public void listarAlocacoes(){
        for (Alocacao a : listaAlocacoes) {
            System.out.println(a.getReserva().getCodReserva() + " " + a.getQuarto().getCodQuarto() + " " + a.getDataCheckIn() + " " + a.getDataCheckOut());
        }
    }

    public int adicionarPessoa(Pessoa p){
        int chave = db.inserirPessoa(con, p);

        if (chave == -1){
            return 0;
        }

        p.setCodPessoa(chave);

        listaPessoas.add(p);

        return 1;
    }
    public int adicionarCliente(Cliente c){
        int chave = db.inserirCliente(con, c);

        if (chave == -1){
            return 0;
        }

        c.setCodCliente(chave);

        listaClientes.add(c);

        return 1;
    }
}
